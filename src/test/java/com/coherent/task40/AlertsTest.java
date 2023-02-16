package com.coherent.task40;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.coherent.task40.TestConstants.*;

public class AlertsTest {
    WebDriver driver = new ChromeDriver();
    By confirmBoxButton = By.xpath("//button[@onclick='myConfirmFunction()']");
    By alertBoxButton = By.xpath("//button[@onclick='myAlertFunction()']");
    String confirmBoxText = "Press a button!";
    String alertBoxText = "I am an alert box!";


    @BeforeEach
    void setUp() {
        BaseTest.setup(driver, ALERTS_PAGE);
    }

    @Test
    public void JavaScriptConfirmBoxTest1() {
        driver.findElement(confirmBoxButton).click();
        Alert alert = driver.switchTo().alert();
        String textOnAlert = alert.getText();
        alert.accept();
        Assertions.assertEquals(confirmBoxText, textOnAlert);
    }

    @Test
    public void JavaScriptConfirmBoxTest2() {
        driver.findElement(confirmBoxButton).click();
        Alert alert = driver.switchTo().alert();
        String textOnAlert = alert.getText();
        alert.accept();

        WebElement message = driver.findElement(By.id("confirm-demo"));
        Assertions.assertEquals("You pressed OK!", message.getText());
    }

    @Test
    public void JavaScriptAlertBoxTest() {
        driver.findElement(alertBoxButton).click();
        Alert alert = driver.switchTo().alert();
        String textOnAlert = alert.getText();
        alert.accept();
        Assertions.assertEquals(alertBoxText, textOnAlert);
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
