package com.coherent.education;

import com.google.gson.Gson;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import parser.JsonParser;
import parser.NoSuchFileException;
import parser.Parser;
import shop.Cart;
import shop.RealItem;

import java.io.*;

public class
JsonParserTest {

    Cart allaCart = new Cart("alla-cart");
    Cart allaCart2 = new Cart("alla-cart-2");

    @DisplayName("Check writeFromFile method")
    @Test
    public void checkFileWritesCorrectly() throws IOException {
        //existing logic
        RealItem newItem = new RealItem();
        newItem.setName("Item A");
        newItem.setWeight(100);
        newItem.setPrice(25);
        allaCart.addRealItem(newItem);

        JsonParser jsonParser = new JsonParser();
        jsonParser.writeToFile(allaCart);
        allaCart.showItems();
        allaCart.getTotalPrice();

        //my method to compare with existing logic
        Cart comparableCart = MyParser.readFromFile(new File("src/main/resources/alla-cart.json"));
        comparableCart.getTotalPrice();
        comparableCart.showItems();

        Assertions.assertEquals(allaCart.getTotalPrice(), comparableCart.getTotalPrice());
    }
    //TODO create one more test for readFromFile. for exception test: parametrized test - assertions with exceptions + grouped assertion

    @BeforeAll
    public void beforeEach() {
        System.out.println("Checking another argument");
    }

    @DisplayName("Check readFromFile method - price")
    @ParameterizedTest
    @ValueSource(ints = {10, 12, 33, 0, 99})
    public void checkReadsFromFileCorrectly(int totalPrice) {
        RealItem newItem = new RealItem();
        newItem.setName("Apple");
        newItem.setWeight(50);
        newItem.setPrice(10);
        allaCart2.addRealItem(newItem);

        JsonParser jsonParser = new JsonParser();
        jsonParser.writeToFile(allaCart2);

        Cart allaCart2 = MyParser.readFromFile(new File("src/main/resources/alla-cart-2.json"));
        allaCart2.getTotalPrice();

        Assertions.assertEquals(allaCart2.getTotalPrice(), totalPrice);

    }

    @Disabled("Disabled as has been asked in the task")
    @DisplayName("Check Group Assertions")
    @Test
    void testGroupAssertions() {
        Cart allaCart2 = MyParser.readFromFile(new File("src/main/resources/alla-cart-2.json"));
        Assertions.assertAll("cartCheck",
                () -> Assertions.assertEquals(12, allaCart2.getTotalPrice()),
                        () -> Assertions.assertEquals("Bla-Bla", allaCart2.getCartName())
                                );


    }
}


