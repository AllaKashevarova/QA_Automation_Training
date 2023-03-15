package com.coherent.task60;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
//import org.junit.rules.TestWatcher;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.runner.Description;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestResultLoggerExtension implements TestWatcher, AfterAllCallback {
    private List<TestResultStatus> testResultsStatus = new ArrayList<>();
    private ScreenshotHelper screenshotHelper = new ScreenshotHelper();
    private LoginPage loginPage = new LoginPage();
    private PropertiesHelper propertiesHelper = new PropertiesHelper();
    private String path = propertiesHelper.propertiesReader("error.screenshots");

    // @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
//        Map<TestResultStatus, Long> summary = testResultsStatus.stream()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    }

    private enum TestResultStatus {
         FAILED
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
        System.out.println("Test Failed for test {}: ");

        screenshotHelper.takeScreenshot(loginPage.getDriver(), path);
    }
}

