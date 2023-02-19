package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;

import java.util.List;

public interface IProductService {
    public int addProduct(Product product);

    public List<Product> getAllProduct();

    public List<Product> getProductByCategory(String category);

    public Boolean deleteProduct(Integer productId);
}
