package com.tutorialninja.Base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {

	public  WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	
	public BaseClass()  
	{
		prop=new Properties();
		File FileSrc=new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\tutuorial\\qa\\config\\config.properties");
		dataProp=new Properties();
		File dataSrc1=new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\tutorial\\qa\\testData\\testData.properties");
	
		
		try {
			FileInputStream dataFis = new FileInputStream(dataSrc1);
			dataProp.load(dataFis);
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		try {
			FileInputStream file = new FileInputStream(FileSrc);
			 prop.load(file);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	}
	
	
	
	public WebDriver initializeBrowserandOpenApplicationUrl(String browsername)
	{       
		
		
				if(browsername.equals("chrome")) {
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();}
				else {
					driver=new FirefoxDriver();
					}
				  //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT));
				  //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
				  driver.get(prop.getProperty("url"));
				  return driver;
				
				}
	 
	
	
}
