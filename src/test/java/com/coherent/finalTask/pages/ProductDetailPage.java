package com.coherent.finalTask.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailPage extends PageBaseClass {

    @FindBy(xpath = "//a[@href='#'][@class='action towishlist']")
    WebElement addToWishListButton;

    @FindBy (xpath = "//h1/span")
    WebElement itemName;

    @FindBy(xpath = "//div[@class='swatch-attribute size']/div[@role='listbox']/div[1]")
    WebElement itemSize;

    @FindBy (xpath = "//div[@class='swatch-attribute color']/div[@role='listbox']/div[1]")
    WebElement itemColor;

    @FindBy(xpath = "//div[@class='product-info-main']//span[@class='price']")
    WebElement itemPrice;

    @FindBy (xpath = "//button[@title='Add to Cart']")
    WebElement addToCartButton;

    public void addItemToWishList(){
        addToWishListButton.click();
    }

    public String getItemName(){
        String nameOnDetailPage = itemName.getText();
        return nameOnDetailPage;
    }

    public void addItemToCard(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(itemSize));
        itemSize.click();
        itemColor.click();
        addToCartButton.click();
    }

    public int getItemPrice(){
        String getPrice = itemPrice.getText();
        String cutPrice = getPrice.substring(1, getPrice.length()-3);
        int price = Integer.parseInt(cutPrice);
        return price;
    }

}
