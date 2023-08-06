package com.coherent.finalTask.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.coherent.finalTask.constants.TestConstants.MY_ACCOUNT_PAGE;

public class AccountPage extends PageBaseClass {

    @FindBy (xpath = "//ul[@class='nav items']/li[@class='nav item'][1]")
    private WebElement myAccountTab;

    public void navigateToAccountPage(){
        driver.get(MY_ACCOUNT_PAGE);
    }

    public void navigateToMyAccountTab(){
        myAccountTab.click();
    }

}
