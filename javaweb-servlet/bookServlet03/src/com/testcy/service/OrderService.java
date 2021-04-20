package com.testcy.service;

import com.testcy.pojo.Cart;

public interface OrderService {
    public String createOrder(Cart cart, Integer userId);
}
