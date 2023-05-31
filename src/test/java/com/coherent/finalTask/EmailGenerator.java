package com.coherent.finalTask;

import java.util.Date;
import java.util.Random;

public class EmailGenerator {

    public static String generateEmail() {
        Date date = new Date();
        long timestamp = date.getTime();
        Random random = new Random();
        int randomNumber = random.nextInt(1000);
        String email = "user" + timestamp + randomNumber + "@test.com";
        return email;
    }
}
