package com.crm.listeners;

import java.io.File;
import java.lang.ProcessHandle.Info;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.base.VTigerBase;

public class ExtentReport extends VTigerBase implements ITestListener 
{
	public static ExtentSparkReporter spark = null;
	public static ExtentReports report = null;
	public static ExtentTest test = null;

	@Override
	public void onTestStart(ITestResult result) {
		String name = result.getMethod().getMethodName();
		
		test = report.createTest(name);
		test.log(Status.INFO, name + "has Started");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		String name = result.getMethod().getMethodName();
		
		test.log(Status.PASS, name + "has succeded");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		String name = result.getMethod().getMethodName();
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		String from = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(from);
		test.log(Status.FAIL, name + "has failed");
	
		

	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		String name = result.getMethod().getMethodName();
		
		test.log(Status.SKIP, name + "has Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		
		File file = new File(".\\src\\test\\resources\\reports\\VTigerReport.html");
		spark = new ExtentSparkReporter(file);
		
		spark.config().setDocumentTitle("Vtiger");
		spark.config().setReportName("Sudhir");
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		
		report.setSystemInfo("System", "Windows11");
		report.setSystemInfo("browser", "chrome");
		
		report.attachReporter(spark);

	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
