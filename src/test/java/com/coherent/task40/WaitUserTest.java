package com.coherent.task40;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


import static com.coherent.task40.TestConstants.*;

public class WaitUserTest extends BaseTest {
    private By userImage = By.xpath("//div[@id='loading']/img");

    @Test
    public void userAppearTest(){
        driver.get(DYNAMIC_DATA_PAGE);
        driver.findElement(By.id("save")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(userImage));

        Assertions.assertTrue(element.isDisplayed());
    }
}
