package com.coherent.task60;

import java.io.IOException;

public class Temp {

    public static void main(String[] args) throws IOException {
        PropertiesHelper propertiesHelper = new PropertiesHelper();
        System.out.println(propertiesHelper.propertiesReader("url"));
    }
}
