package com.crm.javautility;

import java.util.Random;

public class RandomNoGenerator 
{
	public static int generateNo()
	{
		 int number = new Random().nextInt(30);
		 
		 return number;
	}
}
