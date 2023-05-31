package com.coherent.finalTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static com.coherent.finalTask.TestConstants.CART_PAGE;


public class CartPage extends PageBaseClass {

    @FindBy(xpath = "//form[@id='form-validate']")
    WebElement cartItems;

    @FindBy(xpath = "//form[@id='form-validate']//tbody[@class='cart item'][1]//a[@title='Remove item']")
    WebElement deleteButton;

    @FindBy(xpath = "//table[@class='data table totals']//strong/span[@class='price']")
    WebElement cartTotalPrice;

    public void navigateToCartPage() {
        driver.get(CART_PAGE);
    }

    public void cartCleanup() {
        navigateToCartPage();

        while (true){
            try{
                if(!cartItems.isDisplayed()){
                    System.out.println("All items have been deleted from the Cart. Cart is empty.");
                    return;
                }
                List<WebElement> cartListItems = cartItems.findElements(By.tagName("tbody"));
                while (!cartListItems.isEmpty()) {
                WebElement cartListItem = cartListItems.get(0);
                deleteButton.click();

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                wait.until(ExpectedConditions.stalenessOf(cartListItem));
                cartListItems = cartItems.findElements(By.tagName("tbody"));
            }
            } catch (NoSuchElementException e) {
                System.out.println("All items have been deleted from the Cart. Cart is empty.");
                return;
            }
        }
    }

    public int getTotalSumFromCart(){
        navigateToCartPage();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String fullPrice = cartTotalPrice.getText();
        String cutPrice = fullPrice.substring(1, fullPrice.length()-3);
        int price = Integer.parseInt(cutPrice);
        return price;
    }
}
