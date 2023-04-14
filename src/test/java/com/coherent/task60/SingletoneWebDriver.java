package com.coherent.task60;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public final class SingletoneWebDriver {
    private static WebDriver driver;

   private SingletoneWebDriver() {
    }

    public static WebDriver getDriver(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        if(driver == null){
            //driver = new ChromeDriver(options);
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            driver.manage().window().setSize(new Dimension(1700, 1000));
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        return driver;
    }

    public static void cleanup(){
        driver.close();
        driver = null;
    }
}
