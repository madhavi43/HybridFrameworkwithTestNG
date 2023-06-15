package com.tutorialsninja.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {
	
	public static final int IMPLICIT_WAIT=10;
	public static final int PAGE_LOAD_TIME=10;

	public static String generateEmailTimeStamp()
	{
	Date date=new Date(0);
	String Email=date.toString().replace(" ", "_").replace(":", "_");
	return "madhavi"+Email+"@gmail.com";
	
	}
	public static Object[][] getExcelSheetData(String sheetname)
	{
		File Exceldatasrc=new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\tutorial\\qa\\testData\\TutorialninjatestData.xlsx");
		
		XSSFWorkbook workbook=null;
		try {
			FileInputStream Exceldata=new FileInputStream(Exceldatasrc);
			workbook = new XSSFWorkbook(Exceldata);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet=workbook.getSheet(sheetname);
		int rows=sheet.getLastRowNum();
		int cols=sheet.getRow(0).getLastCellNum();
		Object[][] data1=new Object[rows][cols];
		for(int i=0;i<rows;i++)
		{
			XSSFRow row=sheet.getRow(i+1);
			for(int j=0;j<cols;j++)
			{
				XSSFCell cell=row.getCell(j);
				CellType celltype=cell.getCellType();
				switch(celltype)
				{
				case STRING:
					data1[i][j]=cell.getStringCellValue();
					break;
				case NUMERIC:
					data1[i][j]=Integer.toString((int)cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data1[i][j]=cell.getBooleanCellValue();
					break;
			}
		}
	}
		return data1;
	}
	
	public static String CaptureScreenshot(WebDriver driver,String testName)
	{
		File capturescreen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationSrennshotpath=System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
		try {
			FileHandler.copy(capturescreen,new File(destinationSrennshotpath));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return destinationSrennshotpath;
	}
	
}
