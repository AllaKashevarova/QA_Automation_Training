package com.coherent.junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import parser.JsonParser;
import parser.NoSuchFileException;
import shop.Cart;
import shop.RealItem;

import java.io.*;

public class JsonParserTest {

    Cart allaCart = new Cart("alla-cart");
    Cart allaCart2 = new Cart("alla-cart-2");
    JsonParser jsonParser = new JsonParser();


    @DisplayName("Check writeFromFile method")
    @Test
    public void checkFileWritesCorrectly() throws IOException {
        //existing logic
        RealItem newItem = new RealItem();
        newItem.setName("Item A");
        newItem.setWeight(100);
        newItem.setPrice(25);
        allaCart.addRealItem(newItem);

        jsonParser.writeToFile(allaCart);
        allaCart.showItems();
        allaCart.getTotalPrice();

        //my method to compare with existing logic
        Cart comparableCart = MyParser.readFromFile(new File("src/main/resources/alla-cart.json"));
        comparableCart.getTotalPrice();
        comparableCart.showItems();

        Assertions.assertEquals(allaCart.getTotalPrice(), comparableCart.getTotalPrice());
    }


    @BeforeEach
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
        Assertions.assertAll(
                () -> Assertions.assertEquals(12, allaCart2.getTotalPrice()),
                () -> Assertions.assertEquals("Bla-Bla", allaCart2.getCartName())
        );
    }


    @DisplayName("Test Exceptions")
    @ParameterizedTest
    @ValueSource(strings = {"src/main/resources/alla-cart-222.json", "src/main/resources.json", "src/main/resources/alla-cart-2.json"})
    void testExpectedExceptionPass(String pathToFile) {
        Exception exception = Assertions.assertThrows(NoSuchFileException.class,
                () -> jsonParser.readFromFile(new File(pathToFile)), "Such file does not exist");
    }
}


