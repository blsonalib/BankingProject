package com.banking.testcases;

import com.banking.base.BaseClass;
import com.banking.base.BasePage;
import com.banking.pages.CreateMangerCredentialPage;
import com.banking.pages.LoginPage;
import com.banking.pages.ManagerHomePage;
import com.banking.util.IAutoConstant;
import com.banking.util.JsonReader;
import com.banking.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private ManagerHomePage managerHomePage;
    private CreateMangerCredentialPage mangerCredentialPage;
    private BasePage titleOfPage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage();
        managerHomePage = new ManagerHomePage();
        titleOfPage = new BaseClass();
        mangerCredentialPage = new CreateMangerCredentialPage();
        loginPage = mangerCredentialPage.getCilckOnBankinProjectLink();
    }

    @Test(description = "Login page title test")
    public void verifyTitleOfLoginPageTest()  {
        String title = titleOfPage.getTitleOnPage();
        Assert.assertEquals(title, IAutoConstant.LOGIN_PAGE_TITLE);

    }

   @Test(dataProvider = "Login",description = "Login with credential")
    public void login(String userName, String password) {
        managerHomePage = loginPage.login(userName, password);
        Assert.assertNotNull(managerHomePage);
    }

    @DataProvider(name = "Login")
    public Object[][] passData() throws FileNotFoundException {
        return JsonReader.getdata(IAutoConstant.JSON_LOGIN_PATH, "Login", 2, 2);
    }
}
