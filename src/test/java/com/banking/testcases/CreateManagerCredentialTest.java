package com.banking.testcases;

import com.banking.base.BaseTest;
import com.banking.pages.CreateMangerCredentialPage;
import com.banking.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateManagerCredentialTest extends BaseTest {
    private CreateMangerCredentialPage mangerCredentialPage;
    LoginPage loginPage;

    public CreateManagerCredentialTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialize();
        mangerCredentialPage = new CreateMangerCredentialPage();
        loginPage = new LoginPage();
    }

    @Test
    public void verifyLogoTest() {
        boolean logo = mangerCredentialPage.verifyLogo();
        Assert.assertTrue(logo);
    }

    @Test
    public void loginWithEmailIdTest() {
        mangerCredentialPage.setEmailID(properties.getProperty("emailId"));
        mangerCredentialPage.clickOnSubmitButton();

    }

    @Test
    public void getBankingProjectLinkTest() {
        loginPage = mangerCredentialPage.getBankinProjectLink();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
