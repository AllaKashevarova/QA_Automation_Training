package com.coherent.finalTask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.coherent.finalTask.TestConstants.*;

public class PageBaseClass {
    protected static WebDriver driver;
    protected static TestConstants testConstants = new TestConstants();

    public PageBaseClass() {
        this.driver = SingletonWebDriver.getDriver();
        PageFactory.initElements(driver, this);
    }
}
