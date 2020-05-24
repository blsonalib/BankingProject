package com.banking.testcases;

import com.banking.base.BaseClass;
import com.banking.base.BasePage;
import com.banking.pages.*;
import com.banking.util.IAutoConstant;
import com.banking.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ManagerHomePageTest extends BaseTest {
    private ManagerHomePage managerHomePage;
    private LoginPage loginPage;
    private NewCustomerPage newCustomerPage;
    private EditCustomerPage editCustomer;
    private CreateMangerCredentialPage mangerCredentialPage;
    private BasePage titleOfPage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage();
        titleOfPage = new BaseClass();
        managerHomePage = new ManagerHomePage();
        newCustomerPage = new NewCustomerPage();
        editCustomer = new EditCustomerPage();
        mangerCredentialPage = new CreateMangerCredentialPage();
        loginPage = mangerCredentialPage.getCilckOnBankinProjectLink();
        managerHomePage = loginPage.login(properties.getProperty("userID"), properties.getProperty("password"));
        log.info("enter email and password");
    }

    @Test(description = "Manager page title test")
    public void verifyTitleOfPageTest() throws IOException {
        String title = titleOfPage.getTitleOnPage();
        Assert.assertEquals(title, IAutoConstant.MANAGER_HOMEPAGE_PAGE_TITLE);
        captureScreen(driver,"verifyTitleOfPageTest");
        log.info("Title is matched");

    }

    @Test(description = "To click on new customer link new customer page open")
    public void clickOnNewCustomerPageTest() {
        newCustomerPage = managerHomePage.getClickOnNewCustomerLink();
        log.info("Click on new customer link");
    }

    @Test(description = "To click on edit customer link new customer page open")
    public void clickOnEditCustomerPageTest() {
        editCustomer = managerHomePage.getClickOnEditCustomerLink();
        log.info("Click on edit customer link");
    }
}
