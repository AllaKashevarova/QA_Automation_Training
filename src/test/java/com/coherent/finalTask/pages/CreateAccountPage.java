package com.coherent.finalTask.pages;

import com.coherent.finalTask.helpers.EmailGenerator;
import com.coherent.finalTask.helpers.PropertiesHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.coherent.finalTask.constants.TestConstants.CREATE_ACCOUNT_PAGE;

public class CreateAccountPage extends PageBaseClass {
    private static PropertiesHelper propertiesHelper = new PropertiesHelper();
    private static String magentoLoginFile = "magentoLogin.properties";
    private static String userName = propertiesHelper.propertiesReader("magentoUser.firstName", magentoLoginFile);
    private static String userLastName = propertiesHelper.propertiesReader("magentoUser.lastName", magentoLoginFile);
    private static String userPassword = propertiesHelper.propertiesReader("magentoUser.password", magentoLoginFile);
    private static String userEmail = EmailGenerator.generateEmail();

    @FindBy(id = "firstname")
    private WebElement firstName;

    @FindBy(id = "lastname")
    private WebElement lastName;

    @FindBy(id = "email_address")
    private WebElement emailAddress;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "password-confirmation")
    private WebElement passwordConfirmation;

    @FindBy(xpath = "//button[@title='Create an Account']")
    private WebElement submitButton;

    @FindBy(xpath = "//li[@class='nav item current']")
    private WebElement myAccountTab;

    public void navigateToCreateAccountPage() {
        driver.get(CREATE_ACCOUNT_PAGE);
    }

    public WebElement getActualResult() {
        WebElement actualResult;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        actualResult = wait.until(ExpectedConditions.visibilityOf(myAccountTab));
        return actualResult;
    }

    public void createNewAccount() {
        navigateToCreateAccountPage();
        firstName.sendKeys(userName);
        lastName.sendKeys(userLastName);
        emailAddress.sendKeys(userEmail);
        password.sendKeys(userPassword);
        passwordConfirmation.sendKeys(userPassword);
        submitButton.click();
        getActualResult();
    }
}
