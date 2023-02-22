package com.coherent.task60;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage {
    private String url = "https://mail.yandex.com";
    private WebDriver driver;
    private WebElement login;
    private String userName = "fine.lname";
    private String password = "p8Usc@jheBHhUZ3";

    @FindBy(xpath = "//div[@class='ActionButtons_1KQUh4y2uqGFcS5C_M9sDV']/a[contains(@class,'Button2_view_default')]")
    @CacheLookup
    public WebElement logInButton;

    @FindBy(id = "passp:sign-in")
    public WebElement logInButton2;

    @FindBy(id = "passp-field-passwd")
    @CacheLookup
    public WebElement passwordField;

    public LoginPage() {
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
    }

    public void setup(){
        this.driver.get(url);
    }

    public void cleanup(){
        this.driver.quit();
    }

    public void logIn(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logInButton.click();
        login.sendKeys(userName);
        logInButton2.click();
        passwordField.sendKeys(password);
        //verify why it's not working:
        logInButton2.click();
    }
}
