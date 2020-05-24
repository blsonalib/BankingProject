package com.banking.testcases;

import com.banking.base.BaseClass;
import com.banking.pages.LoginPage;
import com.banking.pages.ManagerHomePage;
import com.banking.pages.NewCustomerPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewCustomerPageTest extends BaseClass {
    NewCustomerPage newCustomerPage;
    LoginPage loginPage;
    ManagerHomePage managerHomePage;
    public NewCustomerPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialize();
        loginPage = new LoginPage();
        managerHomePage = new ManagerHomePage();
        managerHomePage = loginPage.login(properties.getProperty("userID"),properties.getProperty("password"));
        log.info("enter email and password");
        newCustomerPage = new NewCustomerPage();
        newCustomerPage = managerHomePage.clickOnNewCustomerLink();
        log.info("click on new customer link");
    }

    @Test
    public void verifyTitleTest(){
        String titleName = newCustomerPage.verifyTitle();
        Assert.assertEquals(titleName,"Gtpl Bank New Customer Entry Page");
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
