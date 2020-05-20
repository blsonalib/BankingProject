package com.banking.testcases;

import com.banking.base.BaseTest;
import com.banking.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ManagerHomePageTest extends BaseTest {
    ManagerHomePage managerHomePage;
    LoginPage loginPage;
    NewCustomerPage newCustomerPage;
    EditCustomer editCustomer;
    NewAccount newAccount;
    LogOutPage logOutPage;
    public ManagerHomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialize();
        loginPage = new LoginPage();
        managerHomePage = loginPage.login(properties.getProperty("userID"),properties.getProperty("password"));
        managerHomePage = new ManagerHomePage();
        newCustomerPage = new NewCustomerPage();
        editCustomer = new EditCustomer();
        newAccount = new NewAccount();
        logOutPage = new LogOutPage();
    }
    @Test
    public void verifyTitleOfPageTest() {
       String title = managerHomePage.verifyTitle();
        Assert.assertEquals(title,"GTPL Bank Manager HomePage");
    }

    @Test
    public void clickOnNewCustomerPageTest() {
        newCustomerPage = managerHomePage.clickOnNewCustomerLink();
    }

    @Test
    public void clickOnNewAccountPageTest() {
        newAccount = managerHomePage.clickOnNewAccountLink();
    }

    @Test
    public void clickOnEditCustomerPageTest() {
        editCustomer = managerHomePage.clickOnEditCustomerLink();
    }

    @Test
    public void clickOnLogOutPageTest() {
       logOutPage = managerHomePage.clickOnLogOutPage();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
