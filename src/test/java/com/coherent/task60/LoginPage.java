package com.coherent.task60;
import org.junit.jupiter.api.Assertions;
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
    private WebElement login;
    private WebDriver driver;
    private PropertiesHelper propertiesHelper = new PropertiesHelper();
    EmailBoxPage emailBoxPage = new EmailBoxPage();

    @FindBy(xpath = "//div[@class='ActionButtons_1KQUh4y2uqGFcS5C_M9sDV']/a[contains(@class,'Button2_view_default')]")
    @CacheLookup
    public WebElement logInButton;

    @FindBy(id = "passp:sign-in")
    public WebElement logInButton2;

    @FindBy(id = "passp-field-passwd")
    @CacheLookup
    public WebElement passwordField;

    public WebElement actualResult;

    public LoginPage() {
        driver = SingletoneWebDriver.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void load() throws IOException {
        this.driver.get(propertiesHelper.propertiesReader("url"));
    }

    public void logIn() throws IOException {
        logInButton.click();
        String userName = propertiesHelper.propertiesReader("userName");
        login.sendKeys(userName);
        logInButton2.click();
        String password = propertiesHelper.propertiesReader("password");
        passwordField.sendKeys(password);
        logInButton2.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        actualResult = wait.until(ExpectedConditions.visibilityOf(emailBoxPage.userNickName));
    }
}
