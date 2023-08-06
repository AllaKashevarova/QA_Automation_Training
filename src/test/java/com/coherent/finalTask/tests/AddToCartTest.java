package com.coherent.finalTask.tests;

import com.coherent.finalTask.pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Feature("Add Items to Cart")
@Tag("AP-5")
public class AddToCartTest extends BaseTest {
    private static MainPage mainPage = new MainPage();
    private static LoginPage loginPage = new LoginPage();
    private static ProductsPage productsPage = new ProductsPage();
    private static ProductDetailPage productDetailPage = new ProductDetailPage();
    private static CartPage cartPage = new CartPage();

    @Description("Test Description: Verify the ability to add to cart")
    @DisplayName("Add to Cart")
    @Test
    public void addItemsToCartTest() {
        List<Integer> cartPrices = new ArrayList<>();
        mainPage.signIn();
        loginPage.SignIn();
        //ask: why this method fails and how to fix that
        //cartPage.cartCleanup();

        productsPage.selectSpecificItem(1);
        productDetailPage.addItemToCard();
        cartPrices.add(productDetailPage.getItemPrice());

        productsPage.selectSpecificItem(2);
        productDetailPage.addItemToCard();
        cartPrices.add(productDetailPage.getItemPrice());

        productsPage.selectSpecificItem(3);
        productDetailPage.addItemToCard();
        cartPrices.add(productDetailPage.getItemPrice());

        System.out.println(cartPrices);

        int sum = 0;
        for (int cartPrice: cartPrices){
            sum += cartPrice;
        }
        int expectedSum = sum;

        System.out.println("Calculated sum: " + sum);
        int actualSum = cartPage.getTotalSumFromCart();
        System.out.println("Sum from the Cart total: " + actualSum);
        Assertions.assertEquals(expectedSum, actualSum);
    }
}
