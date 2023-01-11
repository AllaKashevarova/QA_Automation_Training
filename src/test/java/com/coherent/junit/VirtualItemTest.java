package com.coherent.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import shop.VirtualItem;

public class VirtualItemTest {

 @DisplayName("Size on Disk check")

    @Test
    public void checkSizeOnDisk() {
        VirtualItem virtualItem = new VirtualItem();
        virtualItem.setSizeOnDisk(120);

        double compareSize = 120;
        Assertions.assertEquals(compareSize, virtualItem.getSizeOnDisk());

    }
}
