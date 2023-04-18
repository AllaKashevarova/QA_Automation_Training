package com.coherent.task60;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public final class SingletoneWebDriver {
    private static RemoteWebDriver driver;

   private SingletoneWebDriver() {
    }

    public static WebDriver getDriver(){

       //QUESTION: If I want to run tests on several browsers and operating systems: how can I effectively set up the tests?
        ChromeOptions browserOptions = new ChromeOptions();
        //EdgeOptions browserOptions = new EdgeOptions();
        //FirefoxOptions browserOptions = new FirefoxOptions();
        browserOptions.setPlatformName("macOS 11.00");
        browserOptions.setBrowserVersion("latest");
        browserOptions.addArguments("--remote-allow-origins=*");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", "selenium-build-XC063");
        sauceOptions.put("name", "Mac + Chrome (latest)");
        browserOptions.setCapability("sauce:options", sauceOptions);

        URL url = null;
        try {
            url = new URL("https://oauth-allieishere2-509c8:ff01d6ac-17b9-47fe-8c63-8bfe8da19482@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        if(driver == null){
            driver = new RemoteWebDriver(url, browserOptions);
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
