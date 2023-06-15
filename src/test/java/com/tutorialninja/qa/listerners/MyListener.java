package com.tutorialninja.qa.listerners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.utils.ExtentReporter;
import com.tutorialsninja.utils.Utilities;

public class MyListener implements ITestListener {

	ExtentReports extentreport;
	ExtentTest extentest;
	String testName;
	public void onStart(ITestContext context) 
	{
		extentreport = ExtentReporter.generateExtentReport();
		

	}

	public void onTestStart(ITestResult result) {
		
		extentest=extentreport.createTest(result.getName());
		extentest.log(Status.INFO, result.getName()+" started executing");
		
	}

	public void onTestSuccess(ITestResult result) {
		
		extentest.log(Status.PASS, result.getName()+" got executed successfully");
		
	}

	public void onTestFailure(ITestResult result) {
		
		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String destinationSrennshotpath = Utilities.CaptureScreenshot(driver, result.getName());
		extentest.addScreenCaptureFromPath(destinationSrennshotpath);
		extentest.log(Status.INFO, result.getThrowable());
		extentest.log(Status.FAIL, result.getName()+" got Failed");
		
	}

	
	public void onTestSkipped(ITestResult result) {
		
		extentest.log(Status.INFO, result.getThrowable());
		extentest.log(Status.SKIP, result.getName()+" got Skipped");
		
	}

	
	public void onFinish(ITestContext context) {
		
		extentest.log(Status.INFO, "Execution Completed");
		extentreport.flush();//this will add all the above details to report.
		String Path=System.getProperty("user.dir")+"\\test-output\\ExtentReporst\\extentreport.html";
		File extentreport=new File(Path);
		try {
			Desktop.getDesktop().browse(extentreport.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
