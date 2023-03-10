package com.coherent.task60;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;

public class EmailBoxPage {

    private WebDriver driver;
    private PropertiesHelper propertiesHelper = new PropertiesHelper();

    private By userNickName = By.cssSelector("#js-apps-container .user-account__name");

    private By logoutButton = By.xpath("//ul[@class='menu__group']/li[6]");

    private By logInButtonLocator = By.xpath("//div[@class='ActionButtons_1KQUh4y2uqGFcS5C_M9sDV']/a[contains(@class,'Button2_view_default')]");


    public EmailBoxPage() {
        driver = SingletoneWebDriver.getDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public By getUserNickName() {
        return userNickName;
    }

    public By getLogoutButton() {
        return logoutButton;
    }

    public WebElement getLogInButtonLocator() {
        return driver.findElement(logInButtonLocator);
    }

    public void logOut() throws IOException {
        driver.findElement(userNickName).click();
        driver.findElement(logoutButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(logInButtonLocator));
    }
}
