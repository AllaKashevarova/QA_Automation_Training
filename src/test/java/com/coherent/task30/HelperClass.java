package com.coherent.task30;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(value = Parameterized.class)
public class HelperClass {
        public String email;
        public String password;

    @Parameters
    public static Collection testData() throws IOException {
        return getTestData("/logInData.csv") ;
    }

    public HelperClass(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static Collection<String[]> getTestData(String fileName)
            throws IOException {
        List<String[]> records = new ArrayList<String[]>();
        String record;
        BufferedReader file = new BufferedReader(new
                FileReader(fileName));
        while ((record=file.readLine())!=null) {
            String fields[] = record.split(",");
            records.add(fields);
        }
        file.close();
        return records;
    }

    //    @Parameters
//    public static Collection testData() {
//        return Arrays.asList(
//                new Object[][] {
//                        {"fine.lname","p8Usc@jheBHhUZ3"},
//                        {"Bla","Bla"}
//                } );
//    }

}
