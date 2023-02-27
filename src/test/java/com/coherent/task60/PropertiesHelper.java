package com.coherent.task60;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHelper {


    public String propertiesReader(String prop) throws IOException {
        Properties properties = new Properties();
        InputStream inputStream;

        String propFileName = "login.properties";

        inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        if (inputStream != null) {
            properties.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }

        inputStream.close();

        return properties.getProperty(prop);

    }
}
