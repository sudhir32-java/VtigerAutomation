package com.crm.pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage
{
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (xpath="//img[@style='padding: 0px;padding-left:5px']")
	private WebElement profile;
	@FindBy (linkText="Sign Out")
	private WebElement logout;
	@FindBy (linkText = "Organizations")
	private WebElement org;
	

	public void orgClick()
	{
		org.click();
	}
	public void logout()
	{
		profile.click();
		logout.click();
	}
}
