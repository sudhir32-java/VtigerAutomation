package com.crm.testCases;

import static org.testng.Assert.assertTrue;

import java.time.LocalDate;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.base.VTigerBase;
import com.crm.javautility.RandomDateGenerator;
import com.crm.pom.ContactPage;
import com.crm.pom.HomePage;

public class VtigerTest2 extends VTigerBase
{
	@Test
	public void tc001() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.contact();
		ContactPage ct = new ContactPage(driver);
		ct.plusButton();
		ct.lastName("XYZ");
		Thread.sleep(1000);
		
		LocalDate startDate = RandomDateGenerator.getStartDate();
		ct.startDate(startDate.toString());
		
		
		LocalDate endDate = RandomDateGenerator.getEndDate();
		ct.endDate(endDate.toString());
		
		System.out.println(endDate.toString());
		ct.save();
		
		
		String headerText = ct.getHeaderName(driver);
		assertTrue(headerText.contains("XYZ"),"Incorrect last name");
		Reporter.log("Correct Last name",true);
		
		String act_Start = ct.actStartDate();
		assertTrue(act_Start.contains(startDate.toString()),"Incorrect start date");
		Reporter.log("correct start date",true);
		
		
	
	}
}
