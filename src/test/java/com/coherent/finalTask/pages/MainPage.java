package com.coherent.finalTask.pages;

import com.coherent.finalTask.helpers.PropertiesHelper;
import com.coherent.finalTask.tests.SingletonWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.coherent.finalTask.constants.TestConstants.MAIN_PAGE;

public class MainPage {
    private static PropertiesHelper propertiesHelper = new PropertiesHelper();
    private static String magentoLoginFile = "magentoLogin.properties";
    private static String userEmail = propertiesHelper.propertiesReader("magentoUser.email", magentoLoginFile);
    private static WebDriver driver;

    public MainPage() {
        this.driver = SingletonWebDriver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//li[@class='authorization-link']")
   private WebElement signInButton;

    public void navigateToMainPage(){
        driver.get(MAIN_PAGE);
    }

    public void signIn(){
        navigateToMainPage();
        signInButton.click();
    }
}
