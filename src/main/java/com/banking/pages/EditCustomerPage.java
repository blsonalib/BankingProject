package com.banking.pages;

import com.banking.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage extends BaseClass {
   @FindBy(name = "cusid")
    private WebElement accountNo;
   @FindBy(id = "AccSubmit")
    private WebElement submitButton;
    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement clickOnHome;
   public EditCustomerPage(){
       PageFactory.initElements(driver,this);
   }
   public void setAccountNo(String accountNumber){
       accountNo.sendKeys(accountNumber);
   }
   public void getClickOnSubmitbutton(){
       submitButton.click();
   }
    public ManagerHomePage clickOnHomeLink(){
        clickOnHome.click();
        return new ManagerHomePage();
    }
}
