package com.coherent.education;

import org.junit.jupiter.api.*;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

public class CartTest {
    final double TAX = 0.2;
    Cart cart = new Cart("userCart");

    @BeforeEach
    public void beforeEach() {
        System.out.println("CarTest execution is in progress...");
    }

    @DisplayName("Real Item Price Check")
    @Test
    public void checkPriceOfRealItem() {
        RealItem realItem = new RealItem();
        realItem.setPrice(20);
        cart.addRealItem(realItem);

        double result = realItem.getPrice() + realItem.getPrice() * TAX;
        Assertions.assertEquals(cart.getTotalPrice(), result);

    }

    @DisplayName("Virtual Item Price Check")
    @Test
    public void checkPriceOfVirtualItem() {
        VirtualItem virtualItem = new VirtualItem();
        virtualItem.setPrice(30);
        cart.addVirtualItem(virtualItem);

        double result = virtualItem.getPrice() + virtualItem.getPrice() * TAX;
        Assertions.assertEquals(cart.getTotalPrice(), result);

    }

    @AfterEach
    public void afterEach() {
        System.out.println("The CarTest has been completed");
    }
}
