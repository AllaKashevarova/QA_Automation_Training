package com.coherent.task60;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class LoginPage {
    private By login = By.name("login");
    private WebDriver driver;
    private PropertiesHelper propertiesHelper = new PropertiesHelper();
    private By logInButton = By.xpath("//div[@class='ActionButtons_1KQUh4y2uqGFcS5C_M9sDV']/a[contains(@class,'Button2_view_default')]");
    private By logInButton2 = By.id("passp:sign-in");
    private By passwordField = By.xpath("//input[@data-t='field:input-passwd']");
    private By userNickName = By.cssSelector("#js-apps-container .user-account__name");

    public By getLogInButton() {
        return logInButton;
    }

    public By getLogInButton2() {
        return logInButton2;
    }

    public By getPasswordField() {
        return passwordField;
    }

    public WebElement getActualResult() {
        WebElement actualResult;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        actualResult = wait.until(ExpectedConditions.visibilityOfElementLocated(userNickName));
        return actualResult;
    }

    public LoginPage() {
        driver = SingletoneWebDriver.getDriver();
    }

    public void load() throws IOException {
        this.driver.get(propertiesHelper.propertiesReader("url", "login.properties"));
    }

    public void logIn() throws IOException {
        driver.findElement(logInButton).click();
        String userName = propertiesHelper.propertiesReader("user.name", "login.properties");
        driver.findElement(login).sendKeys(userName);
        driver.findElement(logInButton2).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));

        String password = propertiesHelper.propertiesReader("user.password", "login.properties");
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(logInButton2).click();
        getActualResult();
    }
}
