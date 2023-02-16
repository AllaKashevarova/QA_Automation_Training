package com.coherent.task40;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static void setup(WebDriver driver, String source) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1700, 1000));
        driver.get(source);
    }

}
