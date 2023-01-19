package com.coherent.testng;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

public class CartTNG {

    final double TAX = 0.2;
    Cart cart = new Cart("UserCart");
    RealItem realItem1;
    RealItem realItem2;
    VirtualItem virtualItem;

    @BeforeMethod
    public void createCard() {
        realItem1 = new RealItem();
        realItem1.setPrice(20);
        realItem1.setName("Item 1");
        cart.addRealItem(realItem1);
    }

    @Test(groups = {"Cart.Price"})
    public void checkPriceOfRealItem() {

        double result = realItem1.getPrice() + realItem1.getPrice() * TAX;
        Assertions.assertEquals(cart.getTotalPrice(), result);
    }


//    @Test
//    public void checkItemsAddedToCart() {
//
//    //check that appropriate number of items have been added
//
//
//        Assertions.assertEquals(cart.showItems(), ??);
//
//    }

    @Test (groups = {"Cart.Name"})
    public void checkCartName(){
        String cartName = "UserCart";

        Assertions.assertEquals(cart.getCartName(), cartName);
    }

    @AfterMethod
    public void deleteItemsFromCart() {
        cart.deleteRealItem(realItem1);
        cart.deleteRealItem(realItem2);

    }

}
