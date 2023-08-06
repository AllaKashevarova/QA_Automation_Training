package com.coherent.finalTask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.coherent.finalTask.constants.TestConstants.PANTS_PAGE;

public class ProductsPage extends PageBaseClass {

    public void navigateToPantsPage(){
        driver.get(PANTS_PAGE);
    }

    @FindBy (xpath = "//ol[@class='products list items product-items']/li[1]")
    WebElement productItemFirst;

    public void selectItem(){
        navigateToPantsPage();
        productItemFirst.click();
    }

    public void selectSpecificItem(int productNumber){
        navigateToPantsPage();
        String xpathToItem = "//ol[@class='products list items product-items']/li[" + productNumber + "]";
        WebElement selectedItem = driver.findElement(By.xpath(xpathToItem));
        selectedItem.click();
    }

}
