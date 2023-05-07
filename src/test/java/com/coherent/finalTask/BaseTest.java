package com.coherent.finalTask;

import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(AllureJunit5.class)
public class BaseTest {

    @BeforeEach
    public void beforeEach(){

    }

    @AfterAll
    public static void cleanUp(){

    }
}
