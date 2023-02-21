package com.coherent.task40;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.coherent.task40.TestConstants.DROPDOWN_PAGE;

public class MultiselectTest extends BaseTest{
    //WebDriver driver = new ChromeDriver();
    By multiSelectDropdown = By.id("multi-select");
    List<String> actualOptionsList = new ArrayList<>();
    List<String> expectedOptionsList = Arrays.asList("California", "Florida", "New Jersey");

    @Override
    public void setup() {
        super.setup();
    }

    @Test
    public void testDropdown() {
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
    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
