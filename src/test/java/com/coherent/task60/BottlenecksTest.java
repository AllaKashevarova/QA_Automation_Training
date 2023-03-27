package com.coherent.task60;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpHead;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.HttpClient;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BottlenecksTest {
    private WebDriver driver;
    private String downloadPath = "/Users/alakashavarava/Documents/GitHub/QA_Automation_Training/src/test/resources/downloads/";

    @Test
    public void downloadFileRevisitedTest() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", downloadPath);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);

        driver.get("http://the-internet.herokuapp.com/download");
        String link = driver.findElement(By.cssSelector(".example a:nth-of-type(1)")).getAttribute("href");
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpHead request = new HttpHead(link);
        HttpResponse response = httpClient.execute(request);
        String contentType = response.getFirstHeader("Content-Type").getValue();
        int contentLength = Integer.parseInt(response.getFirstHeader("Content-Length").getValue());

        driver.findElement(By.cssSelector(".example a:nth-of-type(1)")).click();

        try {
            Thread.sleep(5000); // Wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String fileName = driver.findElement(By.cssSelector(".example a:nth-of-type(1)")).getText();
        File file = new File(downloadPath + fileName);
        Assertions.assertTrue(file.exists());

//        Assertions.assertEquals(contentType, "application/octet-stream");
//        Assertions.assertNotEquals(contentLength, 0);

        if (file.exists() == true) {
            file.delete();
        }
        else System.out.println("File hasn't been found");
        driver.close();
    }

}



