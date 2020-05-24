package com.banking.testcases;

import com.banking.base.BaseClass;
import com.banking.base.BasePage;
import com.banking.pages.CreateMangerCredentialPage;
import com.banking.pages.LoginPage;
import com.banking.pages.ManagerHomePage;
import com.banking.pages.NewCustomerPage;
import com.banking.util.IAutoConstant;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewCustomerPageTest extends BaseTest {
    private NewCustomerPage newCustomerPage;
    private LoginPage loginPage;
    private ManagerHomePage managerHomePage;
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
        newCustomerPage = new NewCustomerPage();
        newCustomerPage = managerHomePage.getClickOnNewCustomerLink();
        log.info("Click on new customer link");
    }

    @Test
    public void verifyTitleTest() {
        String title = titleOfPage.getTitleOnPage();       //override
        Assert.assertEquals(title, IAutoConstant.NEW_COSTOMER_PAGE_TITLE);
        log.info("title is matched");
    }

    @Test
    public void addAllFieldOfNewCustomerTest() {
        newCustomerPage.setCustomerName("sona");
        newCustomerPage.setGender();
        newCustomerPage.setDateOfBirth("19/05/1994");
        newCustomerPage.setAddress("casalotus");
        newCustomerPage.setCity("Nagpur");
        newCustomerPage.setState("maharashtra");
        newCustomerPage.setPinCode("4410004");
        newCustomerPage.setTelephoneNumber("9910006680");
        newCustomerPage.setEmailId("sonabankar@gmail.com");
        newCustomerPage.setSubmitButton();
        log.info("enter all the data of new customer and click on submit link");
    }

    @Test
    public void clickOnHomeLinkReturnTohomePageTest() {
        managerHomePage = newCustomerPage.clickOnHomeLink();
        log.info("return to home page");
    }
}
