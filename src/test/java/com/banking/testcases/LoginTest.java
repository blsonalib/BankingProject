package com.banking.testcases;

import com.banking.base.BaseTest;
import com.banking.pages.CreateMangerCredentialPage;
import com.banking.pages.LoginPage;
import com.banking.pages.ManagerHomePage;
import com.banking.util.IAutoConstant;
import com.banking.util.JsonReader;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private ManagerHomePage managerHomePage;

    public LoginTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialize();
        loginPage = new LoginPage();
        managerHomePage = new ManagerHomePage();
    }

    @Test
    public void verifyTitleOfLoginPageTest() throws IOException {
        //captureScreen(driver, "verifyTitleOfLoginPageTest");
        String title = loginPage.verifyTitleOfLoginPage();
        Assert.assertEquals(title, IAutoConstant.LOGIN_PAGE_TITLE, "Title not matche");
        log.info("Title is matched");
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
    public void tearDown() {
        driver.quit();
    }
}
