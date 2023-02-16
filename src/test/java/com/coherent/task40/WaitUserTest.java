package com.coherent.task40;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.coherent.task40.TestConstants.*;

public class WaitUserTest {
    WebDriver driver = new ChromeDriver();
    By userImage = By.xpath("//div[@id='loading']/img");

    @BeforeEach
    void setUp() {
        BaseTest.setup(driver, DYNAMIC_DATA_PAGE);
    }

    @Test
    public void userAppearTest(){
        driver.findElement(By.id("save")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(userImage));

        Assertions.assertTrue(element.isDisplayed());
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }

}
