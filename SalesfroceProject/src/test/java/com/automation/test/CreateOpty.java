package com.automation.test;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.CaptureScreenshot;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.salesforce.utility.Constants;
import com.salesfroce.basetest.Basescripts;

public class CreateOpty extends Basescripts {
	@Test
	public static void testcase15() throws IOException
	{
		createoppt(); //-->reuseable method for create oppty tab
		WebElement opptdropdown =driver.findElement(By.xpath("//select[@id='fcf']"));
		mouseOver(opptdropdown,"mouse on opptdropdown");
		clickonElement(opptdropdown,"click on opptdropdown");
		System.out.println(driver.getTitle());
		 
		 Select s=new Select(opptdropdown);
		 List <WebElement> op = s.getOptions(); //--->used list to displayed dropdown
	      int size = op.size();
	      for(int i =0; i<size ; i++){
	         String options = op.get(i).getText();
	         System.out.println(options);
	      }
		captureshot("testcase15");
		report.logtestpass();
		
		//closeDriver();
	}
	@Test
	public static void testcase16() throws IOException
	{
		createoppt();
		WebElement opptnew =driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
		mouseOver(opptnew,"mouse on opptnew");
		clickonElement(opptnew,"click on opptnew"); 
		
		 // Using Javascriptexector  to insert values
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript("document.getElementById('opp3').value='testoppt1';");
		  js.executeScript("document.getElementById('opp4').value='test';");
		  
		  WebElement probability=driver.findElement(By.xpath("//input[@id='opp12']"));
		  js.executeScript("arguments[0].value='20';", probability); 
		 
		  WebElement stage= driver.findElement(By.cssSelector("#opp11"));
		 js.executeScript("arguments[0].click()", stage);
		 selectbyvalue(stage,"Qualification");
		 
		  WebElement leadsrc= driver.findElement(By.xpath("//select[@id='opp6']"));
		  js.executeScript("arguments[0].click()", leadsrc);
		  selectbyvalue( leadsrc,"Web"); 
		  
		  WebElement primarycamp= driver.findElement(By.xpath("//input[@id='opp17']"));
		  clickonElement( primarycamp,"click on  primarycamp"); 
		  textvalues( primarycamp," ", "text entred");
		  WebElement closedate= driver.findElement(By.xpath("//input[@id='opp9']"));
		  clickonElement(closedate,"click on closedate"); 
		  By td=By.xpath("//a[contains(text(),'Today')]");
	      waituntillvisibilityofelementlocated(td,"goto locator");
		  WebElement todaydate= driver.findElement(td);
		  mouseOver(todaydate,"mouse on todaydate");
		  clickonElement(todaydate,"click on todaydate");  
		  WebElement saveoppt= driver.findElement(By.name("save"));
		  mouseOver( saveoppt,"mouse on  saveoppt");
		  clickonElement( saveoppt,"click on   saveoppt"); 
		  captureshot("testcase16");
		  report.logtestpass();
	}
	@Test
	public static void testcases17() throws IOException
	{
		createoppt();
		WebElement opptpipelinelink =driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]"));
		mouseOver(opptpipelinelink," opptpipelinelink");
		clickonElement(opptpipelinelink," opptpipelinelink");
		String oppttext=driver.getTitle();
		System.out.println(oppttext);
		captureshot("testcase17");
		report.logtestpass();
	}
	@Test
	public static void testcase18() throws IOException
	{
		createoppt();
		WebElement opptstucklink =driver.findElement(By.xpath("//a[contains(text(),'Stuck Opportunities')]"));
		mouseOver( opptstucklink ,"mouse on  opptstucklink ");
		clickonElement( opptstucklink ,"click on  opptstucklink ");
		captureshot("testcase18");
		report.logtestpass();
	}
	@Test
	public static void testcase19() throws IOException
	{
		
		createoppt();
		WebElement quatrsummary =driver.findElement(By.xpath("//select[@id='quarter_q']"));
		//mouseOver(quatrsummary,"mouse on  quatrsummary");
		clickonElement(quatrsummary ,"click onquatrsummary ");
		 selectbyvalue( quatrsummary ,"curnext1"); 
		 WebElement quatrsummaryinclude =driver.findElement(By.xpath("//select[@id='open']"));
		clickonElement(quatrsummaryinclude ,"click onquatrsummaryinclude ");
	    selectbyvalue( quatrsummaryinclude ,"open"); 
		WebElement runreport =driver.findElement(By.xpath("//tbody/tr[3]/td[1]/input[1]"));
		clickonElement(runreport ,"click on runreport ");
		captureshot("testcase19");
		report.logtestpass();
				
	}
    
}
