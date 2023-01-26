package com.coherent.testng;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import shop.RealItem;

public class RealItemTNG {


    @BeforeMethod
    public void beforeTest(){
        System.out.println("RealItem test has been invoked");
    }


    @Test (groups = {"Regression.RealItem"})
    public void checkWeight() {
        RealItem realItem = new RealItem();
        realItem.setWeight(100);

        double weight = 100;
        Assertions.assertEquals(realItem.getWeight(), weight);
    }

    @AfterMethod
    public void afterTest(){
        System.out.println("RealItem test has been completed");
    }
}
