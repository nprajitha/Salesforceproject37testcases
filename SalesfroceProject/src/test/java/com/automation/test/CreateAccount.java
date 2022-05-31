package com.automation.test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.salesforce.utility.Commonutilities;
import com.salesfroce.basetest.Basescripts;

public class CreateAccount  extends Basescripts{
	@Test
	
	public static void testcase10() throws IOException
	{
       
		 accounttab();
	WebElement newbutton =driver.findElement(By.name("new"));
	mouseOver(newbutton,"mouse on new button");
	clickonElement(newbutton,"click on new button");
	WebElement acctname =driver.findElement(By.id("acc2"));
	clickonElement(acctname,"click on Account name box");
	textvalues(acctname,"test","new accoount name");
	WebElement acctsave =driver.findElement(By.name("save"));
	clickonElement(acctsave,"click on save button");
	captureshot("testcase10");
	//driver.close();
	report.logtestpass();
     }
	@Test
	public static  void  testcase11() throws IOException
	{
		 
		accounttab();	
			WebElement createview =driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
			clickonElement(createview,"click createview");
			WebElement viewname =driver.findElement(By.id("fname"));
			clickonElement(viewname,"click on viewname box");
			textvalues(viewname,"tester check","enter viewname in view box");
			WebElement viewunqname=driver.findElement(By.id("devname"));	
		clickonElement(viewunqname,"click on viewuniquename box");
		WebElement viewsave =driver.findElement(By.name("save"));
		clickonElement (viewsave,"click on save");
		//driver.close();
		report.logtestpass();	
			
			
	}
	@Test
	public static void testcase12()
	{
		accounttab();
		//select view from dropdown
		WebElement viewlist =driver.findElement(By.id("fcf"));
		clickonElement(viewlist,"click view list");
		selectbyvalue(viewlist,"00B8a00000ArkNw");
		WebElement editbutton =driver.findElement(By.linkText("Edit"));
		clickonElement(editbutton,"click edit button");
		WebElement viewname =driver.findElement(By.id("fname"));
		clickonElement(viewname,"click on viewname box");
		textvalues(viewname,"verify","enter viewname in view box");
		WebElement field=driver.findElement(By.id("fcol1"));
		mouseOver(field,"mouse field box");
		clickonElement(field,"click on field box");
		selectbyvalue(field,"ACCOUNT.NAME");
		clickonElement(field,"click on account name");
		WebElement operator=driver.findElement(By.id("fop1"));
		mouseOver(operator,"mouse operator box");
		clickonElement(operator,"click on operator box");
		selectbyvalue(operator,"c");
		clickonElement(operator,"click on contains");
		WebElement value= driver.findElement(By.id("fval1"));
		mouseOver(value,"mouse value box");
		clickonElement(value,"click on value box");
		textvalues(value,"a","text enter in value box");
		//select lastactivity
		WebElement display =driver.findElement(By.xpath("//tbody/tr[1]/td[1]/select[1]/option[31]"));
		mouseOver(display,"mouse on displayed");
		clickonElement(display,"click on display");
		WebElement add =driver.findElement(By.className("rightArrowIcon"));
		mouseOver(add,"mouse on add button");
		clickonElement(add,"click on add");
		WebElement saveButton =driver.findElement(By.name("save"));
		mouseOver(saveButton,"mouse on save button");
		clickonElement(saveButton,"click on button");
		//driver.close();
		report.logtestpass();
		
	}
	
	@Test
	public static void testcase13() throws IOException
	{
		accounttab();
		WebElement mergeaccount=driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]"));
		mouseOver(mergeaccount,"mouse on mergeaccount link");
		clickonElement(mergeaccount,"click on merge link");
		WebElement accountscrh=driver.findElement(By.id("srch"));
		mouseOver(accountscrh,"mouse on serch box");
		clickonElement(accountscrh,"clickon serach box");
		textvalues(accountscrh,"sjs","accnt name enterd");
		WebElement findaccount=driver.findElement(By.name("srchbutton"));
		mouseOver(findaccount,"mouse on find");
		clickonElement(findaccount,"click on find account button");
	    List <WebElement> AllCheckboxes =  driver.findElements(By.xpath("//input[@type='checkbox']"));    
	    int size = AllCheckboxes.size();
	    System.out.println(size);	    
	    for(int i = 2; i<size; i++) {       
	        AllCheckboxes.get(i).click();        
	    }
	    WebElement nextButton =driver.findElement(By.name("goNext"));
	    mouseOver(nextButton,"mouse on next");
		clickonElement(nextButton,"click on Next button");
	    WebElement mergebutton =driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[1]/div/input[2]"));
	    mouseOver(mergebutton,"mouse on merge");
		clickonElement(mergebutton,"click on merge button");
		waitUntilAlertIsPresent();
		 Alert alert =driver.switchTo().alert();
	     String alertmsg =alert.getText();
	     System.out.println(alertmsg);
	     alert.accept();
	    // closeDriver();
		captureshot("testcase13");
		report.logtestpass();
		}
		
	@Test
	public static void tastcase14() throws InterruptedException
	{
		accounttab();
		WebElement accntlastactivity =driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity > 30 days')]"));
	    mouseOver(accntlastactivity,"mouse on lastactivity");
		clickonElement(accntlastactivity,"click on lastactivity");
		WebElement datefiled =driver.findElement(By.xpath("//body[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[1]/form[1]/div[1]/div[1]/img[1]"));
	    mouseOver(datefiled,"mouse on datefiled");
		clickonElement(datefiled,"click on datefiled");
		WebElement datecreated =driver.findElement(By.xpath("//div[contains(text(),'Created Date')]"));
	    mouseOver(datecreated,"mouse on datefiled");
		clickonElement(datecreated,"click on datefiled");
		
		WebElement fromcalender =driver.findElement(By.xpath("//body[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[1]/form[1]/div[1]/div[3]/img[1]"));
	    mouseOver(fromcalender,"mouse on fromcalender");
	    clickonElement(fromcalender,"click on fromcalender"); 
	  
	    WebElement fromdate =driver.findElement(By.xpath("//body[1]/div[16]/ul[1]/li[1]/div[1]/table[1]/tbody[1]/tr[3]/td[1]/table[1]/tbody[1]/tr[2]/td[2]/em[1]/button[1]"));
	    mouseOver(fromdate,"mouse on fromcdate");
		clickonElement(fromdate,"click on fromdate");
		
		driver.findElement(By.xpath("//body[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[1]/form[1]/div[1]/div[4]/input[1]")).clear();
		Thread.sleep(5000);
		WebElement tocalender =driver.findElement(By.xpath("//body[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[1]/form[1]/div[1]/div[4]/img[1]"));
		
	    mouseOver(tocalender,"mouse on tocalender");
	    clickonElement(tocalender,"click on  to calender");
	    
	    WebElement todate =driver.findElement(By.xpath("//body[1]/div[17]/ul[1]/li[1]/div[1]/table[1]/tbody[1]/tr[3]/td[1]/table[1]/tbody[1]/tr[2]/td[2]/em[1]/button[1]"));
	    
	    mouseOver(todate,"mouse on to date");
		clickonElement(todate,"click on todate"); 
		 WebElement savebutton =driver.findElement(By.xpath("//button[@id='ext-gen49']"));
		    mouseOver(savebutton,"mouse on savebutton");
			clickonElement(savebutton,"click on savebutton");
			 WebElement reportname =driver.findElement(By.xpath("//input[@id='saveReportDlg_reportNameField']"));
				clickonElement(reportname,"click on reportname");
				textvalues(reportname,"testreport","enter the values");
				 WebElement reportuniquename =driver.findElement(By.xpath(" //input[@id='saveReportDlg_DeveloperName']"));
					clickonElement(reportuniquename,"click on reportuniquename");
					WebElement savereport =driver.findElement(By.xpath("//body[1]/div[20]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/em[1]/button[1]"));
					mouseOver(savereport,"mouse on savereport");
					clickonElement(savereport,"click on savereport");
					report.logtestpass();
					
		 
}
}	