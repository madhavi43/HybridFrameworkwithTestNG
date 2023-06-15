package com.tutorialninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	@FindBy(id="input-firstname")
	WebElement FirstName;
    
	@FindBy(id="input-lastname")
	WebElement LastName;
	@FindBy(id="input-email")
	WebElement EmailField;
	
	@FindBy(id="input-telephone")
	WebElement TelephoneField;
	
	@FindBy(id="input-password")
	WebElement PasswordField;
	@FindBy(id="input-confirm")
	WebElement ConfirmPasswordField;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement Agree;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement PrimaryBtn;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement getEmailWarningMsg;
	
	@FindBy(xpath="(//div[@class='text-danger'])[1]")
	WebElement FistNameWarning;
	@FindBy(xpath="//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
	WebElement LastNameWarning;
	@FindBy(xpath="//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	WebElement EmailNameWarning;
	@FindBy(xpath="//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
	WebElement TelephoneNameWarning;
	@FindBy(xpath="(//div[contains(text(),'Password must be between 4 and 20 characters!')])[1]")
	WebElement PasswordNameWarning;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	public void enterfirstname(String firstname)
	{
		FirstName.sendKeys(firstname);
	}
	
	public void enterlastname(String lastname)
	{
		LastName.sendKeys(lastname);
	}
	public void enterEmail(String Email)
	{
		EmailField.sendKeys(Email);
	}
	public void enterTelephone(String telephonenum)
	{
		TelephoneField.sendKeys(telephonenum);	
	}
	public void enterpassword(String passwrd)
	{
		PasswordField.sendKeys(passwrd);
	}
	public void enterconfirmPassword(String confirmpassword)
	{
		ConfirmPasswordField.sendKeys(confirmpassword);	
	}
	public void clickAgree()
	{
		Agree.click();
	}
	public void ClickContinue()
	{
		PrimaryBtn.click();	
	}
	
	public String getEmailWarningMsg()
	{
		String WarningMsg1=getEmailWarningMsg.getText();
		return WarningMsg1;
	}
	public String getFisrtNameWarn()
	{
		String FisrtNameWarnMsg=FistNameWarning.getText();
		return FisrtNameWarnMsg;
	}
	public String getLastNameWarn()
	{
		String LastNameWarnMsg=LastNameWarning.getText();
		return LastNameWarnMsg;
	}
	public String getEmailNameWarn()
	{
		String EmailWarnMsg=EmailNameWarning.getText();
		return EmailWarnMsg;
	}
	public String getpasswordWarn()
	{
		String PasswordWarnMsg=PasswordNameWarning.getText();
		return PasswordWarnMsg;
	}
	public String getTelephoneNameWarn()
	{
		String TelephoneWarnMsg=TelephoneNameWarning.getText();
		return TelephoneWarnMsg;
	}

	
}

