package com.coherent.finalTask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.coherent.finalTask.TestConstants.LOGIN_PAGE;
import static com.coherent.finalTask.TestConstants.MY_ACCOUNT_PAGE;

public class AccountPage {
    private static WebDriver driver;

    public AccountPage() {
        this.driver = SingletonWebDriver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//ul[@class='nav items']/li[@class='nav item'][1]")
    private WebElement myAccountTab;


    public void navigateToAccountPage(){
        driver.get(MY_ACCOUNT_PAGE);
    }

    public void navigateToMyAccountTab(){
        myAccountTab.click();
    }

}
