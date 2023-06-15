package com.tutorialninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	@FindBy(css="input[id$='input-email']")
	WebElement emailTxtBox;
	
	@FindBy(css="input[id$='input-password']")
	WebElement passWordTxtBox;
	@FindBy(css="input[value$='Login']")
	WebElement LoginBtn;
	
	@FindBy(css="div[class$='alert alert-danger alert-dismissible']")
	WebElement Emailaddressnotmatch;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
   
	public void enterEmail(String emailText)
	{
		emailTxtBox.sendKeys(emailText);
	}
	public void enterPassword(String passwrd)
	{
		passWordTxtBox.sendKeys(passwrd);
	}
	public void clickonLogin()
	{
		LoginBtn.click();
	}
   public String returnEmailpasswordnotmatchwarning()
   {
	   String WarningText=Emailaddressnotmatch.getText();
	   return WarningText;
   }
}
