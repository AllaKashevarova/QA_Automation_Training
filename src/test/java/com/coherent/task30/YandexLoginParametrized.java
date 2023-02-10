package com.coherent.task30;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class YandexLoginParametrized {
    private static WebDriver driver;
    private String resource = "https://mail.yandex.com";
    Locators locator = new Locators();
    //HelperClass helperClass = new HelperClass();


    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1700, 1000));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/logInData.csv")

    @Test
    public void testLogIn(String name, String password) throws InterruptedException {
        driver.get(resource);
        driver.findElement(locator.logInButtonMain).click();
        driver.findElement(locator.userName).sendKeys(name);
        driver.findElement(locator.logInButton).click();
        driver.findElement(locator.passwordField).sendKeys(password);
        driver.findElement(locator.logInButton2).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        WebElement spanElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator.userNickName));
        String nickName = spanElement.getText();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Task #3. Answer: this is an explicit waiter since it's only applicable on the step it's located in the code.

        Assertions.assertEquals(name, nickName);



    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
