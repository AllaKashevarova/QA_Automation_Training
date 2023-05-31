package com.coherent.finalTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.coherent.finalTask.TestConstants.PANTS_PAGE;

public class ProductsPage extends PageBaseClass{

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
