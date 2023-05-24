package com.coherent.finalTask;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends PageBaseClass{

    @FindBy(xpath = "//a[@href='#'][@class='action towishlist']")
    WebElement addToWishListButton;

    @FindBy (xpath = "//h1[@class='page-title']")
    WebElement itemName;

    public void addItemToWishList(){
        addToWishListButton.click();
    }

    public String getItemName(){
        String nameOnDetailPage = itemName.getText();
        return nameOnDetailPage;
    }

}
