package com.coherent.task40;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import static com.coherent.task40.TestConstants.*;

public class AlertsTest extends BaseTest {
    private By confirmBoxButton = By.xpath("//button[@onclick='myConfirmFunction()']");
    private By alertBoxButton = By.xpath("//button[@onclick='myAlertFunction()']");
    private String confirmBoxText = "Press a button!";
    private String alertBoxText = "I am an alert box!";

    @Test
    public void JavaScriptConfirmBoxTest1() {
        driver.get(ALERTS_PAGE);
        driver.findElement(confirmBoxButton).click();
        Alert alert = driver.switchTo().alert();
        String textOnAlert = alert.getText();
        alert.accept();
        Assertions.assertEquals(confirmBoxText, textOnAlert);
    }

    @Test
    public void JavaScriptConfirmBoxTest2() {
        driver.get(ALERTS_PAGE);
        driver.findElement(confirmBoxButton).click();
        Alert alert = driver.switchTo().alert();
        String textOnAlert = alert.getText();
        alert.accept();
        WebElement message = driver.findElement(By.id("confirm-demo"));
        Assertions.assertEquals("You pressed OK!", message.getText());
    }

    @Test
    public void JavaScriptAlertBoxTest() {
        driver.get(ALERTS_PAGE);
        driver.findElement(alertBoxButton).click();
        Alert alert = driver.switchTo().alert();
        String textOnAlert = alert.getText();
        alert.accept();
        Assertions.assertEquals(alertBoxText, textOnAlert);
    }
}
