package com.automation.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.salesfroce.basetest.Basescripts;

public class UsermenuDroppdown extends Basescripts{
	
	@Test
	public static void testcase5() throws IOException
	{
		
		//dropdown();
		By swithTo = By.xpath("//div[@id='userNavButton']");
		waituntillvisibilityofelementlocated(swithTo, "switch to tab");
		WebElement switchmenu = driver.findElement(swithTo);
		mouseOver(switchmenu,"switch to usermenu");
		clickonElement(switchmenu,"usermenu is clicked");	
		
		 if(switchmenu.isEnabled() && switchmenu.isDisplayed()) 
		   { 
		      System.out.println("Dropdown is enabled and visible"); 
		   } 
		  else { 
		      System.out.println("Dropdown is not visible"); 
		  } 
		captureshot("testcase5");
		report.logtestpass();
		//report.attachscreeshot();
		 

	}
	@Test
	public static void testcase6() throws InterruptedException
	{

		dropdown();
		WebElement profile=driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		clickonElement(profile,"profile page  will displayed");	
		By edit = By.xpath("//*[@id=\"chatterTab\"]/div[2]/div[2]/div[1]/h3/div/div/a/img");
		waituntillvisibilityofelementlocated(edit, "go to edit button");
		WebElement editprofile =driver.findElement(edit);
		mouseOver(editprofile,"mouse on editprofile");
		clickonElement(editprofile,"click on edit profile"); 
		//switching to frame
		List<WebElement > frame= driver.findElements(By.tagName("iframe"));
	     System.out.println("no of frames"+frame.size());
		Thread.sleep(5000);
		driver.switchTo().frame("contactInfoContentId");// frame by id 
		WebElement about= driver.findElement(By.xpath("//a[contains(text(),'About')]")); ////*[@id="aboutTab"]/a
		mouseOver(about,"mouse on about");
		clickonElement(about,"click on about tab");
        WebElement lname= driver.findElement(By.id("lastName"));
        textvalues(lname,"ss","lastname");
		WebElement savebutton=driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]"));
	    clickonElement(savebutton,"click on save") ;
	    driver.switchTo().defaultContent();
	    //clicking on post
		WebElement post=driver.findElement(By.xpath("//*[@id=\"publisherAttachTextPost\"]/span[1]"));
		 clickonElement(post,"click on postlink") ;
		 List<WebElement > frame1= driver.findElements(By.tagName("iframe"));
	     System.out.println("no of frames"+frame1.size());
	     driver.switchTo().frame(0);
	     //JavascriptExecutor js = (JavascriptExecutor)driver;
	     WebElement posttext=driver.findElement(By.xpath("/html/body"));
	     waituntillelementToBeClickable(posttext,"wait to click");
	    // js.executeScript("arguments[0].click()", posttext);
		 // js.executeScript("arguments[0].value='hi';",posttext);
	    clickonElement(posttext,"click on post");
		 textvalues(posttext ,"welcome","text enter");
		 driver.switchTo().defaultContent();		 
		 WebElement sharebutton=driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
		 waituntillelementToBeClickable(sharebutton,"wait to click");
	      mouseOver(sharebutton,"mouse on sharebutton");
		 clickonElement(sharebutton,"click on sharebutton");
		//file upload
		 Thread.sleep(5000);
		WebElement file=driver.findElement(By.xpath("//*[@id=\"publisherAttachContentPost\"]/span[1]"));
		 clickonElement(file,"click on file");
		 WebElement uploadfile=driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']"));
		// waituntillelementToBeClickable(uploadfile,"wait to click");
		 mouseOver(uploadfile,"mouse on upload file");
		 clickonElement(uploadfile,"click on file");
		 WebElement browsefile=driver.findElement(By.id("chatterFile"));
		 waituntillelementToBeClickable(browsefile,"wait to click");
		browsefile.sendKeys("C:\\Users\\vamsiraji\\Desktop\\newfile.txt");
		 //textvalues(browsefile,"C:\\Users\\vamsiraji\\Desktop\\drivers path.txt" ,"path enter");
		Thread.sleep(2000);
		 WebElement sharebutton1=driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
		 mouseOver(sharebutton1,"mouse on sharebutton");
		 clickonElement(sharebutton1,"click on sharebutton");
		 report.logtestpass();
		
	}
	@Test
	public static void addphoto() throws AWTException, InterruptedException
	{
		dropdown();
		WebElement profile=driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		clickonElement(profile,"profile page  will displayed");	
		By addpic =By.xpath(" //a[@id='uploadLink']");
		waituntillvisibilityofelementlocated(addpic, "go to addpic link");
		WebElement photo=driver.findElement(addpic);
		mouseOver(photo,"mouse on photo");
		clickonElement(photo,"click on photo");
		List<WebElement > frame= driver.findElements(By.tagName("iframe"));
	     System.out.println("no of frames"+frame.size());
	     Thread.sleep(8000);
		//switching to frame	
		 driver.switchTo().frame("uploadPhotoContentId"); 
		 Thread.sleep(5000);//uploadPhotoContentId
            By uploadfile1 =By.xpath("//body[1]/span[1]/form[1]/input[2]");//*[@id=\"j_id0:uploadFileForm:uploadInputFile\"]
			waituntillvisibilityofelementlocated(uploadfile1, "go to addpic file");
			WebElement file1=driver.findElement(uploadfile1);
			Actions action=new Actions(driver);
			action.moveToElement(file1).click().build().perform();
			Thread.sleep(5000);
			// creating object of Robot class
			Robot robot=new Robot();
			 // Clipboard copy
			StringSelection s = new StringSelection("C:\\Users\\vamsiraji\\Desktop\\download.jpg");
		      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
		   // press Contol+V for pasting
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			// release Contol+V for pasting
          robot.keyRelease(KeyEvent.VK_V);
          robot.keyRelease(KeyEvent.VK_CONTROL);
       // for pressing and releasing Enter
          robot.keyPress(KeyEvent.VK_ENTER);
          robot.keyRelease(KeyEvent.VK_ENTER);	
            By save =By.xpath("//body[1]/span[1]/form[1]/div[3]/input[1] ");
			waituntillvisibilityofelementlocated(save, "go to addpic link");//*[@id='j_id0:uploadFileForm:save']
			WebElement savebutton=driver.findElement(save);
//			mouseOver(savebutton,"mouse on save");
//			clickonElement(savebutton,"click on save");
			Actions action1=new Actions(driver);
			action1.moveToElement(savebutton).click().build().perform();		
	         Thread.sleep(5000);
			 By save1 =By.xpath("//body[1]/span[1]/form[1]/div[2]/input[1] ");
			waituntillvisibilityofelementlocated(save1, "go to addpic link");
			WebElement savebutton1=driver.findElement(save1);
			Actions action2=new Actions(driver);
			action2.moveToElement(savebutton1).click().build().perform();
			report.logtestpass();
		
	}
	
	@Test
	public static void testcase7()
	{
		
		dropdown();
		WebElement mysetting =driver.findElement(By.xpath("	//a[contains(text(),'My Settings')]")) ;
		clickonElement(mysetting,"click on setting");
		By personal=By.xpath("//div[@id='PersonalInfo']//a[contains(@class,'header setupFolder')]");
		waituntillvisibilityofelementlocated(personal, "go to personal link");
		WebElement personallink=driver.findElement(personal);
		mouseOver(personallink,"mouse on link");
		clickonElement(personallink,"click on personallink");
		WebElement loginhistory= driver.findElement(By.id("LoginHistory_font"));
		mouseOver(loginhistory,"mouse on loginhistory");
		clickonElement(loginhistory,"click on login history");	
		By dwl=By.xpath("//a[contains(text(),'Download login history for last six months, includ')]");
		waituntillvisibilityofelementlocated( dwl,"wait to locate");
		WebElement downloadloginhistory= driver.findElement(dwl);
		mouseOver(downloadloginhistory,"mouse on download login history");
		clickonElement(downloadloginhistory,"click on download login history");
		WebElement display=driver.findElement(By.id("DisplayAndLayout_font"));
		mouseOver(display,"mouse on display");
		clickonElement(display,"click on display");
		WebElement mycustomtab=driver.findElement(By.id("CustomizeTabs_font"));
		mouseOver(mycustomtab,"mouse on mycustomtab");
		clickonElement(mycustomtab,"click on mycustomtab");
		WebElement customapp=driver.findElement(By.id("p4"));
		mouseOver(customapp,"mouse on customtapp");
		clickonElement(customapp,"click on customtapp");
		selectbyvalue(customapp ,"02u8a000000cUJo");
		By rt=By.xpath("//select[@id='duel_select_0']");
		waituntillvisibilityofelementlocated( rt,"wait to locate");
		WebElement reporttab=driver.findElement(rt);
		mouseOver(reporttab,"mouse on reporttab");
		clickonElement(reporttab,"click on reporttab");
		selectbyvalue(reporttab ,"report");
		WebElement addbutton=driver.findElement(By.xpath("//img[contains(@class,'rightArrowIcon')]"));
		mouseOver(addbutton,"mouse on addbutton");
		clickonElement(addbutton,"click on addbutton");
		WebElement email=driver.findElement(By.id("EmailSetup_font"));
		mouseOver(email,"mouse on email");
		clickonElement(email,"click on email");
		WebElement emailsetting=driver.findElement(By.id("EmailSettings_font"));
		mouseOver(emailsetting,"mouse on emailsetting");
		clickonElement(emailsetting,"click on emailsetting");
		WebElement emailname=driver.findElement(By.id("sender_name"));
		clickonElement(emailname,"click on email name");
		textvalues(emailname,"rajitha ss","email name entered");
		
		WebElement emailid=driver.findElement(By.id("sender_email"));
		clickonElement(emailid,"click on email id");
		textvalues(emailid,"spushparajitha@gmail.com","email id entered");
		WebElement autobcc=driver.findElement(By.id("auto_bcc1"));
		boolean bvalue=autobcc.isSelected();
		if(bvalue==true)
		{
			System.out.println("radiobutton clicked");
		}
		else
		{
			//autobcc.click();
			clickonElement(autobcc,"click on autobcc");	
		}
		WebElement savebutton=driver.findElement(By.name("save"));
		mouseOver(savebutton,"mouse on savebutton");
		clickonElement(savebutton,"click on savebutton");
		WebElement calenderandremainder=driver.findElement(By.id("CalendarAndReminders_font"));
		mouseOver( calenderandremainder,"mouse on  calenderandremainder");
		clickonElement( calenderandremainder,"click on  calenderandremainder");
		WebElement activityremainder=driver.findElement(By.id("Reminders_font"));
		mouseOver( activityremainder,"mouse on  activityremainder");
		clickonElement( activityremainder,"click on  activityremainder");
		WebElement testremainder=driver.findElement(By.id("testbtn"));
		mouseOver( testremainder,"mouse on  testremainder");
		clickonElement( testremainder,"click on  testremainder");
		String parentWin = driver.getWindowHandle();
        System.out.println("source" +parentWin);
     Set<String> windows = driver.getWindowHandles();
     Iterator<String> it = windows.iterator();  
     while(it.hasNext()) {
           String childWin = it.next(); 
         if(!parentWin.equals(childWin)) {    
         driver.switchTo().window(childWin);
         System.out.println(driver.getTitle());
         driver.findElement(By.id("dismiss_all")).click();
         }
     }
     report.logtestpass();
	}
	@Test
	public static void testcase8()
	{
		
		dropdown();
		WebElement devconsole= driver.findElement(By.xpath("//a[contains(text(),'Developer Console')]"));
		clickonElement(devconsole,"open developerconsole");
           String parentWin = driver.getWindowHandle();
           System.out.println("source" +parentWin);
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();  
        while(it.hasNext()) {
              String childWin = it.next(); 
            if(!parentWin.equals(childWin)) {    
            driver.switchTo().window(childWin);
            System.out.println(driver.getTitle());
          driver.close();
          driver.switchTo().window(parentWin);
            }
        }
        report.logtestpass();
	}
	@Test
	
	public static void testcase9()
	{
		
		dropdown();
		WebElement logout=driver.findElement(By.linkText("Logout"));
		clickonElement(logout,"loggedout");
		//driver.close();
		report.logtestpass();
		
	}
}
