package com.example.ecommerce.service;

import com.example.ecommerce.model.Order;

public interface IOrderService {
    public int placeOrder(Order order);

    public Order getOrderById(Integer orderId);
}
