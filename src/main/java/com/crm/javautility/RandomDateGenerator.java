package com.crm.javautility;

import java.time.LocalDate;

import java.util.Random;

public class RandomDateGenerator
{
	public static LocalDate getStartDate()
	{	
	 return LocalDate.now();
	}
	
	public static LocalDate getEndDate()
	{
		int days = new Random().nextInt(30)+1;
		
		return getStartDate().plusDays(days);
		
	}
}
