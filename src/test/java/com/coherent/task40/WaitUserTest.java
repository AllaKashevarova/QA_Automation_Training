package com.coherent.task40;

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

public class WaitUserTest {
    String source = "https://demo.seleniumeasy.com/dynamic-data-loading-demo.html";
    WebDriver driver;
    By userImage = By.xpath("//div[@id='loading']/img");

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1700, 1000));
        driver.get(source);
    }

    @Test
    public void userAppearTest(){
        driver.findElement(By.id("save")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(userImage));

        Assertions.assertTrue(element.isDisplayed());
    }



}
