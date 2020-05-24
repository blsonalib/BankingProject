package com.banking.pages;

import com.banking.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerHomePage extends BaseClass {
    @FindBy(xpath = "//a[contains(text(),'New Customer')]")
    private WebElement newCustomerLink;
    @FindBy(xpath = "//a[contains(text(),'Edit Customer')]")
    private WebElement editCustomerLink;
    @FindBy(linkText = "New Account")
    private WebElement newAccount;
    @FindBy(xpath = "//div[contains(text(),'Log out')]")
    private WebElement logOut;

    public ManagerHomePage() {
        PageFactory.initElements(driver, this);
    }
    public NewCustomerPage getClickOnNewCustomerLink() {
        newCustomerLink.click();
        return new NewCustomerPage();
    }

    public EditCustomerPage getClickOnEditCustomerLink() {
        editCustomerLink.click();
        return new EditCustomerPage();
    }
}
