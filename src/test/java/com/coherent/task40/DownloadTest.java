package com.coherent.task40;

import org.junit.Before;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import static com.coherent.task40.TestConstants.*;

public class DownloadTest {
    WebDriver driver = new ChromeDriver();

    @BeforeEach
    void setup() {
        BaseTest.setup(driver, DOWNLOAD_USER_PAGE);
    }

    @Test
    public void download50Percentage() {
        By downloadButton = By.id("cricle-btn");
        By percentText = By.cssSelector(".percenttext");
        String expectedPercent = "50|[51-100]%";
        String zeroPercent = "0%";

        driver.findElement(downloadButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        Pattern pattern = Pattern.compile("50%");
        wait.until(ExpectedConditions.textMatches(percentText, pattern));
        driver.navigate().refresh();
        Assertions.assertEquals(driver.findElement(percentText).getText(), zeroPercent);
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
