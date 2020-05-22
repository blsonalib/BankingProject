package com.banking.testcases;
import com.banking.base.BaseTest;
import com.banking.pages.LoginPage;
import com.banking.pages.ManagerHomePage;
import com.banking.util.IAutoConstant;
import com.banking.util.JsonReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    ManagerHomePage managerHomePage;

    public LoginTest(){
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialize();
        loginPage = new LoginPage();
        managerHomePage = new ManagerHomePage();
    }
    @Test
    public void verifyTitleOfLoginPageTest() throws IOException {
      String title = loginPage.verifyTitleOfLoginPage();
        Assert.assertEquals(title,"00GTPL Bank Home Page","Title not matched");
        log.info("Title is matched");

    }
    @Test(dataProvider = "Login")
    public void login(String userName,String password){
        managerHomePage = loginPage.login(userName,password);
    }
    @DataProvider(name = "Login")
    public Object[][] passData() throws FileNotFoundException {
        return JsonReader.getdata(IAutoConstant.JSON_LOGIN_PATH,"Login",2,2);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
