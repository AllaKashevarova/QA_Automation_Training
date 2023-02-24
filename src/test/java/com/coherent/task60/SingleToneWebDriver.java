package com.coherent.task60;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class SingleToneWebDriver {
    private static SingleToneWebDriver uniqueInstance;
    private WebDriver driver;

    public SingleToneWebDriver(WebDriver driver) {
        this.driver = driver;
    }

    public static SingleToneWebDriver getUniqueInstance(WebDriver driver){
        if(uniqueInstance == null){
            uniqueInstance = new SingleToneWebDriver(driver);
        }
        return uniqueInstance;
    }
}
