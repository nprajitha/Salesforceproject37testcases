package com.automation.test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.utility.Commonutilities;
import com.salesfroce.basetest.Basescripts;

public class RandomScenarios extends Basescripts {
	@Test
	
	public static void testcase33()
	{
		hometab();
		WebElement flname= driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/div[1]/div[2]/span[1]/h1[1]/a[1]"));
		mouseOver(flname,"mouse on flanme");
		clickonElement(flname,"click on flname");
		String fl=driver.getTitle();
		System.out.println(fl);
		dropdown();
		WebElement profile=driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		clickonElement(profile,"profile page  will displayed");	
		String f2 =driver.getTitle();
		System.out.println(f2);
		Assert.assertEquals(fl, f2);
		report.logtestpass();
	}
	@Test
	public static void testcase34()
	{
		hometab();
		WebElement flname= driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/div[1]/div[2]/span[1]/h1[1]/a[1]"));
		mouseOver(flname," flanme");
		clickonElement(flname," flname");
		By edit = By.xpath("//*[@id=\"chatterTab\"]/div[2]/div[2]/div[1]/h3/div/div/a/img");
		waituntillvisibilityofelementlocated(edit, "go to edit button");
		WebElement editprofile =driver.findElement(edit);
		mouseOver(editprofile,"mouse on editprofile");
		clickonElement(editprofile,"click on edit profile"); 
		driver.switchTo().frame("contactInfoContentId");// frame by id 
		WebElement about= driver.findElement(By.xpath("//a[contains(text(),'About')]"));
		mouseOver(about,"mouse on about");
		clickonElement(about,"click on about tab");
		WebElement lname= driver.findElement(By.id("lastName"));
        textvalues(lname,"Abcd","lastname");
		WebElement savebutton=driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]"));
	    clickonElement(savebutton,"click on save") ;
	    driver.switchTo().defaultContent();
	    report.logtestpass();
	}
	@Test
	public static void testcase35() throws InterruptedException, IOException
	{
		By tab =By.xpath(" //img[@class='allTabsArrow']");
		waituntillvisibilityofelementlocated(tab, "go to plus tab");
		WebElement plustab=driver.findElement(tab);
		mouseOver(plustab,"mouse on plustab");
		clickonElement(plustab,"click on plustab");
		By tab1 =By.name("customize");
		waituntillvisibilityofelementlocated(tab1, "go to custom tab");
		WebElement customtab= driver.findElement(tab1);
		mouseOver(customtab,"mouse on customtab");
		clickonElement(customtab,"click on customtab");
		By selecttab =By.xpath(" //select[@id='duel_select_1']");
		waituntillvisibilityofelementlocated(selecttab, "go to  select tab");
		WebElement stab=driver.findElement(selecttab);
		//mouseOver(stab,"mouse on stab");
		//clickonElement(stab,"click on stab");
		selectbyvalue(stab,"ContentContribute"); 
		By rbutton =By.xpath("//img[contains(@class,'leftArrowIcon')] ");
		waituntillvisibilityofelementlocated(rbutton, "go to remove button");
		WebElement removebutton=driver.findElement(rbutton);
		mouseOver(removebutton,"mouse on removebutton");
		clickonElement(removebutton,"click on removebutton");
		WebElement save=driver.findElement(By.name("save"));
		mouseOver(save,"mouse on savebutton");
		clickonElement(save,"click on savebutton");
		dropdown();
		WebElement logout=driver.findElement(By.linkText("Logout"));
		clickonElement(logout,"loggedout");
		Thread.sleep(2000);
		String user=Commonutilities.getpropertyvalue("username");
		String password=Commonutilities.getpropertyvalue("password");
		login(user,password);
		captureshot("testcase35");
		report.logtestpass();
	}
	@Test
	public static void testcase36() throws InterruptedException, IOException
	{
		hometab();
		WebElement currentdatelink=driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[2]/a"));
		
		mouseOver(currentdatelink,"mouse on currentdatelink");
		clickonElement(currentdatelink,"click on currentdatelink");
		WebElement timelink=driver.findElement(By.xpath("//*[@id=\"p:f:j_id25:j_id61:28:j_id64\"]/a"));
		mouseOver(timelink,"mouse on timelink");
		clickonElement(timelink,"click on  timelink");
		
		Thread.sleep(2000);
		
		WebElement subjecticon=driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div[2]/div[4]/table/tbody/tr[2]/td[2]/div/a/img"));
		mouseOver(subjecticon,"mouse on subjecticon");
		clickonElement(subjecticon,"click on subjecticon");
		//get the window handles
		String parentWin = driver.getWindowHandle();
        System.out.println("source" +parentWin);
     Set<String> windows = driver.getWindowHandles();
     Iterator<String> it = windows.iterator();  
     while(it.hasNext()) {
           String childWin = it.next(); 
         if(!parentWin.equals(childWin)) {    
         driver.switchTo().window(childWin);
         System.out.println(driver.getTitle());
         }
     }
		WebElement subjecticonpopup=driver.findElement(By.xpath("//a[contains(text(),'Other')]"));
		mouseOver(subjecticonpopup,"mouse on subjecticon pop up");
		clickonElement(subjecticonpopup,"click on subjecticon pop up");
		 driver.switchTo().window(parentWin);
		 WebElement endtime=driver.findElement(By.id("EndDateTime_time"));
			mouseOver(endtime,"mouse on endtime");
			clickonElement(endtime,"click on endtime");
			WebElement time=driver.findElement(By.id("timePickerItem_42"));
			//mouseOver(time,"mouse on endtime");
			clickonElement(time,"click on time");
		WebElement save=driver.findElement(By.name("save"));
		mouseOver(save,"mouse on save");
		clickonElement(save,"click on save");
		captureshot("testcase36");
		report.logtestpass();
		
	}
	@Test
	public static void testcase37() throws InterruptedException, IOException
	{
		hometab();
		WebElement currentdatelink=driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[2]/a"));
		mouseOver(currentdatelink,"mouse on currentdatelink");
		clickonElement(currentdatelink,"click on currentdatelink");
		WebElement timelink=driver.findElement(By.xpath("//*[@id=\"p:f:j_id25:j_id61:20:j_id64\"]/a"));
		mouseOver(timelink,"mouse on timelink");
		clickonElement(timelink,"click on  timelink");
		Thread.sleep(2000);
		WebElement subjecticon=driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div[2]/div[4]/table/tbody/tr[2]/td[2]/div/a/img"));
		mouseOver(subjecticon,"mouse on subjecticon");
		clickonElement(subjecticon,"click on subjecticon"); 
		String parentWin = driver.getWindowHandle();
        System.out.println("source" +parentWin);
     Set<String> windows = driver.getWindowHandles();
     Iterator<String> it = windows.iterator();  
     while(it.hasNext()) {
           String childWin = it.next(); 
         if(!parentWin.equals(childWin)) {    
         driver.switchTo().window(childWin);
         System.out.println(driver.getTitle());
         }
     }
		WebElement subjecticonpopup=driver.findElement(By.xpath("//a[contains(text(),'Other')]"));
		mouseOver(subjecticonpopup,"mouse on subjecticon pop up");
		clickonElement(subjecticonpopup,"click on subjecticon pop up");
		 driver.switchTo().window(parentWin);
		 WebElement endtime=driver.findElement(By.id("EndDateTime_time"));
			mouseOver(endtime,"mouse on endtime");
			clickonElement(endtime,"click on endtime");
			WebElement time=driver.findElement(By.id("timePickerItem_38"));
			//mouseOver(time,"mouse on endtime");
			clickonElement(time,"click on time");
			List<WebElement> checkbox= driver.findElements(By.id("IsRecurrence"));
		       boolean bvalue;
		       bvalue=checkbox.get(0).isSelected();
		        if(bvalue== false)
		        {
		        	checkbox.get(0).click();
		        
		        }
		        else {
		        	System.out.println("it is already selected");
		        }
		        WebElement radiobutton= driver.findElement(By.id("rectypeftw"));
		        mouseOver(radiobutton,"mouse on radiobutton");
				clickonElement(radiobutton,"click on radiobutton");
				WebElement enddate =driver.findElement(By.id("RecurrenceEndDateOnly"));
				clickonElement(enddate,"click on enddate");
				 driver.findElement(By.xpath("//*[@id=\"calRow4\"]/td[4]")).click();
				 WebElement save=driver.findElement(By.name("save"));
					mouseOver(save,"mouse on save");
					clickonElement(save," save");
					WebElement monthviewicon =driver.findElement(By.xpath("//*[@id=\"bCalDiv\"]/div/div[2]/span[2]/a[3]/img"));
					mouseOver(monthviewicon,"monthviewicon");
					clickonElement(monthviewicon," monthviewicon");
					captureshot("testcase37");
					report.logtestpass();
					//String calpage=driver.getTitle();
	}
	
}
