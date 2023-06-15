package com.tutorialsninja.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialninja.Base.BaseClass;
import com.tutorialninja.qa.pages.AccountPage;
import com.tutorialninja.qa.pages.HomePage;
import com.tutorialninja.qa.pages.LoginPage;
import com.tutorialsninja.utils.Utilities;

public class LogintoTest extends BaseClass

{ 


	public LogintoTest()
	{
		super();
	}

	public WebDriver driver;
	LoginPage login_obj;
	@BeforeMethod
	public void setUp()
	{
		System.out.println(prop.getProperty("browser"));
		driver=initializeBrowserandOpenApplicationUrl(prop.getProperty("browser"));
		HomePage Home_obj=new HomePage(driver);
		Home_obj.clickonmyaccount();
		login_obj=Home_obj.clickLogin();
	}


	@Test(priority=3,dataProvider="supplyTestData")
	public void verifyLoginWithValidCredentials(String Email,String Password)
	{  


		login_obj.enterEmail(Email);
		login_obj.enterPassword(Password);
		login_obj.clickonLogin();
		AccountPage account_obj=new AccountPage(driver);
		Assert.assertTrue(account_obj.verifyEditUrInfo());
	}

	@Test(priority=2)
	public void verifyLoginWithInvalidCrendentials()
	{ 
		login_obj.enterEmail(Utilities.generateEmailTimeStamp());
		login_obj.enterPassword(prop.getProperty("validPassword"));
		login_obj.clickonLogin();
		// Assert.assertEquals(driver.findElement(By.cssSelector("div[class$='alert alert-danger alert-dismissible']")).isDisplayed(),true);
	}

	@Test(priority=1)
	public void verifyLoginWithoutProvidingCredentials()
	{ 

		login_obj.enterEmail("");
		login_obj.enterPassword(prop.getProperty("validPassword"));
		login_obj.clickonLogin();
	}

	@DataProvider
	public Object[][] supplyTestData()
	{
		Object[][] data= Utilities.getExcelSheetData("Login");;
		return data;
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}