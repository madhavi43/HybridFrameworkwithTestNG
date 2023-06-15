package com.tutorialsninja.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.Base.BaseClass;
import com.tutorialninja.qa.pages.HomePage;
import com.tutorialninja.qa.pages.RegisterPage;
import com.tutorialsninja.utils.Utilities;

public class RegistertoTest extends BaseClass{

	public WebDriver driver;
	public RegistertoTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp()
	{     

		driver=initializeBrowserandOpenApplicationUrl(prop.getProperty("browser"));
		HomePage home_obj=new HomePage(driver);
		home_obj.clickonmyaccount();
		home_obj.ClickRegister();
	}


	@Test
	public void verifyRegisteringWithMandatoryFields()
	{
		RegisterPage Register_obj=new RegisterPage(driver);
		Register_obj.enterfirstname(dataProp.getProperty("firstName"));
		Register_obj.enterlastname(dataProp.getProperty("lastName"));
		Register_obj.enterEmail(Utilities.generateEmailTimeStamp());
		Register_obj.enterTelephone(dataProp.getProperty("telephoneNumber"));
		Register_obj.enterpassword(prop.getProperty("validPassword"));
		Register_obj.enterconfirmPassword("123456788");
		Register_obj.clickAgree();
		Register_obj.ClickContinue();

	}

	@Test
	public void verifyRegisteringWithAllFields() {
		RegisterPage Register_obj = new RegisterPage(driver);
		Register_obj.enterfirstname(dataProp.getProperty("firstName"));
		Register_obj.enterlastname(dataProp.getProperty("lastName"));
		Register_obj.enterEmail(Utilities.generateEmailTimeStamp());
		Register_obj.enterTelephone("9963989812");
		Register_obj.enterpassword(prop.getProperty("validPassword"));
		Register_obj.enterconfirmPassword("123456788");
		// driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		Register_obj.clickAgree();
		Register_obj.ClickContinue();
	}
	@Test
	public void verifyRegisteringAccountWithExistingAccount()
	{
		RegisterPage Register_obj = new RegisterPage(driver);
		Register_obj.enterfirstname(dataProp.getProperty("firstName"));
		Register_obj.enterlastname(dataProp.getProperty("lastName"));
		Register_obj.enterEmail("madhavi43it@gmail.com");
		Register_obj.enterTelephone("9963989813");
		Register_obj.enterpassword(prop.getProperty("validPassword"));
		Register_obj.enterconfirmPassword("123456789");

		Register_obj.clickAgree();
		Register_obj.ClickContinue();
		String WarningMsg=Register_obj.getEmailWarningMsg();
		Assert.assertEquals(WarningMsg, dataProp.getProperty("EmailAddresswarningMsg"));
	}

	@Test
	public void verifyRegisteringWithoutFillinganyDetails()
	{
		RegisterPage Register_obj = new RegisterPage(driver);
		Register_obj.ClickContinue();
		String actualFirstNameWarning=Register_obj.getFisrtNameWarn();
		Assert.assertTrue(actualFirstNameWarning.contains(dataProp.getProperty("firstNamewarning")));
		String actualLastNameWarning=Register_obj.getLastNameWarn();
		Assert.assertTrue(actualLastNameWarning.contains(dataProp.getProperty("lastNameWarning")));
		String actualEmailNameWarning=Register_obj.getEmailNameWarn();
		Assert.assertTrue(actualEmailNameWarning.contains(dataProp.getProperty("emailWarning")));
		String actualTelephoneWarning=Register_obj.getTelephoneNameWarn();
		Assert.assertTrue(actualTelephoneWarning.contains(dataProp.getProperty("telephoneWarning")));
		String actualPasswordWarning=Register_obj.getpasswordWarn();
		Assert.assertTrue(actualPasswordWarning.contains(dataProp.getProperty("passwordWarning")));
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
