package com.coherent.testng;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import shop.VirtualItem;

public class VirtualItemTNG {

    @BeforeMethod
    public void indicateTestStarted(){
        System.out.println("VirtualItem test has been invoked");
    }

    @Test (groups = {"Item.Virtual"})
    public void checkSizeOnDisk() {
        VirtualItem virtualItem = new VirtualItem();
        virtualItem.setSizeOnDisk(120);

        double compareSize = 120;
        Assertions.assertEquals(compareSize, virtualItem.getSizeOnDisk());

    }

    @AfterMethod
    public void indicateTestCompleted(){
        System.out.println("VirtualItem test has been completed");
    }

}
