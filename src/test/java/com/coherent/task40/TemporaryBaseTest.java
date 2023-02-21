package com.coherent.task40;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static com.coherent.task40.TestConstants.*;

public class TemporaryBaseTest {
    WebDriver driver = new ChromeDriver();


    @BeforeEach
    public void setup() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1700, 1000));
        driver.get(YANDEX_LOGIN_PAGE);
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
