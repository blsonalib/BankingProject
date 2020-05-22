package com.banking.pages;

import com.banking.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage extends BaseTest {
    @FindBy(name = "name")
    private WebElement customerName;
    @FindBy(name = "rad1")
    private WebElement gender;
    @FindBy(name = "dob")
    private WebElement dateOfBirth;
    @FindBy(name = "addr")
    private WebElement address;
    @FindBy(name = "city")
    private WebElement city;
    @FindBy(name = "state")
    private WebElement state;
    @FindBy(name = "pinno")
    private WebElement pinCode;
    @FindBy(name = "telephoneno")
    private WebElement telephoneNumber;
    @FindBy(name = "emailid")
    private WebElement emailId;
    @FindBy(name = "sub")
    private WebElement submit;
    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement clickOnHome;
    public NewCustomerPage(){
        PageFactory.initElements(driver,this);
    }
    public String verifyTitle(){
       return driver.getTitle();
    }
    public void setCustomerName(String cName){
        customerName.sendKeys(cName);
    }
    public void setGender(){
        gender.isSelected();
    }
    public void setDateOfBirth(String dob){
        dateOfBirth.sendKeys(dob);
    }
    public void setAddress(String add){
        address.sendKeys(add);
    }
    public void setCity(String cityName){
        city.sendKeys(cityName);
    }
    public void setState(String stateName){
        state.sendKeys(stateName);
    }
    public void setPinCode(String pCode){
        pinCode.sendKeys(pCode);
    }
    public void setEmailId(String emailId1){
        emailId.sendKeys(emailId1);
    }
    public void setTelephoneNumber(String phoneNumber){
        telephoneNumber.sendKeys(phoneNumber);
    }
    public void setSubmitButton(){
        submit.click();
    }
    public ManagerHomePage clickOnHomeLink(){
        clickOnHome.click();
        return new ManagerHomePage();
    }
}
