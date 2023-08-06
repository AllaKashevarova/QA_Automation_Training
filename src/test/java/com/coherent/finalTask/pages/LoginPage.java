package com.coherent.finalTask.pages;
import com.coherent.finalTask.helpers.PropertiesHelper;
import com.coherent.finalTask.tests.SingletonWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static com.coherent.finalTask.constants.TestConstants.LOGIN_PAGE;

public class LoginPage {
    private static PropertiesHelper propertiesHelper = new PropertiesHelper();
    private static String userLoginFile = "magentoLogin.properties";
    private static String email = propertiesHelper.propertiesReader("magentoUser.email", userLoginFile);
    private static String password = propertiesHelper.propertiesReader("magentoUser.password", userLoginFile);

    private static WebDriver driver;

    public LoginPage() {
        this.driver = SingletonWebDriver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "email")
    private WebElement emailField;

    @FindBy (id = "pass")
    private WebElement passwordField;

    @FindBy (id = "send2")
    private WebElement signInButton;

    @FindBy (xpath = "//*[@id='maincontent']/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/p")
    private WebElement userName;

    public void navigateToLoginPage(){
        driver.get(LOGIN_PAGE);
    }

    public WebElement getActualResult(){
        WebElement actualResult;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        actualResult = wait.until(ExpectedConditions.visibilityOf(userName));
        return actualResult;
    }

    public void SignIn(){
        navigateToLoginPage();
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
    }
}
