package com.coherent.task60;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.util.Properties;

public class EnvironmentHelper {

    private static PropertiesHelper propertiesHelper = new PropertiesHelper();
    private static String environment1PropFile = "environment_1.properties";
    private static WebDriver driver;

    public static String selectEnvironment(String browserName){

//        switch (browserName){
//            case "chrome":
//                ChromeOptions chromeOptions = new ChromeOptions();
//
//                String platformName = propertiesHelper.propertiesReader("platform", environment1PropFile);
//                String browserV = propertiesHelper.propertiesReader("browserVersion", environment1PropFile);
//
//                chromeOptions.setPlatformName(platformName);
//                chromeOptions.setBrowserVersion(browserV);
//                chromeOptions.addArguments("--remote-allow-origins=*");
//
//                driver = new ChromeDriver(chromeOptions);
//                break;
//
//        }



    }


}
