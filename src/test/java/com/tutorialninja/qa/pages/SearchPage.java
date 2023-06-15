package com.tutorialninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	@FindBy(xpath="//a[contains(text(),'HP LP3065')]")
	WebElement validProduct;
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String getSearchText()
	{
		String Producttext=validProduct.getText();
		return Producttext;
	}

}
