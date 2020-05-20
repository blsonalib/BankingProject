package com.banking.testcases;

import com.banking.base.BaseTest;
import com.banking.pages.LoginPage;
import com.banking.pages.ManagerHomePage;
import com.banking.pages.NewCustomerPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewCustomerPageTest extends BaseTest {
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
        newCustomerPage = new NewCustomerPage();
        newCustomerPage = managerHomePage.clickOnNewCustomerLink();
    }

    @Test
    public void addAllFieldTest() {
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
    }
}
