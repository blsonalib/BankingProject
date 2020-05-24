package com.banking.pages;

import com.banking.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateMangerCredentialPage extends BaseClass {
    @FindBy(name = "emailid")
    private WebElement emailID;
    @FindBy(name = "btnLogin")
    private WebElement submitButton;
    @FindBy(className = "barone")
    private WebElement logo;
    @FindBy(xpath = "//a[contains(text(),'Bank Project')]")
    private WebElement bankingProjectLink;
    public CreateMangerCredentialPage(){
        PageFactory.initElements(driver,this);
    }
    public void setEmailID(String emailId){
        emailID.sendKeys(emailId);
    }
    public void clickOnSubmitButton(){
        submitButton.click();
    }
    public boolean verifyLogo(){
       return logo.isDisplayed();
    }
    public LoginPage getCilckOnBankinProjectLink(){
        bankingProjectLink.click();
        return new LoginPage();
    }
}
