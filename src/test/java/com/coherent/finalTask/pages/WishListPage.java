package com.coherent.finalTask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import static com.coherent.finalTask.constants.TestConstants.WISHLIST_PAGE;

public class WishListPage extends PageBaseClass {

    @FindBy(css = "[id^='item_']")
    WebElement wishListItemLocator;

    @FindBy(xpath = "//a[@href='#'][@data-role='remove']")
    WebElement deleteIcon;

    @FindBy(xpath = "//div[@class='products-grid wishlist']/ol[@class='product-items']/li[1]//strong/a")
    WebElement itemText;

    public void navigateToWishlistPage() {
        driver.get(WISHLIST_PAGE);
    }

    public void clearWishlist() {
        Actions action = new Actions(driver);
        navigateToWishlistPage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(wishListItemLocator));

//Is there a way to rewrite this using Factory pattern?
        List<WebElement> wishlistItems = driver.findElements(By.cssSelector("[id^='item_']"));

        while (!wishlistItems.isEmpty()) {
            WebElement wishlistItem = wishlistItems.get(0);
            action.moveToElement(wishlistItem).perform();
            deleteIcon.click();
            wait.until(ExpectedConditions.stalenessOf(wishlistItem));
            wishlistItems = driver.findElements(By.cssSelector("[id^='item_']"));
        }

        List<WebElement> remainingItems = driver.findElements(By.cssSelector("[id^='item_']"));
        if (remainingItems.isEmpty()) {
            System.out.println("All items have been deleted from the wishlist.");
        } else {
            System.out.println("Some items could not be deleted from the wishlist.");
        }
    }

    public String getItemName() {
        return itemText.getText();
    }
}




