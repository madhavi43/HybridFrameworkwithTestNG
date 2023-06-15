package com.tutorialsninja.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports generateExtentReport() {
		
		ExtentReports report=new ExtentReports();
		File reportFilesrc=new File(System.getProperty("user.dir")+"\\test-output\\ExtentReporst\\extentreport.html");
		ExtentSparkReporter sparkreport1=new ExtentSparkReporter(reportFilesrc);
		sparkreport1.config().setTheme(Theme.DARK);
		sparkreport1.config().setReportName("TutorialNinja Automation results");
		sparkreport1.config().setDocumentTitle("TutorialNinja Automation results");
		sparkreport1.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		report.attachReporter(sparkreport1);
		Properties Extent_prop=new Properties();
		File Extent_src=new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\tutuorial\\qa\\config\\config.properties");
		 
		try {
			FileInputStream Extent_fis = new FileInputStream(Extent_src);
			Extent_prop.load(Extent_fis);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		report.setSystemInfo("Application URL",Extent_prop.getProperty("url") );
		report.setSystemInfo("BroswerName",Extent_prop.getProperty("browser") );
		report.setSystemInfo("Operating System", System.getProperty("os.name"));
		report.setSystemInfo("Java Version", System.getProperty("java.version"));
		report.setSystemInfo("Username", System.getProperty("user.name"));
		return report;
		

	}

}
