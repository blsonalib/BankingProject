package com.banking.testcases;

import com.banking.base.BaseClass;
import com.banking.base.BasePage;
import com.banking.pages.*;
import com.banking.util.IAutoConstant;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ManagerHomePageTest extends BaseClass {
    private ManagerHomePage managerHomePage;
    private LoginPage loginPage;
    private NewCustomerPage newCustomerPage;
    private EditCustomer editCustomer;
    private NewAccount newAccount;
    private LogOutPage logOutPage;
    BasePage titleOfPage;
    public ManagerHomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialize();
        loginPage = new LoginPage();
        titleOfPage = new BaseClass();
        managerHomePage = loginPage.login(properties.getProperty("userID"), properties.getProperty("password"));
        log.info("enter email and password");
        managerHomePage = new ManagerHomePage();
        newCustomerPage = new NewCustomerPage();
        editCustomer = new EditCustomer();
        newAccount = new NewAccount();
        logOutPage = new LogOutPage();
    }

    @Test
    public void verifyTitleOfPageTest() {
        String title = titleOfPage.getTitleOnPage();
        Assert.assertEquals(title, IAutoConstant.MANAGER_HOMEPAGE_PAGE_TITLE);
        log.info("Title is matched");
    }

    @Test
    public void clickOnNewCustomerPageTest() {
        newCustomerPage = managerHomePage.getClickOnNewCustomerLink();
        log.info("click on new customer link");
    }

    @Test
    public void clickOnNewAccountPageTest() {
        newAccount = managerHomePage.getClickOnNewAccountLink();
        log.info("click on new account link");
    }

    @Test
    public void clickOnEditCustomerPageTest() {
        editCustomer = managerHomePage.getClickOnEditCustomerLink();
        log.info("click on edit customer link");
    }

    @Test
    public void clickOnLogOutPageTest() {
        logOutPage = managerHomePage.getClickOnLogOutPage();
        log.info("click on log out page");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
