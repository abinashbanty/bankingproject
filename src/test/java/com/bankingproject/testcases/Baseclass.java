package com.bankingproject.testcases;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.bankingproject.utilities.Readconfig;
 

public class Baseclass {
	
	Readconfig rd=new Readconfig(); 
	
	public String baseurl=rd.getapplicationurl();
	public String username=rd.getusername();
	public String password=rd.getpassword();
	public static WebDriver Driver;
	
	public static Logger logger;
	@BeforeClass
	
	public void Setup(){
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+rd.getchromepath());
		Driver=new ChromeDriver();
		logger=logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		
		Driver.get(baseurl);
		
	}
	
	@AfterClass
	
	public void Teardown(){
	Driver.quit();
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException {

		TakesScreenshot ts= (TakesScreenshot) driver;

		File source =ts.getScreenshotAs (OutputType.FILE); 
		File target =new File(System.getProperty("user.dir")+"/Screenshots/" + tname + ".png");

		FileUtils.copyFile(source, target); System.out.println("Screenshot taken");
	}
}


