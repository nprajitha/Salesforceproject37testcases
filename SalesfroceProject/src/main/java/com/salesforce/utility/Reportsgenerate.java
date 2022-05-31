package com.salesforce.utility;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reportsgenerate {
	
	public static ExtentHtmlReporter htmlreporter;// --->extent class object
	public static ExtentReports extent;
	public static ExtentTest logger;
	private static Reportsgenerate gr;
	private Reportsgenerate()
	{
		
	}
	public static Reportsgenerate getInstance()
	{
		if(gr==null)
		{
			gr=new Reportsgenerate();
		}
		return gr;
		
	}
	static String testcasename = null;
	public static void  callextentreport()
	{
		htmlreporter =new ExtentHtmlReporter(Constants.REPORT_PATH); // creating html path
		extent =new ExtentReports();
		 extent .attachReporter(htmlreporter);
		 extent.setSystemInfo("enviroment", "automation testing");
		 extent.setSystemInfo("username","student");
		
		//genearting single report file
		htmlreporter.config().setDocumentTitle("Test Execution Report");
		htmlreporter.config().setReportName("saleforce tests");
		htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlreporter.config().setTheme(Theme.STANDARD);
	}
	public void startsingletestreport(String testname)
	{
		testcasename =testname;
		logger=extent.createTest(testname);
		
		
	}
	public void logtestinfo(String message)
	{
		logger.log(Status.INFO, message);
	}
	public void logtestpass()
	{
		logger.log(Status.PASS,MarkupHelper.createLabel("my testcase is pass", ExtentColor.GREEN));
	}
	public void logtestfail()
	{
		logger.log(Status.FAIL,MarkupHelper.createLabel("my testcase is failed", ExtentColor.RED));
	}
	public void endreport()
	{
		extent.flush();
	}
//	public void attachscreeshot() throws IOException
//	{
//		logger.addScreenCaptureFromPath(shotname);
//	}

}
