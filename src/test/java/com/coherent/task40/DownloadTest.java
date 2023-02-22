package com.coherent.task40;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.regex.Pattern;
import static com.coherent.task40.TestConstants.*;

public class DownloadTest extends BaseTest{

    @Override
    public void setup() {
        super.setup();
    }

    @Test
    public void download50Percentage() {
        driver.get(DOWNLOAD_USER_PAGE);
        By downloadButton = By.id("cricle-btn");
        By percentText = By.cssSelector(".percenttext");
        String expectedPercent = "[5-9](\\d{1})";
        String zeroPercent = "0%";

        driver.findElement(downloadButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(15000));
        Pattern pattern = Pattern.compile(expectedPercent);
        wait.until(ExpectedConditions.textMatches(percentText, pattern));
        driver.navigate().refresh();
        Assertions.assertEquals(driver.findElement(percentText).getText(), zeroPercent);
    }

    @AfterEach
    @Override
    protected void cleanup() {
        super.cleanup();
    }
}
