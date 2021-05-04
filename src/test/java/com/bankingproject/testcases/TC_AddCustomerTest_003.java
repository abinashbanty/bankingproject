package com.bankingproject.testcases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.bankingproject.pageobject.AddCustomerPage;
import com.bankingproject.pageobject.Loginpage;

import junit.framework.Assert;

public class TC_AddCustomerTest_003 extends Baseclass
{
	
@Test
public void addNewcustomer() throws InterruptedException, IOException
{
Loginpage Ip=new Loginpage(Driver);

Ip.setusername(username); 

Ip.setpassword(password);

Ip.Clicksubmit();

Thread.sleep(3000);

AddCustomerPage addcust=new AddCustomerPage(Driver);

addcust.clickAddNewCustomer();

addcust.custName ("Pavan");

addcust.custgender("male");

addcust.custdob("10","15","1985");

Thread.sleep(3000);

addcust.custaddress("INDIA"); addcust.custcity("HYD");

addcust.custstate("A");

addcust.custpinno("5000074"); addcust.custtelephoneno ("987890091");

String email=randomestring()+"@gmail.com";

addcust.custemailid (email);

addcust.custpassword("abcdef"); addcust.custsubmit();

Thread.sleep(3000);

boolean res=Driver.getPageSource().contains(("Customer Registered Successfully!!!"));

if(res==true) {
	Assert.assertTrue(true);
}
else
{
	captureScreen(Driver,"addNewCustomer");
	Assert.assertTrue(false);
}

}

public String randomestring()//generate random strings here we use this method to get diffarend random gmail id
{


String generatedstring=RandomStringUtils.randomAlphabetic (8); 

return(generatedstring);

}}
