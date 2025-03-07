package com.crm.fileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadFromProperties 
{
	public static String getData(String data) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\VtigerLogin.properties");
		
		prop.load(fis);
		
		return prop.getProperty(data);
	}
}
