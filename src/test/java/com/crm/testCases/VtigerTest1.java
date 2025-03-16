package com.crm.testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.random.RandomGenerator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.base.VTigerBase;
import com.crm.fileUtility.ReadFromExcelFile;
import com.crm.javautility.RandomNoGenerator;
import com.crm.pom.HomePage;
import com.crm.pom.OrganisationPage;
@Listeners (com.crm.listeners.ExtentReport.class)
public class VtigerTest1 extends VTigerBase
{
	static int row = 0;
	
	@Test
	public void tc001() throws IOException, InterruptedException
	{
		String title = driver.getTitle();
		
		assertEquals(title,"Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM","Incorrect WebPage");
		Reporter.log("Correct WebPage",true);
		
		HomePage hp = new HomePage(driver);
		OrganisationPage og = new OrganisationPage(driver);
		hp.orgClick();
		og.plusClick();
		
		String org_name = ReadFromExcelFile.getdata(row,0);
		og.orgname(org_name+String.valueOf(RandomNoGenerator.generateNo()));
		
		og.userButton();
		WebElement dropdown = og.industrydropdown();
		String industryName = ReadFromExcelFile.getdata(row, 1);
		
		row++;
		Select sel = new Select(dropdown);
		sel.selectByVisibleText(industryName);
		
		og.save();
		
		String header_Text= og.getHeaderName(driver);
		
		assertTrue(header_Text.contains(org_name),"org Name does not match");
		Reporter.log("org name matched",true);
		String indus_name = og.getindustryName();
		assertEquals(indus_name,industryName ,"industry name does not match");
		Reporter.log("industry name matched",true);
			
	}
}
