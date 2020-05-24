package com.banking.testcases;

import com.banking.base.BaseClass;
import com.banking.base.BasePage;
import com.banking.pages.*;
import com.banking.util.IAutoConstant;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

    @Test
    public void verifyTitleOfPageTest() {
        String title = titleOfPage.getTitleOnPage();
        Assert.assertEquals(title, IAutoConstant.MANAGER_HOMEPAGE_PAGE_TITLE);
        log.info("Title is matched");
    }

    @Test
    public void clickOnNewCustomerPageTest() {
        newCustomerPage = managerHomePage.getClickOnNewCustomerLink();
        log.info("Click on new customer link");
    }

    @Test
    public void clickOnEditCustomerPageTest() {
        editCustomer = managerHomePage.getClickOnEditCustomerLink();
        log.info("Click on edit customer link");
    }
}
