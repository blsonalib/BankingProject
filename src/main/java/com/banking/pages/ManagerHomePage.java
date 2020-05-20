package com.banking.pages;

import com.banking.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerHomePage extends BaseTest {
    @FindBy(xpath = "//a[contains(text(),'New Customer')]")
    private WebElement newCustomerLink;
    @FindBy(xpath = "//a[contains(text(),'Edit Customer')]")
    private WebElement editCustomerLink;
    @FindBy(linkText = "New Account")
    private WebElement newAccount;
    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    private WebElement logOutt;
    public ManagerHomePage(){
        PageFactory.initElements(driver,this);
    }
    public String verifyTitle(){
        return driver.getTitle();
    }
    public NewCustomerPage clickOnNewCustomerLink(){
        newCustomerLink.click();
        return new NewCustomerPage();
    }
    public EditCustomer clickOnEditCustomerLink(){
        editCustomerLink.click();
        return new EditCustomer();
    }
    public NewAccount clickOnNewAccountLink(){
        newAccount.click();
        return new NewAccount();
    }
    public LogOutPage clickOnLogOutPage(){
        logOutt.click();
        return new LogOutPage();
    }
}
