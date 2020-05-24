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

import java.io.IOException;

public class CreateManagerCredentialTest extends BaseClass {
    private CreateMangerCredentialPage mangerCredentialPage;
    public LoginPage loginPage;
    public ManagerHomePage managerHomePage;
    BasePage titleOfPage;

    public CreateManagerCredentialTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialize();
        mangerCredentialPage = new CreateMangerCredentialPage();
        loginPage = new LoginPage();
        managerHomePage = new ManagerHomePage();
        titleOfPage = new BaseClass();
    }

    @Test
    public void verifyTitleOfCreateManagerCredentialPage() {
        String title = titleOfPage.getTitleOnPage();
        Assert.assertEquals(title, IAutoConstant.CREATE_MANAGER_CREDENTIAL_TITLE);
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
    public void tearDown() throws IOException {
        driver.quit();
        log.info("Browser closed");
    }
}
