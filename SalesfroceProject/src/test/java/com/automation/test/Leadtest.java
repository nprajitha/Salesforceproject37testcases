package com.automation.test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.salesforce.utility.Commonutilities;
import com.salesfroce.basetest.Basescripts;

public class Leadtest extends Basescripts{
	@Test
	public static void testcase20() throws IOException
	{
		 leadtab(); //reuseable method for lead tab
		 captureshot("testcase20");
		 report.logtestpass();
		 
	}
	@Test
	public static void testcase21() throws IOException
	{
		 leadtab();
		 WebElement leaddropdown =driver.findElement(By.xpath("//select[@id='fcf']"));
		clickonElement(leaddropdown,"click on leaddropdown");
		
		 Select s=new Select(leaddropdown);
		 List <WebElement> op = s.getOptions();
	      int size = op.size();
	      for(int i =0; i<size ; i++){
	         String options = op.get(i).getText();
	         System.out.println(options);
	      }
		 captureshot("testcase21");
		 report.logtestpass();
	}
	@Test
	public static void testcase22() throws IOException, InterruptedException
	{
		leadtab();
		 WebElement todayleads =driver.findElement(By.xpath("//select[@id='fcf']"));
			clickonElement(todayleads,"click on leaddropdown");
			selectbyvalue(todayleads,"00B8a00000AHYDk");
			dropdown();
			WebElement logout=driver.findElement(By.linkText("Logout"));
			clickonElement(logout,"loggedout");
			Thread.sleep(2000);
			String user=Commonutilities.getpropertyvalue("username");
			String password=Commonutilities.getpropertyvalue("password");
			login(user,password);
			//Thread.sleep(2000);
			//leadtab();
			By lead =By.xpath("//a[contains(text(),'Leads')]");
			waituntillvisibilityofelementlocated(lead, "go to lead");
			WebElement tablead =driver.findElement(lead);
			mouseOver(tablead,"mouse on lead");
			clickonElement(tablead,"click on lead tab");
			
			WebElement gobutton=driver.findElement(By.name("go"));
			mouseOver(gobutton," go button");
			clickonElement(gobutton," go button");
			
			captureshot("testcase22");
			 report.logtestpass();
			
	}
	@Test
	public static void testcase23() throws IOException
	{
		leadtab();
		 WebElement todayleads =driver.findElement(By.xpath("//select[@id='fcf']"));
			clickonElement(todayleads," leaddropdown");
			selectbyvalue(todayleads,"00B8a00000AHYDk"); 
			clickonElement(todayleads," leaddropdown");
			
			captureshot("testcase23");
			 report.logtestpass();
	}
	@Test
	public static void testcase24()
	{
		leadtab();
		WebElement newbutton=driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
		mouseOver(newbutton," new button");
		clickonElement(newbutton," new button");
		
		WebElement lname =driver.findElement(By.id("name_lastlea2"));
		clickonElement(lname,"lname");
		textvalues(lname,"ABCD","text in lname");
		WebElement compname =driver.findElement(By.id("lea3"));
		clickonElement(compname," compname");
		textvalues(compname,"ABCD","text in compname");
		WebElement sbutton=driver.findElement(By.name("save"));
		mouseOver(sbutton," save button");
		clickonElement(sbutton," savebutton");
		 String leadtitle=driver.getTitle();
		 System.out.println(leadtitle);
		 report.logtestpass();
	}
	

}
