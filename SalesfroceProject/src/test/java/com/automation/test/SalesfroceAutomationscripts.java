package com.automation.test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.utility.Commonutilities;
import com.salesfroce.basetest.Basescripts;

public class SalesfroceAutomationscripts extends Basescripts {
	
	
	@Test(enabled=false)
	public static void testcase1()
	{
		launchdriver();
		navigate("https://login.salesforce.com");
		//login("nanduri@student.com"," ");
		WebElement user1 = driver.findElement(By.xpath("//input[@id='username']"));
		waituntillvisible(user1,"user name");
		user1.sendKeys("nanduri@student.com");
		driver.findElement(By.xpath("//input[@id='password']")).clear();
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		String s=driver.findElement(By.xpath("//*[@id=\"error\"]")).getText();
		System.out.println(s);
		String s1="Please enter your password.";
		Assert.assertEquals(s, s1);
	}
	@Test(enabled=false)
	public static void testcase2() throws IOException
	{
		launchdriver("firefox");
		
		String url =Commonutilities.getpropertyvalue("url");
		String user=Commonutilities.getpropertyvalue("username");
		String password=Commonutilities.getpropertyvalue("password");
		navigate(url);
		login(user,password);
	}
	@Test(enabled=false)
	public static void testcase3()
	{
		launchdriver();
		navigate("https://login.salesforce.com");
		WebElement user = driver.findElement(By.xpath( "//input[@id='username']"));
		 waituntillvisible(user,"username");
		textvalues(user,"nanduri@student.com","username");
		WebElement pswd =driver.findElement(By.xpath("//input[@id='password']"));
		textvalues(pswd,"Temp@123","password is entered");
		WebElement remembercheck=driver.findElement(By.xpath("//input[@id='rememberUn']"));
		clickonElement(remembercheck,"checked remender me box");
		WebElement loginbutton= driver.findElement(By.xpath("//input[@id='Login']"));
		clickonElement(loginbutton,"login");
		By swithTo = By.xpath("//div[@id='userNavButton']");
		waituntillvisibilityofelementlocated(swithTo, "switch to tab");
		WebElement switchmenu = driver.findElement(swithTo);
		mouseOver(switchmenu,"switch usermenu");
		clickonElement(switchmenu,"usermenu");
		WebElement logout=driver.findElement(By.linkText("Logout"));
		clickonElement(logout,"loggedout");
		String smsg= driver.findElement(By.xpath("//span[@id='idcard-identity']")).getText();
		String actualmsg="nanduri@student.com";
		
		
	}
	@Test(enabled=false)
	public static void testcase4()
	{
		launchdriver();
		navigate("https://login.salesforce.com");
		WebElement forgotpswd =driver.findElement(By.id("forgot_password_link"));
		clickonElement(forgotpswd,"forgotpassword");
		WebElement  forgotuser= driver.findElement(By.xpath("//input[@id='un']"));
		textvalues(forgotuser,"nanduri@student.com","username");
		WebElement buttonclick=driver.findElement(By.id("continue"));
		clickonElement(buttonclick,"click  on continue");
		System.out.println(driver.getCurrentUrl() );
		//System.out.println(driver.getTitle());
		String exceptedtile="Check Your Email | Salesforce";
		String actualtitle = driver.getTitle();
		if(actualtitle.equals(exceptedtile))
		{
			System.out.println("test pass");
		}
		else{
			
			System.out.println("test fail");
		      }
		
		
		
	}
	//@Test(enabled=false)
	public static void testcase4A()
	{
		launchdriver();
		navigate("https://login.salesforce.com");
		login("123","22131");
		System.out.println(driver.getTitle());
	 String errmsg= driver.findElement(By.xpath("//*[@id=\"error\"]")).getText();
	 System.out.println(errmsg);
		
	}
	
	
	public static void main(String[] args) throws IOException 
{
//		//testcase1();
//		//testcase2();
//		//testcase3();
//		//testcase4();
		testcase4A();
//	
//
	}

}
