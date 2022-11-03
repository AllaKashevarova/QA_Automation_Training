package com.coherent.education;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shop.Cart;
import shop.RealItem;

public class CartTest {
    final double TAX = 0.4;

    @Test
    public void checkPrice(){
        Cart cart = new Cart("userCart");
        RealItem realItem = new RealItem();
        realItem.setPrice(20);
        cart.addRealItem(realItem);

        double result = realItem.getPrice()+realItem.getPrice()*TAX;
        Assertions.assertEquals(cart.getTotalPrice(), result);

    }
}
