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
    String expectedUserName = "fine.lname";

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
    }

    @Test
    void logInYandexMailbox() {

        driver.manage().window().setSize(new Dimension(1700, 1000));
        driver.get("https://mail.yandex.com");

        driver.findElement(locator.logInButtonMain).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

        driver.findElement(locator.userName).sendKeys("fine.lname");

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

        driver.findElement(locator.logInButton).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

        driver.findElement(locator.passwordField).sendKeys("p8Usc@jheBHhUZ3");

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

        driver.findElement(locator.logInButton2).click();

        driver.findElement(locator.UserImage).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));

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
