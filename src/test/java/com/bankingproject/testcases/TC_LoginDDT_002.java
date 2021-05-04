package com.bankingproject.testcases;



import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.bankingproject.pageobject.Loginpage;
import com.bankingproject.utilities.Xlutils;

public class TC_LoginDDT_002 extends Baseclass {

@Test(dataProvider="LoginData")

public void loginDDT(String user, String pwd) 
	{
Loginpage Ip=new Loginpage(Driver);
Ip.setusername(user); 
logger.info("user name provided");
Ip.setpassword(pwd); 
Ip.Clicksubmit();

if(isAlertPresent()==true)
{

Driver.switchTo().alert().accept();//close alert

Driver.switchTo().defaultContent();

Assert.assertTrue(false);
	}
else
{
Assert.assertTrue(true);
Ip.ClickLogout();
Driver.switchTo().alert().accept();
Driver.switchTo().defaultContent();

}
}

public boolean isAlertPresent()
{                                //user defined method created to check alert is presetn or not

try {

Driver.switchTo().alert();

return true; 
}

catch(NoAlertPresentException e) {

return false;
}
}
@DataProvider(name="LoginData")
 String [][] getData() throws IOException
 {
String path=System.getProperty("user.dir")+"/src/test/java/com/bankingproject\\testdata\\LoginData.xlsx";

int rownum=Xlutils.getRowCount(path,"Sheet1");
int colcount=Xlutils.getCellCount(path,"Sheet1",1);
String logindata[][]=new String[rownum][colcount];
for (int i=1;i<=rownum;i++)
{
for(int j=0;j<colcount;j++)
{
logindata[i-1][j]=Xlutils.getCellData(path, "Sheet1",i,j);//1 0
}
}
return logindata;
}
}
