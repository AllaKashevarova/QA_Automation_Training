package com.coherent.finalTask.tests;


import com.coherent.finalTask.helpers.PropertiesHelper;
import com.coherent.finalTask.pages.CreateAccountPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature("Create Account")
@Tag("AP-1")
public class CreateAccountTest extends BaseTest {
    private PropertiesHelper propertiesHelper = new PropertiesHelper();
    private CreateAccountPage createAccountPage = new CreateAccountPage();
    private String myAccount = "My Account";

    @Description("Test Description: Verify the ability to create an account")
    @Test
    @DisplayName("Create Account")
    public void createAccountTest(){
        createAccountPage.createNewAccount();
        String actualResultText = createAccountPage.getActualResult().getText();

        Assertions.assertEquals(actualResultText, myAccount);
    }
}
