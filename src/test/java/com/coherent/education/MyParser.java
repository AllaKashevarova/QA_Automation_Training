package com.coherent.education;

import com.google.gson.Gson;
import parser.NoSuchFileException;
import shop.Cart;

import java.io.*;

public class MyParser {

    public static void writeToFile(Cart cart) {
        try (FileWriter writer = new FileWriter("src/main/resources/" + cart.getCartName() + ".json")) {
            writer.write(new Gson().toJson(cart));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Cart readFromFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return new Gson().fromJson(reader.readLine(), Cart.class);
        } catch (FileNotFoundException ex) {
            throw new NoSuchFileException(String.format("File %s.json not found!", file), ex);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
