package com.coherent.finalTask;

import com.coherent.task60.TestResultLoggerExtension;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

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

        wishListPage.clearWishlist();

//        productsPage.selectItem();
//        productDetailPage.addItemToWishList();

    }

}
