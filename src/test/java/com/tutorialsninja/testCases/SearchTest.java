package com.tutorialsninja.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.Base.BaseClass;
import com.tutorialninja.qa.pages.HomePage;
import com.tutorialninja.qa.pages.SearchPage;

public class SearchTest extends BaseClass{
	
	public WebDriver driver;
	public SearchTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{     driver=initializeBrowserandOpenApplicationUrl(prop.getProperty("browser"));
		  
	}
	
	@Test
	public void verifySearchWithValidProduct()
	{
		HomePage Home_obj=new HomePage(driver);
		Home_obj.enteronSearch(dataProp.getProperty("validProduct"));
		Home_obj.clickonSearch();
		SearchPage Search_obj=new SearchPage(driver);
		Assert.assertEquals(Search_obj.getSearchText(), "HP LP3065");
	}
    
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
