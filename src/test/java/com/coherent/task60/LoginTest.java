package com.coherent.task60;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import java.io.IOException;

@ExtendWith(TestResultLoggerExtension.class)
public class LoginTest {
    private PropertiesHelper propertiesHelper = new PropertiesHelper();
    private ScreenshotHelper screenshotHelper = new ScreenshotHelper();
    private LoginPage loginPage = new LoginPage();
    private String userName;
    private String path;

    {
        userName = propertiesHelper.propertiesReader("user.name");
        path = propertiesHelper.propertiesReader("error.screenshots");
    }

    @Test
    public void loginTest() throws IOException {
        loginPage.load();
        loginPage.logIn();
        String actualResultText = loginPage.getActualResult().getText();

        Assertions.assertEquals(actualResultText, "Test!");
        //Assertions.assertEquals(actualResultText, userName);
    }

    @AfterAll
    public static void cleanup() {
        SingletoneWebDriver.cleanup();
    }
}



