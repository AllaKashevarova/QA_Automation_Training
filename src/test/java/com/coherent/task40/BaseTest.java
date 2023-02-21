package com.coherent.task40;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver = new ChromeDriver();
    //String source;

    @BeforeEach
    public void setup() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1700, 1000));
        //driver.get(source);
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
