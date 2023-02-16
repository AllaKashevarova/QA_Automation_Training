package com.coherent.task30;
import com.coherent.task40.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.coherent.task40.TestConstants.YANDEX_LOGIN_PAGE;


public class YandexLoginParametrized {
    WebDriver driver = new ChromeDriver();
    Locators locator = new Locators();

    @BeforeEach
    void setUp() {
        BaseTest.setup(driver, YANDEX_LOGIN_PAGE);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logInData.csv")
    @Test
    public void testLogIn(String name, String password) throws InterruptedException {
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
