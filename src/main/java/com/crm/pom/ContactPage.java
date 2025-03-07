package com.crm.pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage 
{
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath ="//img[@alt='Create Contact...']")
	private WebElement plus_button;
	@FindBy (name ="lastname")
	private WebElement lastName;
	@FindBy (id ="jscal_field_support_start_date")
	private WebElement startDate;
	@FindBy (id = "jscal_field_support_end_date")
	private WebElement endDate;
	@FindBy (xpath ="//input[@title='Save [Alt+S]']")
	WebElement save;
	@FindBy (className ="dvHeaderText")
	private WebElement header;
	
	@FindBy(id ="dtlview_Support Start Date")
	private WebElement actStartDate;
	@FindBy(id ="dtlview_Support End Date")
	private WebElement actEndDate;
	
	public void plusButton()
	{
		plus_button.click();
	}
	public void lastName(String data)
	{
		lastName.sendKeys(data);
	}
	public void startDate(String data) throws InterruptedException
	{
		startDate.sendKeys(data);
		Thread.sleep(2000);
	}
	public void endDate(String data) throws InterruptedException
	{
		endDate.sendKeys(data);
		
	}
	public void save()
	{
		save.click();
	}
	public String getHeaderName(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(header));
		return header.getText();
	}
	public String actStartDate()
	{
		return actStartDate.getText();
	}
	public String actEndDate()
	{
		return actEndDate.getText();
	}
	
}
