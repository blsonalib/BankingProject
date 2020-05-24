package com.banking.pages;

import com.banking.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
    @FindBy(name = "uid")
    private WebElement userID;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(name = "btnLogin")
    private WebElement loginButton;
    @FindBy(name = "btnReset")
    private WebElement resetButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public ManagerHomePage login(String un, String pw) {
        userID.sendKeys(un);
        password.sendKeys(pw);
        loginButton.click();
        return new ManagerHomePage();
    }
}
