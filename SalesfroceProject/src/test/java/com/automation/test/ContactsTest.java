package com.automation.test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.salesfroce.basetest.Basescripts;

public class ContactsTest  extends Basescripts{
	@Test
	public static void testcase25() throws IOException
	{
		contactstab();
		WebElement contnewbutton=driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
		mouseOver(contnewbutton,"mouse on new button");
		clickonElement(contnewbutton,"click on new button");
		WebElement contactlname =driver.findElement(By.id("name_lastcon2"));
		clickonElement(contactlname," contactlname");
		textvalues(contactlname,"jack"," contactlname");
//		WebElement lookupbutton=driver.findElement(By.className("lookupIcon"));
//		mouseOver(lookupbutton,"mouse on lookupbutton");
//		clickonElement(lookupbutton,"click on lookupbutton");
		WebElement acname =driver.findElement(By.id("con4"));
		clickonElement( acname,"  acnamee");
		textvalues(acname,"abc","  acname");
		WebElement sbutton=driver.findElement(By.name("save"));
		mouseOver(sbutton," save button");
		clickonElement(sbutton," savebutton");
		captureshot("testcase25");
		report.logtestpass();
	}
	@Test
	public static void testcase26() throws IOException
	{
		contactstab();
		WebElement createcontactview=driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		mouseOver(createcontactview,"mouse on createcontactview");
		clickonElement(createcontactview,"click on createcontactview");
		WebElement contactviewname=driver.findElement(By.xpath("//input[@id='fname']"));
		//mouseOver(contactviewname,"mouse on contactviewname");
		clickonElement(contactviewname,"click on contactviewname");
		textvalues(contactviewname,"newcontact1","newcontact added");
		WebElement contactviewuniquename=driver.findElement(By.xpath("//input[@id='devname']"));
		clickonElement(contactviewuniquename,"click on contactviewuniquename");
		WebElement scontactbutton=driver.findElement(By.name("save"));
		mouseOver(scontactbutton,"mouse on save button");
		clickonElement(scontactbutton,"click on savebutton");
		captureshot("testcase26");
		report.logtestpass();
	}
	@Test
	public static void testcase27() throws IOException 
	{
		contactstab();
		
		WebElement recentdropdown=driver.findElement(By.xpath("//select[@id='hotlist_mode']"));
		mouseOver(recentdropdown," recentdropdown");
		clickonElement(recentdropdown," recentdropdown");
		selectbyvalue(recentdropdown,"2");
		clickonElement(recentdropdown," recentdropdown");
		captureshot("testcase27");
		report.logtestpass();
	}
	@Test
	public static void testcase28() throws IOException
	{
		contactstab();
		WebElement contactdropdown=driver.findElement(By.xpath("//select[@id='fcf']"));
		mouseOver(contactdropdown," contactdropdown");
		clickonElement(contactdropdown," contactdropdown");
		selectbyvalue(contactdropdown,"00B8a00000AHYER");
		clickonElement(contactdropdown," contactdropdown");
		captureshot("testcase28");
		report.logtestpass();
	}
	@Test
	public static void testcase29() throws IOException 
	{
		contactstab(); 
		WebElement contactname=driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/th/a"));
		mouseOver(contactname,"mouse on contactname");
		clickonElement(contactname,"click on contactname");
		captureshot("testcase29");
		report.logtestpass();
	}
	@Test
	
	public static void testcase30() throws IOException
	{
		contactstab();
		WebElement createcontactview1=driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		mouseOver(createcontactview1,"mouse on createcontactview");
		clickonElement(createcontactview1,"click on createcontactview");
		WebElement contactviewuniquename=driver.findElement(By.xpath("//input[@id='devname']"));
		clickonElement(contactviewuniquename,"click on contactviewuniquename");
		textvalues(contactviewuniquename,"EFGH","EFGH is  added");
		WebElement scontactbutton=driver.findElement(By.name("save"));
		mouseOver(scontactbutton," save button");
		clickonElement(scontactbutton," savebutton");
		captureshot("testcase30");
		report.logtestpass();
	}
	@Test
	public static void testcase31() throws IOException
	{
		contactstab();
		WebElement createcontactview=driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		mouseOver(createcontactview,"mouse on createcontactview");
		clickonElement(createcontactview,"click on createcontactview");
		WebElement contactviewname=driver.findElement(By.id("fname"));
		//xpath("//input[@id='fname']"))
		clickonElement(contactviewname,"click on contactviewname");
		textvalues(contactviewname,"ABCD","ABCD added");
		WebElement contactviewuniquename=driver.findElement(By.xpath("//input[@id='devname']"));
		clickonElement(contactviewuniquename,"click on contactviewuniquename");
		textvalues(contactviewuniquename,"EFGH","EFGH added");
		WebElement cancelcontactbutton=driver.findElement(By.name("cancel"));
		mouseOver(cancelcontactbutton,"mouse on cancelcontactbuttonn");
		clickonElement(cancelcontactbutton,"click on cancelcontactbutton");
		captureshot("testcase31");
		report.logtestpass();
		
		
	}
	@Test
	public static void testcase32() throws IOException
	{
		contactstab();
		WebElement contnewbutton=driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
		mouseOver(contnewbutton,"mouse on new button");
		clickonElement(contnewbutton,"click on new button");
		WebElement contactlname =driver.findElement(By.id("name_lastcon2"));
		clickonElement(contactlname,"click on contactlname");
		textvalues(contactlname,"Indian","text in contactlname");
		WebElement acname =driver.findElement(By.id("con4"));
		clickonElement( acname,"click on  acnamee");
		textvalues(acname,"GlobalMedia","text in  acname");
		WebElement savenewbutton=driver.findElement(By.name("save_new"));
		mouseOver(savenewbutton," save&newbuttonn");
		clickonElement(savenewbutton," save&newbutton");
		String contactpage=driver.getTitle();
		System.out.println(contactpage);
		captureshot("testcase32");
		report.logtestpass();
		
	}

}
