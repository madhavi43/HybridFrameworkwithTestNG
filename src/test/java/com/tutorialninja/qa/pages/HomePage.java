package com.tutorialninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	WebDriver driver;
	@FindBy(css="span[class$='caret']")
	WebElement myAccountdropdown;
	@FindBy(css="a[href*='https://tutorialsninja.com/demo/index.php?route=account/login']")
	WebElement Loginbtn;
	
	@FindBy(linkText="Register")
	WebElement RegisterBtn;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement searchbox;
	
	@FindBy(xpath="(//button[@type='button'])[4]")
	WebElement searchBtn;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickonmyaccount()
	{
		myAccountdropdown.click();	
	}
	public LoginPage clickLogin()
	{
		Loginbtn.click();
		return new LoginPage(driver);
		
	}
	public void ClickRegister()
	{
		RegisterBtn.click();
	}
	
	public void enteronSearch(String productname)
	{
		searchbox.sendKeys(productname);
	}

	public void clickonSearch()
	{
		searchBtn.click();
	}
}
