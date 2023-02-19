package com.example.ecommerce.controller;

import com.example.ecommerce.dao.AddressRepository;
import com.example.ecommerce.dao.ProductRepository;
import com.example.ecommerce.dao.UserRepository;
import com.example.ecommerce.model.Address;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.User;
import com.example.ecommerce.service.IOrderService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/ecommerce-app")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AddressRepository addressRepository;

    @PostMapping("/order")
    public ResponseEntity addOrder(@RequestBody String orderData)
    {
        JSONObject json=new JSONObject(orderData);
        Order order=setOrder(json);
        int orderId=orderService.placeOrder(order);
        return new ResponseEntity<>("Order has been Placed with order id- "+orderId, HttpStatus.CREATED);
    }

    @GetMapping("/order")
    public Order getOrderById(@RequestParam Integer orderId){
        return orderService.getOrderById(orderId);
    }

    private Order setOrder(JSONObject json){
        Order order=new Order();
        order.setProductQuantity(json.getInt("productQuantity"));

        Integer userId=json.getInt("user");
        User user=userRepository.findById(userId).get();
        order.setUser(user);

        Integer productId=json.getInt("product");
        Product product=productRepository.findById(productId).get();
        order.setProduct(product);

        Integer addressId=json.getInt("address");
        Address address=addressRepository.findById(addressId).get();
        order.setAddress(address);

        return order;
    }
}

