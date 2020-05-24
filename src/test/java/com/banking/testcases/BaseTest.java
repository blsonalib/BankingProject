package com.banking.testcases;

import com.banking.base.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest extends BaseClass {
    public BaseTest() {
        super();
    }

    @BeforeClass
    public void beforeClass() {
        initialize();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
