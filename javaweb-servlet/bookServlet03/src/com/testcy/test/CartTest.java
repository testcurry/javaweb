package com.testcy.test;

import com.testcy.pojo.Cart;
import com.testcy.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(99), new BigDecimal(99)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(99), new BigDecimal(99)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, new BigDecimal(88), new BigDecimal(88)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(99), new BigDecimal(99)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(99), new BigDecimal(99)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, new BigDecimal(88), new BigDecimal(88)));
        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(99), new BigDecimal(99)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(99), new BigDecimal(99)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, new BigDecimal(88), new BigDecimal(88)));
        cart.deleteItem(1);
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateItemCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(99), new BigDecimal(99)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(99), new BigDecimal(99)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, new BigDecimal(88), new BigDecimal(88)));
        cart.deleteItem(1);
        cart.clear();
        cart.addItem(new CartItem(2, "数据结构与算法", 1, new BigDecimal(88), new BigDecimal(88)));
        cart.updateItemCount(2,2);
        System.out.println(cart);
    }
}