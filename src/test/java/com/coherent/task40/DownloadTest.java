package com.coherent.task40;

import org.junit.Ignore;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v106.overlay.model.LineStyle;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class DownloadTest {
    WebDriver driver;


    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1700, 1000));
    }

    @Test
    public void download50Percentage() {
        By downloadButton = By.id("cricle-btn");
        By percentText = By.cssSelector(".percenttext");
        String expectedPercent = "50%";
        String zeroPercent = "0%";
        String source = "https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html";

        driver.get(source);
        driver.findElement(downloadButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));

        Pattern pattern = Pattern.compile("50%");
        wait.until(ExpectedConditions.textMatches(percentText, pattern));
        driver.navigate().refresh();

        Assertions.assertEquals(driver.findElement(percentText).getText(), zeroPercent);
    }

    @Test
    public void customObjectsTest() {
        String source = "https://demo.seleniumeasy.com/table-sort-search-demo.html";
        int expectedListSize = 4;
        driver.get(source);
        //STEP 1: get the List of all rows
        List<WebElement> allCustomersRawData = driver.findElements(By.xpath("//tbody/tr[@role='row']"));
        List<Customer> customersData = new ArrayList<>();
        for (int i = 0; i < allCustomersRawData.size(); i++) {
            String name = driver.findElement(By.xpath("//tbody/tr[" + (i + 1) + "]/td[@data-search]")).getText();
            String position = driver.findElement(By.xpath("//tbody/tr[" + (i + 1) + "]/td[2]")).getText();
            String office = driver.findElement(By.xpath("//tbody/tr[" + (i + 1) + "]/td[3]")).getText();
            String age = driver.findElement(By.xpath("//tbody/tr[" + (i + 1) + "]/td[4]")).getText();
            String salary = driver.findElement(By.xpath("//tbody/tr[" + (i + 1) + "]/td[6]")).getText();

            customersData.add(new Customer(name, position, office, age, salary));
        }
        //STEP 2: go through each row and verify if the condition has been met
        List<Customer> sortedCustomers = new ArrayList<>();
        for (Customer customer : customersData) {
            String modifiedSalary = customer.salary.substring(1, customer.salary.length() - 2).replaceAll(",", "");
            int salaryInt = Integer.parseInt(modifiedSalary);
            int ageInt = Integer.parseInt(customer.age);
            if (ageInt > 30 && salaryInt > 200000) {
                sortedCustomers.add(customer);
            }

            //System.out.println("Filtered customer's list: " + sortedCustomers);
            sortedCustomers.forEach(System.out::println);
        }
        int actualListsize = sortedCustomers.size();
        //System.out.println(actualListsize);
        Assertions.assertEquals(expectedListSize, actualListsize);
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
