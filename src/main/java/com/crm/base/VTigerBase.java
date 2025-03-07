package com.crm.base;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.fileUtility.ReadFromProperties;
import com.crm.pom.HomePage;
import com.crm.pom.LoginPage;
import com.crm.pom.OrganisationPage;

public class VTigerBase extends ReadFromProperties
{
	public static WebDriver driver = null;
	@BeforeClass
	public static void preCondition() throws IOException
	{
		String browser = getData("browser");
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Safari"))
		{
			driver = new SafariDriver();
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("FireFox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		//maximize browser
		driver.manage().window().maximize();
		//open vtiger website
		driver.get(getData("url"));
		
		String current_url = driver.getCurrentUrl();
		assertEquals("http://localhost:8888/" ,current_url,"Not on Vtiger page");
		
		Reporter.log("Entered on VtigerPage",true);
		
	}
	
@BeforeMethod
	public static void login() throws IOException
	{
		//get username from file
		String username = getData("username");
		//get password from file
		String pass = getData("pass");
		//create object of LoginPage class 
		LoginPage lp = new LoginPage(driver);
		//send username using methods
		lp.username(username);
		//send password using methods
		lp.password(pass);
		//click on login button using methods
		lp.loginClick();
	}
	@AfterMethod
	public static void logout()
	{
		HomePage og = new HomePage(driver);
		og.logout();
	}
	@AfterClass
	public static void postCondition()
	{
		driver.quit();
	}
	
}
