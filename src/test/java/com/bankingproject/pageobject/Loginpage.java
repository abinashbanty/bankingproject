package com.bankingproject.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	WebDriver lDriver;
    public Loginpage(WebDriver rDriver)
	{
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
    
    @FindBy(name="uid")
    
    @CacheLookup
    WebElement txtusername;
    
@FindBy(name="password")
    
    @CacheLookup
    WebElement txtpassword;

@FindBy(name="btnLogin")

@CacheLookup
WebElement txtloginbtn;

@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")       

@CacheLookup
WebElement lnkLogout;

public void setusername(String uname)
{
	 
	 txtusername.sendKeys(uname); 
	 
	 
}
public void setpassword(String pwd)
{
	 
	 txtpassword.sendKeys(pwd); 
	 
	 
}
public void Clicksubmit()
{
	 
	 txtloginbtn.click();
}
public void ClickLogout()
{
	 
	lnkLogout.click();
}
}