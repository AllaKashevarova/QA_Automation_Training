package com.coherent.task40;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MultiselectTest {
    private WebDriver driver;
    private String resource = "https://demo.seleniumeasy.com/basic-select-dropdown-demo.html";
    By multiSelectDropdown = By.id("multi-select");
    List<String> actualOptionsList = new ArrayList<>();
    List<String> expectedOptionsList = Arrays.asList("California", "Florida", "New Jersey");

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1700, 1000));
    }

    @Test
    public void testDropdown() {
        driver.get(resource);
        WebElement dropdown = driver.findElement(multiSelectDropdown);
        Select dropdownSelect = new Select(dropdown);
        if (dropdownSelect.isMultiple()) {
            dropdownSelect.selectByIndex(0);
            dropdownSelect.selectByIndex(1);
            dropdownSelect.selectByIndex(2);
        }
        List<WebElement> selectedOptions = dropdownSelect.getAllSelectedOptions();
        for (WebElement webElement : selectedOptions) {
            actualOptionsList.add(webElement.getText());
        }

        Assertions.assertEquals(actualOptionsList, expectedOptionsList);
    }

    //TODO think about how to write the test below:
//    @Test
//    public void optionIsSelectedTest(){
//        driver.get(resource);
//        WebElement dropdown = driver.findElement(multiSelectDropdown);
//        Select dropdownSelect = new Select(dropdown);
//        if (dropdownSelect.isMultiple()) {
//            dropdownSelect.selectByIndex(0);
//            dropdownSelect.selectByIndex(1);
//            dropdownSelect.selectByIndex(2);
//        }
//
//        Assertions.assertTrue(? .isSelected);
//        }
//    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
