package com.coherent.finalTask;


import com.coherent.task60.TestResultLoggerExtension;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

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
