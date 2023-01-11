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

    Cart allaCart = new Cart("alla-cart-testNG");
    JsonParser jsonParser = new JsonParser();

    @BeforeMethod
    public void createCart() {
        RealItem newItem = new RealItem();
        newItem.setName("Item A");
        newItem.setWeight(100);
        newItem.setPrice(25);
        allaCart.addRealItem(newItem);
        jsonParser.writeToFile(allaCart);
    }

    @Test
    public void checkFileWritesCorrectly() throws IOException {

        System.out.println("Newly created Cart details: ");
        allaCart.showItems();
        //allaCart.getTotalPrice();

        //my method to compare with existing logic
        Cart comparableCart = MyParser.readFromFile(new File("src/main/resources/alla-cart.json"));
        //comparableCart.getTotalPrice();
        System.out.println("Previously created Cart details: ");
        comparableCart.showItems();

        Assertions.assertEquals(allaCart.getTotalPrice(), comparableCart.getTotalPrice());
    }

    @Test
    public void checkReadsFromFileCorrectly() {
        int totalPrice = 12;
        Cart allaCart = MyParser.readFromFile(new File("src/main/resources/alla-cart-2.json"));
        allaCart.getTotalPrice();
        Assertions.assertEquals(allaCart.getTotalPrice(), totalPrice);
    }


    @Parameters({"src/main/resources/alla-cart-1234.json"})
    @Test(expectedExceptions = {NoSuchFileException.class})
    public void exceptionTest(String pathToFile){
        System.out.println("Invoked test string: " + pathToFile);
            jsonParser.readFromFile(new File(pathToFile));

    }


    @AfterMethod
    public void deleteCart() {
        File fileToDelete = new File("src/main/resources/alla-cart-testNG.json");
        if (fileToDelete.delete()) {
            System.out.println(fileToDelete.getName() + ".json file has been deleted");
        } else {
            System.out.println("Failed to delete the file.");
        }
    }


}
