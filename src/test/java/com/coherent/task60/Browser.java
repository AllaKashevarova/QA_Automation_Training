package com.coherent.task60;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
    //QUESTION: is that correct approach to call singleton pattern?
    private static WebDriver driver = new ChromeDriver();
    //private SingletoneWebDriver singleToneWebDriver = SingletoneWebDriver.(driver);


    public static WebDriver driver() {
        return driver;
    }

    public static void open(String url) {
        driver.get(url);
    }

    public static void close() {
        driver.close();
    }
}
