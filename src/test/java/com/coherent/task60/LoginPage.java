package com.coherent.task60;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends LoadableComponent{
    private String url = "https://mail.yandex.com";
    private WebElement login;
    private String userName = "fine.lname";
    private String password = "p8Usc@jheBHhUZ3";
    private String title = "Yandex Mail — reliable and easy to use email with spam protection";
    //QUESTION: is that a good approach to instantiate driver singleton on a class level rather than write: Browser.driver() in each method here?
    //In a book "Selenium 2 WebDriver Tools Cookbook" they use this form in each method: Browser.driver()
    private WebDriver driver = Browser.driver();

    @FindBy(xpath = "//div[@class='ActionButtons_1KQUh4y2uqGFcS5C_M9sDV']/a[contains(@class,'Button2_view_default')]")
    @CacheLookup
    public WebElement logInButton;

    @FindBy(id = "passp:sign-in")
    public WebElement logInButton2;

    @FindBy(id = "passp-field-passwd")
    @CacheLookup
    public WebElement passwordField;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    //ISSUE:
    //I wasn't able to apply LoadableComponent for this test. Looks like there is some issue with driver.getTitle() method
    //It would be great to discuss that on some meeting.

//THE CODE THAT HASN'T BEEN WORKING PROPERLY:
    @Override
    protected void load() {
        this.driver.get(url);
    }

//below method has been created just to debug why I can't get title from the page:
    public void printTitleName(){
        System.out.println("Getting title...");
        System.out.println(driver.getTitle());
    }

    @Override
    protected void isLoaded()  {
        Assertions.assertTrue(driver.getTitle().equals(title));
    }

//    public void load() {
//        this.driver.get(url);
//    }


    public void cleanup(){
        driver.close();
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
