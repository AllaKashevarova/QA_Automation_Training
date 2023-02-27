package com.coherent.task60;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class EmailBoxPage {

    private WebDriver driver;
    private PropertiesHelper propertiesHelper = new PropertiesHelper();

    @FindBy(css = "#js-apps-container .user-account__name")
    @CacheLookup
    public WebElement userNickName;

    LoginPage loginPage = new LoginPage();

    public EmailBoxPage() {
        driver = SingletoneWebDriver.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void load() throws IOException {
        this.driver.get(propertiesHelper.propertiesReader("url"));
    }

    public void logOut() throws IOException {
        loginPage.logIn();
        userNickName.click();

    }


}
