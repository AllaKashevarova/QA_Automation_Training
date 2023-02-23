package com.coherent.task40;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static com.coherent.task40.TestConstants.DROPDOWN_PAGE;

public class MultiselectTest extends BaseTest{
    private By multiSelectDropdown = By.id("multi-select");
    private List<String> actualOptionsList = new ArrayList<>();

    @Test
    public void dropdownTest() {
        driver.get(DROPDOWN_PAGE);
        List<String> expectedOptionsList = Arrays.asList("California", "Florida", "New Jersey");
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
}
