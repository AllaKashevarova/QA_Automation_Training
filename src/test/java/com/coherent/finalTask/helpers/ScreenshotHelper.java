package com.coherent.finalTask.helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ScreenshotHelper {
    private Date d = new Date();
    private String TimeStamp = d.toString().replace(":", "_").replace(" ", "_");

    public void takeScreenshot(WebDriver driver, String fileWithPath) {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(fileWithPath + TimeStamp + ".png");
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] attachScreenshot(WebDriver driver) {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        byte[] screenshot = scrShot.getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }
}
