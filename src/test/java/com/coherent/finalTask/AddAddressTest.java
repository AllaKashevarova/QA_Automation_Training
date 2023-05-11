package com.coherent.finalTask;

import com.coherent.task60.TestResultLoggerExtension;
import io.qameta.allure.Feature;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestResultLoggerExtension.class)
@ExtendWith({AllureJunit5.class})
@Feature("Add Address")
@Tag("AP-3")

public class AddAddressTest {
}
