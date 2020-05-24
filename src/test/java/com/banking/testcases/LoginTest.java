package com.banking.testcases;

import com.banking.base.BaseClass;
import com.banking.base.BasePage;
import com.banking.pages.CreateMangerCredentialPage;
import com.banking.pages.LoginPage;
import com.banking.pages.ManagerHomePage;
import com.banking.util.IAutoConstant;
import com.banking.util.JsonReader;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginTest extends BaseClass {
    private LoginPage loginPage;
    private ManagerHomePage managerHomePage;
    private CreateMangerCredentialPage mangerCredentialPage;
    BasePage titleOfPage;

    public LoginTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialize();
        mangerCredentialPage = new CreateMangerCredentialPage();
        loginPage = new LoginPage();
        managerHomePage = new ManagerHomePage();
        titleOfPage = new BaseClass();
        loginPage = mangerCredentialPage.getBankinProjectLink();
        managerHomePage = loginPage.login(properties.getProperty("userID"), properties.getProperty("password"));
    }

    @Test
    public void verifyTitleOfLoginPageTest() throws IOException {
        String title = titleOfPage.getTitleOnPage();
        Assert.assertEquals(title,IAutoConstant.LOGIN_PAGE_TITLE);
    }

    @Test(dataProvider = "Login")
    public void login(String userName, String password) {
        managerHomePage = loginPage.login(userName, password);
        Assert.assertNotNull(managerHomePage);
    }

    @DataProvider(name = "Login")
    public Object[][] passData() throws FileNotFoundException {
        return JsonReader.getdata(IAutoConstant.JSON_LOGIN_PATH, "Login", 2, 2);
    }

    @AfterMethod
    public void tearDown() throws IOException {
        driver.quit();
        log.info("Browser closed");
    }
}
