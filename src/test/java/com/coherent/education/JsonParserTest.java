package com.coherent.education;

import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import parser.JsonParser;
import parser.NoSuchFileException;
import parser.Parser;
import shop.Cart;
import shop.RealItem;

import java.io.*;

public class JsonParserTest implements Parser{

    Cart allaCart = new Cart("alla-cart");

    Gson gson;

    public JsonParserTest(Gson gson) {
        this.gson = gson;
    }
    @Override
    public Cart readFromFile(File file){
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return gson.fromJson(reader.readLine(), Cart.class);
        } catch (FileNotFoundException ex) {
            throw new NoSuchFileException(String.format("File %s.json not found!", file), ex);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeToFile(Cart cart) {

    }


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
        Parser jsonParserTest = new JsonParserTest();
        Cart comparableCart = jsonParserTest.readFromFile(new File("src/main/resources/alla-cart.json"));
        comparableCart.getTotalPrice();
        comparableCart.showItems();



        Assertions.assertEquals(allaCart.getTotalPrice(), comparableCart.getTotalPrice());

    }



}


