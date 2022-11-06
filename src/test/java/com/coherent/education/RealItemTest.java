package com.coherent.education;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import shop.RealItem;

public class RealItemTest {

    @BeforeEach
    public void messageBeforeTest() {
        System.out.println("Verify getter and setter work as expected");
    }

    @DisplayName("Weight check")
    @Test
    public void checkWeight() {
        RealItem realItem = new RealItem();
        realItem.setWeight(100);

        double weight = 100;
        Assertions.assertEquals(realItem.getWeight(), weight);
    }


}
