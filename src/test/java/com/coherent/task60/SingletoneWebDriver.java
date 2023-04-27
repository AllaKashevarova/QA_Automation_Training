package com.coherent.task60;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public final class SingletoneWebDriver {
    private static RemoteWebDriver driver;
    private static PropertiesHelper propertiesHelper = new PropertiesHelper();
    private static String environment1PropFile = "environment_1.properties";


   private SingletoneWebDriver() {
    }

    public static WebDriver getDriver(){
        String platformName = propertiesHelper.propertiesReader("platform", environment1PropFile);
        String browserVersion = propertiesHelper.propertiesReader("browserVersion", environment1PropFile);
        String browserArguments = propertiesHelper.propertiesReader("browser.arguments", environment1PropFile);
        String saucelabsBuild = propertiesHelper.propertiesReader("saucelabs.build", environment1PropFile);
        String saucelabsName = propertiesHelper.propertiesReader("saucelabs.name", environment1PropFile);


        switch (browserName){
            case "chrome":
                ChromeOptions browserOptions = new ChromeOptions();

                browserOptions.setPlatformName(platformName);
                browserOptions.setBrowserVersion(browserVersion);
                browserOptions.addArguments(browserArguments);
                driver = new ChromeDriver(browserOptions);

                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPlatformName(platformName);
                firefoxOptions.setBrowserVersion(browserVersion);

                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setPlatformName(platformName);
                edgeOptions.setBrowserVersion(browserVersion);

                driver = new EdgeDriver(edgeOptions);
                break;

        }

        //How to make this code unique for each browser?
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", saucelabsBuild);
        sauceOptions.put("name", saucelabsName);
        browserOptions.setCapability("sauce:options", sauceOptions);



        //EdgeOptions browserOptions = new EdgeOptions();
        //FirefoxOptions browserOptions = new FirefoxOptions();

//        browserOptions.setPlatformName(platformName);
//        browserOptions.setBrowserVersion(browserV);

//        browserOptions.addArguments("--remote-allow-origins=*");


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
