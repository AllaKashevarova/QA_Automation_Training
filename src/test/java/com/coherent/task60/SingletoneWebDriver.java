package com.coherent.task60;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.MutableCapabilities;
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

    public static WebDriver getDriver() {
        String platformName = propertiesHelper.propertiesReader("platform", environment1PropFile);
        String browserName = propertiesHelper.propertiesReader("browser", environment1PropFile);
        String browserVersion = propertiesHelper.propertiesReader("browserVersion", environment1PropFile);
        String browserArguments = propertiesHelper.propertiesReader("browser.arguments", environment1PropFile);
        String saucelabsBuild = propertiesHelper.propertiesReader("saucelabs.build", environment1PropFile);
        String saucelabsUrl = propertiesHelper.propertiesReader("saucelabs.url", environment1PropFile);
        String saucelabsName = propertiesHelper.propertiesReader("saucelabs.name", environment1PropFile);
        MutableCapabilities mutableCapabilities = null;

        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", saucelabsBuild);
        sauceOptions.put("name", saucelabsName);

        switch (browserName) {
            case "CHROME":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPlatformName(platformName);
                chromeOptions.setBrowserVersion(browserVersion);
                chromeOptions.setCapability("sauce:options", sauceOptions);
                mutableCapabilities = chromeOptions;
                break;
            case "FIREFOX":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPlatformName(platformName);
                firefoxOptions.setBrowserVersion(browserVersion);

                firefoxOptions.setCapability("sauce:options", sauceOptions);
                mutableCapabilities = firefoxOptions;
                break;
            case "EDGE":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setPlatformName(platformName);
                edgeOptions.setBrowserVersion(browserVersion);
                mutableCapabilities = edgeOptions;
                break;
            default:
                throw new IllegalArgumentException("Invalid Browser name. Use one of the following: Chrome, Firefox, Edge");
        }

        URL url = null;
        try {
            url = new URL("https://oauth-allieishere2-509c8:ff01d6ac-17b9-47fe-8c63-8bfe8da19482@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        if (driver == null) {
            driver = new RemoteWebDriver(url, mutableCapabilities);
            driver.manage().window().setSize(new Dimension(1700, 1000));
        }
        return driver;
    }

    public static void cleanup() {
        driver.close();
        driver = null;
    }
}
