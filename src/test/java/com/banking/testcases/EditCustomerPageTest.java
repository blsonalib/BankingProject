package com.banking.testcases;

import com.banking.base.BaseClass;
import com.banking.base.BasePage;
import com.banking.pages.*;
import com.banking.util.IAutoConstant;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditCustomerPageTest extends BaseTest{
    EditCustomerPage editCustomerPage;
    LoginPage loginPage;
    ManagerHomePage managerHomePage;
    CreateMangerCredentialPage mangerCredentialPage;
    BasePage titleOfPage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage();
        managerHomePage = new ManagerHomePage();
        titleOfPage = new BaseClass();
        mangerCredentialPage = new CreateMangerCredentialPage();
        loginPage = mangerCredentialPage.getCilckOnBankinProjectLink();
        log.info("Click on banking project link");
        managerHomePage = loginPage.login(properties.getProperty("userID"), properties.getProperty("password"));
        log.info("Enter email and password");
        editCustomerPage = new EditCustomerPage();
        editCustomerPage = managerHomePage.getClickOnEditCustomerLink();
        log.info("Click on new customer link");
    }

    @Test
    public void verifyTitleTest() {
        String title = titleOfPage.getTitleOnPage();
        Assert.assertEquals(title, IAutoConstant.EDIT_CUSTOMER_PAGE_TITLE);
    }

    @Test
    public void addCustomerAccountNumberTest() {
        editCustomerPage.setAccountNo("1234567812345");
        editCustomerPage.getClickOnSubmitbutton();
    }

    @Test
    public void clickOnHomeLinkReturnTohomePageTest() {
        managerHomePage = editCustomerPage.clickOnHomeLink();
        log.info("Return to home page");
    }
}
