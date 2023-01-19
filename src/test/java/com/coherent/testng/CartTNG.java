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
    Cart cart = new Cart("UserCart");
    RealItem realItem1;
    RealItem realItem2;
    VirtualItem virtualItem;
    String cartName = "UserCart";
    double result = realItem1.getPrice() + realItem1.getPrice() * TAX;

    @BeforeMethod
    public void createCard() {
        realItem1 = new RealItem();
        realItem1.setPrice(20);
        realItem1.setWeight(40);
        realItem1.setName("Item 1");
        cart.addRealItem(realItem1);
    }

    @Test(groups = {"Cart.Price"})
    public void checkPriceOfRealItem() {
        Assert.assertEquals(cart.getTotalPrice(), result);
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

        Assert.assertEquals(cart.getCartName(), cartName);
    }

    @Test (groups = {"Cart.GroupedAssertions"})
    public void groupAssertionsTest(){

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(cart.getCartName(), cartName);
        softAssert.assertEquals(cart.getTotalPrice(), result);
        softAssert.assertAll();

    }

    @AfterMethod
    public void deleteItemsFromCart() {
        cart.deleteRealItem(realItem1);
        //cart.deleteRealItem(realItem2);

    }

}
