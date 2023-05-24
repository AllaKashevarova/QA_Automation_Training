package com.coherent.finalTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.coherent.finalTask.TestConstants.WISHLIST_PAGE;

public class WishListPage extends PageBaseClass {

    @FindBy(xpath = "//div[@class='products-grid wishlist']/ol[@class='product-items']")
    WebElement productItems;

    @FindBy(xpath = "//a[@href='#'][@data-role='remove']")
    WebElement deleteIcon;


    public void navigateToWishlistPage() {
        driver.get(WISHLIST_PAGE);
    }

    public void clearWishlist() {
        Actions action = new Actions(driver);
        navigateToWishlistPage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOf(productItems));

        List<WebElement> items = productItems.findElements(By.tagName("li"));

        if (!items.isEmpty()) {
            int index = 0;
            while (index > items.size()) {
                WebElement item = items.get(index);
                action.moveToElement(item).perform();

                wait.until(ExpectedConditions.visibilityOf(deleteIcon));
                deleteIcon.click();
                items = productItems.findElements(By.tagName("li"));

                wait.until(ExpectedConditions.invisibilityOf(item));

                if (items.size() < index + 1) {
                    index++;
                }
            }
        } else {
            System.out.println("No more items in the Wishlist. Test can be started now.");
        }
            }
        }
//        else System.out.println("No more items in the Wishlist. Test can be started now.");



