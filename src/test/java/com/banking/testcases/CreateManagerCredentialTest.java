package com.banking.testcases;

import com.banking.base.BaseClass;
import com.banking.base.BasePage;
import com.banking.pages.CreateMangerCredentialPage;
import com.banking.pages.LoginPage;
import com.banking.pages.ManagerHomePage;
import com.banking.util.IAutoConstant;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CreateManagerCredentialTest extends BaseTest {
    private CreateMangerCredentialPage mangerCredentialPage;
    public LoginPage loginPage;
    public ManagerHomePage managerHomePage;
    BasePage titleOfPage;

    @BeforeMethod
    public void setUp() {
        mangerCredentialPage = new CreateMangerCredentialPage();
        loginPage = new LoginPage();
        managerHomePage = new ManagerHomePage();
        titleOfPage = new BaseClass();
    }

    @Test(description = "Create manager credential page test")
    public void verifyTitleOfCreateManagerCredentialPage() {
        String title = titleOfPage.getTitleOnPage();
        Assert.assertEquals(title, IAutoConstant.CREATE_MANAGER_CREDENTIAL_TITLE);
    }

    @Test(description = "verify the logo")
    public void verifyLogoTest() {
        boolean logo = mangerCredentialPage.verifyLogo();
        Assert.assertTrue(logo);
    }

    @Test(description = "Loging this page by email id and click on submit button then create manger credential")
    public void loginWithEmailIdTest() {
        mangerCredentialPage.setEmailID(properties.getProperty("emailId"));
        mangerCredentialPage.clickOnSubmitButton();

    }

    @Test(description = "Click on banking project link then open the login page")
    public void getBankingProjectLinkTest() {
        loginPage = mangerCredentialPage.getCilckOnBankinProjectLink();
    }
}
