package com.coherent.task60;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class LoginPage{
    private By login = By.name("login");
    private WebDriver driver;
    private PropertiesHelper propertiesHelper = new PropertiesHelper();

//    @FindBy(xpath = "//div[@class='ActionButtons_1KQUh4y2uqGFcS5C_M9sDV']/a[contains(@class,'Button2_view_default')]")
//    @CacheLookup
//    private WebElement logInButton;
    private By logInButton  = By.xpath("//div[@class='ActionButtons_1KQUh4y2uqGFcS5C_M9sDV']/a[contains(@class,'Button2_view_default')]");

//    @FindBy(id = "passp:sign-in")
//    private WebElement logInButton2;
    private By logInButton2 = By.id("passp:sign-in");

//    @FindBy(id = "passp-field-passwd")
//    @CacheLookup
//    private WebElement passwordField;
    private By passwordField = By.id("passp-field-passwd");

//    @FindBy(css = "#js-apps-container .user-account__name")
//    @CacheLookup
//    private WebElement userNickName;
    private By userNickName = By.cssSelector("#js-apps-container .user-account__name");

    private WebElement actualResult;

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        //WebElement element = driver.findElement(userNickName);
        actualResult = wait.until(ExpectedConditions.visibilityOfElementLocated(userNickName));
        return actualResult;
    }

    public LoginPage() {
        driver = SingletoneWebDriver.getDriver();
//        PageFactory.initElements(driver, this);
    }

    public void load() throws IOException {
        this.driver.get(propertiesHelper.propertiesReader("url"));
    }

    public void logIn() throws IOException {
        driver.findElement(logInButton).click();
        String userName = propertiesHelper.propertiesReader("user.name");
        driver.findElement(login).sendKeys(userName);
        driver.findElement(logInButton2).click();
        String password = propertiesHelper.propertiesReader("user.password");
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(logInButton2).click();
        getActualResult();
    }
}
