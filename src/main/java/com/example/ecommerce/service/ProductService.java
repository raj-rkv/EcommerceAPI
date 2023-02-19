package com.example.ecommerce.service;

import com.example.ecommerce.dao.ProductRepository;
import com.example.ecommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    private ProductRepository productRepository;
    @Override
    public int addProduct(Product productData) {
        Product product=productRepository.save(productData);
        return product.getProductId();
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        List<Product> products=productRepository.findAll();
        List<Product> productByCategory=new ArrayList<>();
        for(Product product:products)
        {
            if(product.getCategory().equals(category)){
                productByCategory.add(product);
            }
        }
        return productByCategory;
    }

    @Override
    public Boolean deleteProduct(Integer productId) {
        List<Product> products=productRepository.findAll();
        Boolean status=false;
        for (Product product:products){
            if(product.getProductId()==productId)
            {
                products.remove(product);
                status=true;
            }
        }
        return status;
    }
}
