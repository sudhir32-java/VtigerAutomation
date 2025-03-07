package com.crm.pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrganisationPage 
{
	public OrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath ="//img[@alt='Create Organization...']")
	private WebElement plus_Symbol;
	@FindBy (xpath = "//input[@name='accountname']")
	private WebElement org_name;
	@FindBy (xpath = "(//input[@name='assigntype'])[1]")
	private WebElement user_button;
	@FindBy (xpath = "(//input[@name='assigntype'])[2]")
	private WebElement group_button;
	@FindBy (name = "industry")
	private WebElement dropdown;
	@FindBy (className ="dvHeaderText")
	private WebElement header;
	@FindBy (xpath = "//input[@title='Save [Alt+S]']")
	private WebElement save;
	@FindBy (xpath ="//span[@id='dtlview_Industry']/font")
	private WebElement ind_name;
	
	
	public void plusClick()
	{
		plus_Symbol.click();
	}
	public void orgname(String data)
	{
		org_name.sendKeys(data);
	}
	public void userButton()
	{
		user_button.click();
	}
	public void groupButton()
	{
		group_button.click();
	}
	
	public WebElement industrydropdown()
	{
		return dropdown;
	}
	public String getHeaderName(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(header));
		
		return header.getText();
	}
	public String getindustryName()
	{
		return ind_name.getText();
	}
	public void save()
	{
		save.click();
	}
}
