package com.coherent.task30;

import com.coherent.task40.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static com.coherent.task40.TestConstants.YANDEX_LOGIN_PAGE;

public class YandexLogin extends BaseTest {
    WebDriver driver = new ChromeDriver();
    Locators locator = new Locators();
    private String username = "fine.lname";
    private String password = "p8Usc@jheBHhUZ3";

    @Override
    public void setup() {
        super.setup();
    }

    @Test
    void logInYandexMailbox() {
        driver.get(YANDEX_LOGIN_PAGE);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        driver.findElement(locator.logInButtonMain).click();
        wait.until(ExpectedConditions.elementToBeClickable(locator.userName));
        driver.findElement(locator.userName).sendKeys(username);
        driver.findElement(locator.logInButton).click();
        driver.findElement(locator.passwordField).sendKeys(password);
        driver.findElement(locator.logInButton2).click();
        driver.findElement(locator.UserImage).click();

        WebElement spanElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator.userNickName));
        String text = spanElement.getText();
        Assertions.assertEquals(username, text);
    }


}
