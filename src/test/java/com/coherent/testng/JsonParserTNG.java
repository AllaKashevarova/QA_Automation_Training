package com.coherent.testng;

import com.coherent.junit.MyParser;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.*;
import parser.JsonParser;
import parser.NoSuchFileException;
import shop.Cart;
import shop.RealItem;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonParserTNG {

    String cartName = "alla-cart-testNG";
    Cart allaCart = new Cart(cartName);
    JsonParser jsonParser = new JsonParser();
    String pathName = "src/main/resources/alla-cart-testNG.json";

    @BeforeMethod
    public void createCart() {
        RealItem newItem = new RealItem();
        newItem.setName("Item A");
        newItem.setWeight(100);
        newItem.setPrice(25);
        allaCart.addRealItem(newItem);
        jsonParser.writeToFile(allaCart);
    }

    //TODO Question!

    @Ignore
    @Test(groups = {"Smoke.Parser"})
    public void checkReadsFromFileCorrectly() {
        int totalPrice = 30;
        //This test fails. Looks like @AfterMethod is not working properly? TBD
        Cart allaCart = MyParser.readFromFile(new File(pathName));
        allaCart.getTotalPrice();
        Assertions.assertEquals(allaCart.getTotalPrice(), totalPrice);
    }

    @Test(groups = {"Regression.Parser"})
    public void checkFileName() {

        Cart allaCart = MyParser.readFromFile(new File(pathName));
        allaCart.getCartName();
        Assertions.assertEquals(allaCart.getCartName(), cartName);
    }


    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][]{
                {"src/main/resources/alla-bla"},
                {"src/main/resources/alla-cwedfewfdwef"},
                {"test"},
                {"src/main/resources"},
                {"123456"}
        };
    }

    @Test(expectedExceptions = {NoSuchFileException.class}, groups = {"Regression.Parser.Exception"}, dataProvider = "test1")
    public void exceptionTest(String pathToFile) {
        System.out.println("Invoked test string: " + pathToFile);
        jsonParser.readFromFile(new File(pathToFile));
    }

    @AfterMethod
    public void deleteCart() {
        File fileToDelete = new File(pathName);
        if (fileToDelete.delete()) {
            System.out.println(fileToDelete.getName() + ".json file has been deleted");
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
}
