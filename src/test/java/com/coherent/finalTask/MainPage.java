package com.coherent.finalTask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.coherent.finalTask.TestConstants.MAIN_PAGE;

public class MainPage {
    private static WebDriver driver;
    private static PropertiesHelper propertiesHelper = new PropertiesHelper();
    private static String magentoLoginFile = "magentoLogin.properties";
    private static String userEmail = propertiesHelper.propertiesReader("magentoUser.email", magentoLoginFile);

    public MainPage() {
        this.driver = SingletonWebDriver.getDriver();
        PageFactory.initElements(driver, this);
    }

   @FindBy (xpath = "//li[@class='authorization-link']")
   private WebElement signInButton;


    public void navigateToMainPage(){
        driver.get(MAIN_PAGE);
    }

    //TODO add method to press Sign In button

    public void signIn(){
        navigateToMainPage();
        signInButton.click();
    }
}
