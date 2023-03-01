package com.coherent.task60;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class EmailBoxPage {

    private WebDriver driver;
    private PropertiesHelper propertiesHelper = new PropertiesHelper();

    @FindBy(css = "#js-apps-container .user-account__name")
    @CacheLookup
    private WebElement userNickName;

    @FindBy(xpath = "//ul[@class='menu__group']/li[6]")
    @CacheLookup
    private WebElement logoutButton;

    public EmailBoxPage() {
        driver = SingletoneWebDriver.getDriver();
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getUserNickName() {
        return userNickName;
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public void logOut() throws IOException {
        userNickName.click();
        logoutButton.click();
    }
}
