package com.bankingproject.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bankingproject.pageobject.Loginpage;

public class Tc_logintest_001 extends Baseclass {

	@Test
	public void Logintest() throws IOException{
		Driver.get(baseurl);
		logger.info("url is open");
	
	Loginpage lp=new Loginpage(Driver);
	
	lp.setusername(username);
	
	logger.info("enter user name");
	lp.setpassword(password);

	logger.info("password");
	lp.Clicksubmit();
	

	logger.info("submitted");
	
	if (Driver.getTitle().equals("Guru99 Bank Manager HomePage")){
		Assert.assertTrue(true);
	}
	
	else{
		captureScreen(Driver,"Logintest");
		Assert.assertTrue(false);
		logger.info("login test failed");
	}
	}
}