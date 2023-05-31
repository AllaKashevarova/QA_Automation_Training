package com.coherent.finalTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.coherent.finalTask.TestConstants.ADDRESS_BOOK_PAGE;

public class AddressBookPage extends PageBaseClass {
    private static PropertiesHelper propertiesHelper = new PropertiesHelper();
    private static String userDataFile = "userData.properties";
    private static String userStreet = propertiesHelper.propertiesReader("user.street", userDataFile);
    private static String userCity = propertiesHelper.propertiesReader("user.city", userDataFile);
    private static String userState = propertiesHelper.propertiesReader("user.state", userDataFile);
    private static String userZip = propertiesHelper.propertiesReader("user.zip", userDataFile);
    private static String userCountry = propertiesHelper.propertiesReader("user.country", userDataFile);
    private static String userTelephone = propertiesHelper.propertiesReader("user.telephone", userDataFile);

    @FindBy(xpath = "//button[@title='Add New Address']")
    private WebElement addNewAddressButton;

    @FindBy(id = "street_1")
    private WebElement streetAddressField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "region_id")
    private WebElement stateProvinceField;

    public Select getSelectOptionsStateProvince() {
        return new Select(stateProvinceField);
    }

    public void setOptionStateProvince(String text) {
        getSelectOptionsStateProvince().selectByVisibleText(text);
    }

    public String getSelectedOptionStateProvince() {
        return getSelectOptionsStateProvince().getFirstSelectedOption().getText();
    }

    @FindBy(id = "zip")
    private WebElement zipField;

    @FindBy(id = "telephone")
    private WebElement telephoneField;

    @FindBy(id = "country")
    private WebElement countryField;

    public Select getSelectOptionsCountry() {
        return new Select(countryField);
    }

    public void setOptionCountry(String text) {
        getSelectOptionsCountry().selectByVisibleText(text);
    }

    public String getSelectedOptionCountry() {
        return getSelectOptionsCountry().getFirstSelectedOption().getText();
    }

    @FindBy(xpath = "//button[@type='submit']/span[contains (text(), 'Save Address')]")
    private WebElement saveAddressButton;

    @FindBy(xpath = "//div[@class='block block-addresses-list']//td[@class='col streetaddress']")
    private WebElement actualResultAddedAddress;

    @FindBy(id = "additional-addresses-table")
    private WebElement table;

    public void navigateToAddressBookPage() {
        driver.get(ADDRESS_BOOK_PAGE);
    }

    public void addNewAddress() {
        navigateToAddressBookPage();
        addNewAddressButton.click();
        streetAddressField.clear();
        streetAddressField.sendKeys(userStreet);
        cityField.clear();
        cityField.sendKeys(userCity);
        setOptionStateProvince(userState);
        zipField.clear();
        zipField.sendKeys(userZip);
        setOptionCountry(userCountry);
        telephoneField.sendKeys(userTelephone);
        saveAddressButton.click();
    }

    public WebElement getActualResult() {
        WebElement actualResult;
        navigateToAddressBookPage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        actualResult = wait.until(ExpectedConditions.visibilityOf(table));
        return actualResult;

    }
}
