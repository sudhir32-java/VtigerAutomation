package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath ="//input[@name='user_name']")
	private WebElement username_field;
	
	@FindBy (xpath ="//input[@name='user_password']")
	private WebElement password_field;
	
	@FindBy (id ="submitButton")
	private WebElement login;
	
	public void username(String data)
	{
		username_field.sendKeys(data);
	}
	
	public void password(String data)
	{
		password_field.sendKeys(data);
	}
	
	public void loginClick()
	{
		login.click();
	}
}
