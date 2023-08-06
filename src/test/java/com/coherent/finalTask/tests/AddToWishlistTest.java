package com.coherent.finalTask.tests;

import com.coherent.finalTask.pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature("Add Item to Wishlist")
@Tag("AP-4")
public class AddToWishlistTest extends BaseTest {
    private static MainPage mainPage = new MainPage();
    private static LoginPage loginPage = new LoginPage();
    private static ProductsPage productsPage = new ProductsPage();
    private static ProductDetailPage productDetailPage = new ProductDetailPage();
    private static WishListPage wishListPage = new WishListPage();

    @Description("Test Description: Verify the ability to add to Wishlist")
    @DisplayName("Add to Wishlist")
    @Test
    public void addItemToWishlistTest(){
        mainPage.signIn();
        loginPage.SignIn();

        wishListPage.navigateToWishlistPage();
        wishListPage.clearWishlist();

        productsPage.selectItem();
        String expectedProductName = productDetailPage.getItemName();
        productDetailPage.addItemToWishList();
        wishListPage.navigateToWishlistPage();

        Assertions.assertEquals(expectedProductName, wishListPage.getItemName());

    }
}
