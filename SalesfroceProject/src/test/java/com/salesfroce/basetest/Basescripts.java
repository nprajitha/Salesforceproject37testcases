package com.salesfroce.basetest;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.salesforce.utility.Commonutilities;
import com.salesforce.utility.Constants;
import com.salesforce.utility.Reportsgenerate;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basescripts {
	
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	public static ExtentHtmlReporter htmlreporter;// --->extent class object
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static Reportsgenerate report;
	@BeforeTest
	public static void firstTestsetup() 
	{
	 report= Reportsgenerate.getInstance();	
	 report.callextentreport();
	}
	@Parameters("browser")	
@BeforeMethod
	public static void setup(String browser,Method method) throws IOException
	{
	report.startsingletestreport(method.getName());
       launchdriver(browser);
		
		String url =Commonutilities.getpropertyvalue("url");
		String user=Commonutilities.getpropertyvalue("username");
		String password=Commonutilities.getpropertyvalue("password");
		navigate(url);
		login(user,password);
	}
@AfterMethod
public static void closeDriver() {
	driver.close();
}
@AfterTest
public static void finaltestdown()
{
	report.endreport();
}

	public static void launchdriver() {
		WebDriverManager.chromedriver().setup();
		 driver =new ChromeDriver();	
		// System.out.println("driver is launched");
		 report.logtestinfo("driver is launched");
		
	}
	
	//@Parameters("browser")
	
	public static void launchdriver(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			 driver =new ChromeDriver();
			 //System.out.println("driver is launched");
			 report.logtestinfo("driver is  chrome launched");
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			 driver =new FirefoxDriver();
			 //System.out.println("driver is launched");
			 report.logtestinfo("driver is firefox launched");
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			 driver =new EdgeDriver();
			 //System.out.println("driver is launched");
			 report.logtestinfo("driver is  edge launched");
		}
		else {
			System.out.println("B/rowser not found ");
		}
		
	}
	public static void navigate(String url)
	{
		driver.get(url);
		//System.out.println("url is opened");
		report.logtestinfo("url is :"+url);
	}
	public static void login(String username, String password)
	{
		WebElement user = driver.findElement(By.xpath("//input[@id='username']"));
		waituntillvisible(user,"user name");
		textvalues(user,username,"username");
		
		WebElement pswd =driver.findElement(By.xpath("//input[@id='password']"));
		textvalues(pswd,password,"password");
		WebElement loginbutton= driver.findElement(By.xpath("//input[@id='Login']"));
		clickonElement(loginbutton,"login button is clicked");
		
	}
	
	public static void waituntillvisible(WebElement element,String objname)
	{
		 wait = new WebDriverWait(driver, 40); 
	    wait.until(ExpectedConditions.visibilityOf(element) );	  
	}
	public static void waituntillvisibilityofelementlocated(By locator,String objname)
	{
		wait = new WebDriverWait(driver, 30); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(locator) );	 
		
	}
	public static void waituntillelementToBeClickable(WebElement element,String objname)
	{
		wait = new WebDriverWait(driver, 30); 
	    wait.until(ExpectedConditions.elementToBeClickable(element) );	 
		
	}
	public static void clearele(WebElement element,String objname)
	{
		if(element.isDisplayed())
		{
		element.clear();
		report.logtestinfo(objname+ "text cleared");
		//System.out.println("Succesfully text is cleared");
		}
		else {
			//System.out.println(" failed text is not cleared");
			report.logtestinfo(objname+ "text not cleared");
		}
	}
	public static void textvalues(WebElement element,String text,String objname) 
	{
		if(element.isDisplayed())
		{
			clearele(element ,objname);
			element.sendKeys(text);
			//System.out.println(objname +"text is entered");
			report.logtestinfo("text entered"+objname);
		}
		else 
		{
			report.logtestinfo("text not entered"+objname);
		
			//System.out.println("text is not entered");
		}
	}
	public static void clickonElement(WebElement element ,String objname)
	{
		if(element.isDisplayed()) {
			element.click();
			//System.out.println("successfully "+objname);
			report.logtestinfo("click on"+objname);
		}
		else {
			//System.out.println(" element not displayed");
			report.logtestinfo("not clicked"+objname);
		}
		}
	
	public static void mouseOver(WebElement element,String objName) {
		waituntillvisible(element,objName);
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
		report.logtestinfo(objName);

}
	public static void selectbyvalue(WebElement element,String dropdownvalue)
	{
		waituntillvisible(element,dropdownvalue);
		Select select= new Select(element);
		select.selectByValue(dropdownvalue);	
	}
	public static void selectbyindex(WebElement element,int dropdownindex,String objName)
	{
		Select select= new Select(element);
		select.selectByIndex(dropdownindex);	
	}
	public static void selectbyvisibletext(WebElement element,String dropdowntext,String objName)
	{
		waituntillvisible(element,dropdowntext);
		Select select= new Select(element);
		select.selectByVisibleText(dropdowntext);	
	}
	public static void waitUntilAlertIsPresent() {
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.alertIsPresent());
	}
//	public static void AcceptAlert() {
//		waitUntilAlertIsPresent();
//		Alert alert=switchToAlert();
//		System.out.println("alert text="+alert.getText());
//		alert.accept();
//		
//	}
	public static void dropdown()
	{
		By swithTo = By.xpath("//div[@id='userNavButton']");
		waituntillvisibilityofelementlocated(swithTo, "switch to user dropdown");
		WebElement switchmenu = driver.findElement(swithTo);
		mouseOver(switchmenu,"switch usermenu");
		clickonElement(switchmenu,"usermenu is displayed");	
	}
	public static void accounttab()
	{
		By accnt=By.linkText("Accounts");
		waituntillvisibilityofelementlocated(accnt, "go to account");
		WebElement account =driver.findElement(accnt);
		mouseOver(account," account");
		clickonElement(account," accounts tab");  
         By cls=By.id("tryLexDialogX");
 		waituntillvisibilityofelementlocated(cls, "go to prompt win");
		WebElement close= driver.findElement(cls);
		mouseOver(close,"close");
		clickonElement(close," close");	
	}
	public static void createoppt()
	{
		By oppt =By.xpath("//a[contains(text(),'Opportunities')]");
		waituntillvisibilityofelementlocated(oppt, "go to opportunities");
		WebElement opportunities =driver.findElement(oppt);
		mouseOver(opportunities,"mouse on opportunities");
		clickonElement(opportunities,"click on opportunities tab");
		 By cls=By.id("tryLexDialogX");
	 		waituntillvisibilityofelementlocated(cls, "go to prompt win");
			WebElement close= driver.findElement(cls);
			mouseOver(close,"mouse on close");
			clickonElement(close,"click on close");	
		}
	public static void  leadtab()
	{
		By lead =By.xpath("//a[contains(text(),'Leads')]");
		waituntillvisibilityofelementlocated(lead, "go to lead");
		WebElement tablead =driver.findElement(lead);
		mouseOver(tablead,"mouse on lead");
		clickonElement(tablead,"click on lead tab");
		By cls=By.id("tryLexDialogX");
 		waituntillvisibilityofelementlocated(cls, "go to prompt win");
		WebElement close= driver.findElement(cls);
		mouseOver(close,"mouse on close");
		clickonElement(close,"click on close");	
	}
	public static void contactstab()
	{
		By contact =By.xpath("//a[contains(text(),'Contacts')]");
		waituntillvisibilityofelementlocated(contact, "go to tabcontact");
		WebElement tabcontact=driver.findElement(contact);
		mouseOver(tabcontact,"mouse on tabcontact");
		clickonElement(tabcontact,"click on tabcontact");
		By cls=By.id("tryLexDialogX");
 		waituntillvisibilityofelementlocated(cls, "go to prompt win");
		WebElement close= driver.findElement(cls);
		mouseOver(close,"mouse on close");
		clickonElement(close,"click on close");	
		
	}
	public static void hometab()
	{
		By contact =By.xpath("//a[contains(text(),'Home')]");
		waituntillvisibilityofelementlocated(contact, "go to tab HOME");
		WebElement tabhome=driver.findElement(contact);
		mouseOver(tabhome,"mouse on tab home");
		clickonElement(tabhome,"click on tab home");
		By cls=By.id("tryLexDialogX");
 		waituntillvisibilityofelementlocated(cls, "go to prompt win");
		WebElement close= driver.findElement(cls);
		mouseOver(close,"mouse on close");
		clickonElement(close,"click on close");	
		
	}
	
	public static void captureshot(String filename) throws IOException
	{
		Date currentdate=new Date();
		 String screenshotfilename=currentdate.toString().replace(" ","-").replace(":", "-");
		 System.out.println(screenshotfilename);
		 
		TakesScreenshot  capture =(TakesScreenshot)driver; //taking screen shot
		File srcimg=capture.getScreenshotAs(OutputType.FILE);// capture img to store in file
		String screenpath=Constants.SCREENSHOT_PATH+filename+screenshotfilename+".png";
		File dstimg=new File(screenpath);
		FileUtils.copyFile(srcimg, dstimg);
		report.logtestinfo(screenpath);
		//return screenpath;
		
	}
	
	
}
