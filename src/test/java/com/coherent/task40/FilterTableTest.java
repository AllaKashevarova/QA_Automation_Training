package com.coherent.task40;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

import static com.coherent.task40.TestConstants.SORT_TABLE_PAGE;

public class FilterTableTest {
    WebDriver driver = new ChromeDriver();

    @BeforeEach
    void setup() {
        BaseTest.setup(driver, SORT_TABLE_PAGE);
    }
    @Test
    public void customObjectsTest() {
        int expectedListSize = 4;
        List<WebElement> allCustomersRawData = driver.findElements(By.xpath("//tbody/tr[@role='row']"));
        List<Customer> customersData = new ArrayList<>();
        for (int i = 0; i < allCustomersRawData.size(); i++) {
            String name = driver.findElement(By.xpath("//tbody/tr[" + (i + 1) + "]/td[@data-search]")).getText();
            String position = driver.findElement(By.xpath("//tbody/tr[" + (i + 1) + "]/td[2]")).getText();
            String office = driver.findElement(By.xpath("//tbody/tr[" + (i + 1) + "]/td[3]")).getText();
            int age = Integer.parseInt(driver.findElement(By.xpath("//tbody/tr[" + (i + 1) + "]/td[4]")).getText());
            String salary = driver.findElement(By.xpath("//tbody/tr[" + (i + 1) + "]/td[6]")).getText();
            int modifiedSalary = Integer.parseInt(salary.substring(1, salary.length() - 2).replaceAll(",", ""));

            customersData.add(new Customer(name, position, office, age, modifiedSalary));
        }
        List<Customer> sortedCustomers = new ArrayList<>();
        for (Customer customer : customersData) {
            if (customer.getAge() > 30 && customer.getSalary() > 200000) {
                sortedCustomers.add(customer);
            }

        }
        sortedCustomers.forEach(System.out::println);
        int actualListSize = sortedCustomers.size();
        Assertions.assertEquals(expectedListSize, actualListSize);
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
