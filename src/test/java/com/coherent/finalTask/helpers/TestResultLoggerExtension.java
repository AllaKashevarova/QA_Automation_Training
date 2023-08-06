package com.coherent.finalTask.helpers;

import com.coherent.task60.PropertiesHelper;
import com.coherent.task60.ScreenshotHelper;
import com.coherent.task60.SingletoneWebDriver;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class TestResultLoggerExtension implements TestWatcher, AfterAllCallback {
    private com.coherent.task60.ScreenshotHelper screenshotHelper = new ScreenshotHelper();
    private com.coherent.task60.PropertiesHelper propertiesHelper = new PropertiesHelper();
    private String path = propertiesHelper.propertiesReader("error.screenshots", "login.properties");

    public void afterAll(ExtensionContext extensionContext) throws Exception {
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        TestWatcher.super.testDisabled(context, reason);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        TestWatcher.super.testSuccessful(context);
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        TestWatcher.super.testAborted(context, cause);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String testName = context.getDisplayName();
        System.out.println("Test Failed for test: " + testName);
        byte[] screenshot = screenshotHelper.attachScreenshot(SingletoneWebDriver.getDriver());
        attachScreenshot(screenshot);
    }

    @Attachment(value = "Screenshot", type = "image/png")
    private byte[] attachScreenshot(byte[] screenshot) {
        return screenshot;
    }
}
