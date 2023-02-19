package com.example.ecommerce.service;

import com.example.ecommerce.dao.OrderRepository;
import com.example.ecommerce.model.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService{
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public int placeOrder(Order orderData) {
        Order order=orderRepository.save(orderData);
        return order.getOrderId();
    }

    @Override
    public Order getOrderById(Integer orderId) {
        return orderRepository.findById(orderId).get();
    }
}
