package com.coherent.task30;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class YandexLogIn {

    private WebDriver driver;
    Locators locator = new Locators();
    private String expectedUserName = "fine.lname";
    private String resource = "https://mail.yandex.com";
    private String username = "fine.lname";
    private String password = "p8Usc@jheBHhUZ3";

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    @Test
    void logInYandexMailbox() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));

        driver.manage().window().setSize(new Dimension(1700, 1000));
        driver.get(resource);
        driver.findElement(locator.logInButtonMain).click();
        wait.until(ExpectedConditions.elementToBeClickable(locator.userName));
        driver.findElement(locator.userName).sendKeys(username);
        driver.findElement(locator.logInButton).click();
        driver.findElement(locator.passwordField).sendKeys(password);
        driver.findElement(locator.logInButton2).click();
        driver.findElement(locator.UserImage).click();

        WebElement spanElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator.userNickName));
        String text = spanElement.getText();
        //This assertion also works well with this code:
        //Assertions.assertTrue(driver.findElement(locator.userNickName).isDisplayed());
        Assertions.assertEquals(expectedUserName, text);
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
