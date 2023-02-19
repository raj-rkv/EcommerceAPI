package com.example.ecommerce.controller;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.IProductService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ecommerce-app")
public class ProductController {
    @Autowired
    private IProductService productService;

    @PostMapping("/product")
    public ResponseEntity createProduct(@RequestBody Product productData)
    {
        int productId=productService.addProduct(productData);
        return new ResponseEntity<>("Product create with product id- "+productId, HttpStatus.CREATED);

    }

    @GetMapping("/product")
    public List<Product> getProduct(@Nullable @RequestParam String category){
        if(category!=null)
        {
            return productService.getProductByCategory(category);
        }
        else{
            return productService.getAllProduct();
        }
    }

    @DeleteMapping("/product")
    public ResponseEntity deleteProduct(@RequestParam Integer productId){
        Boolean deleteStatus=productService.deleteProduct(productId);
        if(deleteStatus)
        {
            return new ResponseEntity<>("Product with Id "+productId+" Successfully deleted",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity("Something went Wrong!!!",HttpStatus.BAD_REQUEST);
        }
    }


}
