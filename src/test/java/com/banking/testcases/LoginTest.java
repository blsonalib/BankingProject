package com.banking.testcases;
import com.banking.base.BaseTest;
import com.banking.pages.LoginPage;
import com.banking.pages.ManagerHomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    public void verifyTitleOfLoginPageTest(){
      String title = loginPage.verifyTitleOfLoginPage();
        Assert.assertEquals(title,"GTPL Bank Home Page","Title not matched");
    }
    @Test
    public void loginTest(){
        managerHomePage = loginPage.login(properties.getProperty("userID"),properties.getProperty("password"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
