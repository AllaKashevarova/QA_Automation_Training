package com.coherent.finalTask.tests;

import com.coherent.finalTask.helpers.PropertiesHelper;
import com.coherent.finalTask.pages.AccountPage;
import com.coherent.finalTask.pages.AddressBookPage;
import com.coherent.finalTask.pages.LoginPage;
import com.coherent.finalTask.pages.MainPage;
import com.coherent.task60.TestResultLoggerExtension;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@ExtendWith(TestResultLoggerExtension.class)
@ExtendWith({AllureJunit5.class})
@Feature("Add Address")
@Tag("AP-3")

public class AddAddressTest extends BaseTest {
    private static MainPage mainPage = new MainPage();
    private static LoginPage loginPage = new LoginPage();
    private static AccountPage accountPage = new AccountPage();
    private static PropertiesHelper propertiesHelper = new PropertiesHelper();
    private static AddressBookPage addressBookPage = new AddressBookPage();
    private static String userDataFile = "userData.properties";
    private static String expectedUserStreet = propertiesHelper.propertiesReader("user.street", userDataFile);

    @Description("Test Description: Verify the ability to to add address")
    @Test
    @DisplayName("Add address ")
    public void addAddressTest() {
        mainPage.signIn();
        loginPage.SignIn();
        accountPage.navigateToMyAccountTab();
        loginPage.getActualResult();

        addressBookPage.addNewAddress();
        addressBookPage.getActualResult();

        WebElement table = addressBookPage.getActualResult();
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        String actualUserStreet = null;

        for (WebElement row : rows) {
            List<WebElement> streetCells = row.findElements(By.xpath("//td[@class='col streetaddress']"));

            for (WebElement streetCell : streetCells) {
                String callText = streetCell.getText();
                if (callText.equals(expectedUserStreet)){
                    actualUserStreet = callText;
                }
            }

            Assertions.assertEquals(actualUserStreet, expectedUserStreet);
        }

    }
}
