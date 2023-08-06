package com.coherent.finalTask.pages;

import com.coherent.finalTask.tests.SingletonWebDriver;
import com.coherent.finalTask.constants.TestConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageBaseClass {
    protected static WebDriver driver;
    protected static TestConstants testConstants = new TestConstants();

    public PageBaseClass() {
        this.driver = SingletonWebDriver.getDriver();
        PageFactory.initElements(driver, this);
    }
}
