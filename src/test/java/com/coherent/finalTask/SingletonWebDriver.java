package com.coherent.finalTask;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SingletonWebDriver {
    private static WebDriver driver;
    private static PropertiesHelper propertiesHelper = new PropertiesHelper();
    private static String environmentProperties = "environment.properties";
    private static String sauceLabsProperties = "sauceLabs.properties";
    private static String webDriverProperties = "WebDriverInstance.properties";

    public static WebDriver getDriver() {
        URL url = null;
        MutableCapabilities mutableCapabilities = null;
        //Environment properties:
        String platformName = propertiesHelper.propertiesReader("platform", environmentProperties);
        String browserName = propertiesHelper.propertiesReader("browser", environmentProperties);
        String browserVersion = propertiesHelper.propertiesReader("browserVersion", environmentProperties);
        //SauceLab properties:
        String saucelabsBuild = propertiesHelper.propertiesReader("saucelabs.build", sauceLabsProperties);
        String saucelabsUrl = propertiesHelper.propertiesReader("saucelabs.url", sauceLabsProperties);
        String saucelabsName = propertiesHelper.propertiesReader("saucelabs.name", sauceLabsProperties);
        //WebDriver properties:
        String webDriverInstance = propertiesHelper.propertiesReader("webdriver", webDriverProperties);

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
            default:
                throw new IllegalArgumentException("Invalid Browser name. Use one of the following: Chrome, Firefox, Edge");
        }

        try {
            url = new URL(saucelabsUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        if (driver == null) {
            switch (webDriverInstance) {
                case "LOCAL":
                    switch (browserName) {
                        case "CHROME":
                            driver = new ChromeDriver();
                            driver.manage().window().setSize(new Dimension(1700, 1000));
                            break;
                        case "FIREFOX":
                            driver = new FirefoxDriver();
                            driver.manage().window().setSize(new Dimension(1700, 1000));
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid Local Browser provided. Try CHROME or FIREFOX");
                    }

                    break;
                case "SAUCELAB":
                    driver = new RemoteWebDriver(url, mutableCapabilities);
                    driver.manage().window().setSize(new Dimension(1700, 1000));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid WebDriver instance provided. Try LOCAL or SAUCELAB")
            }
        }
        return driver;
    }

    public static void cleanup() {
        driver.close();
        driver = null;
    }

}
