package com.coherent.testng;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

public class CartTNG {

    final double TAX = 0.2;
    Cart cart;
    RealItem realItem1;
    VirtualItem virtualItem;
    String cartName = "UserCart";


    @BeforeMethod
    public void createCard() {
        cart = new Cart("UserCart");
        realItem1 = new RealItem();
        realItem1.setPrice(20);
        realItem1.setWeight(40);
        realItem1.setName("Item 1");
        cart.addRealItem(realItem1);
    }

    @Test(groups = {"Smoke.Cart"})
    public void checkPriceOfRealItem() {
        double result = realItem1.getPrice() + realItem1.getPrice() * TAX;
        Assert.assertEquals(cart.getTotalPrice(), result);
    }


    @Test (groups = {"Regression.Cart"})
    public void checkCartName(){

        Assert.assertEquals(cart.getCartName(), cartName);
    }

    @Test (groups = {"Regression.Cart"})
    public void groupAssertionsTest(){
        double result = 24;

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(cart.getCartName(), cartName);
        softAssert.assertEquals(cart.getTotalPrice(), result);
        softAssert.assertAll();

    }

    @AfterMethod
    public void deleteItemsFromCart() {
        cart.deleteRealItem(realItem1);

    }

}
