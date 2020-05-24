package com.banking.testcases;

import com.banking.base.BaseClass;
import com.banking.util.TestUtil;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class BaseTest extends BaseClass {
    public BaseTest() {
        super();
    }

    @BeforeClass
    public void beforeClass() {
        initialize("chrome");
        log.info("intialize the browser");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
        log.info("Close the browser");
    }
}
