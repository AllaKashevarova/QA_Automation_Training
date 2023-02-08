package com.coherent.task30;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
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

@RunWith(value = Parameterized.class)
public class YandexLoginParametrized {
    private static WebDriver driver;
    private String email;
    private String password;
    private String resource = "https://mail.yandex.com";
    Locators locator = new Locators();

//    @Parameters
//    public static Collection testData() {
//        return Arrays.asList(
//                new Object[][] {
//                        {"fine.lname","p8Usc@jheBHhUZ3"},
//                        {"Bla","Bla"}
//                } );
//    }

    @Parameters
    public static Collection testData() throws IOException {
        return getTestData("src/test/resources/logInData.csv") ;
    }

    public static Collection<String[]> getTestData(String fileName)
            throws IOException {
        List<String[]> records = new ArrayList<String[]>();
        String record;
        BufferedReader file = new BufferedReader(new
                FileReader(fileName));
        while ((record=file.readLine())!=null) {
            String fields[] = record.split(",");
            records.add(fields);
        }
        file.close();
        return records;
    }

    public YandexLoginParametrized(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testLogIn(){
        driver.get(resource);
        driver.findElement(locator.logInButtonMain).click();
        driver.findElement(locator.userNickName).sendKeys(email);
        driver.findElement(locator.logInButton).click();
        driver.findElement(locator.passwordField).sendKeys(password);
        driver.findElement(locator.logInButton2).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        WebElement spanElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator.userNickName));
        String nickName = spanElement.getText();

        Assertions.assertEquals(email, nickName);

    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
