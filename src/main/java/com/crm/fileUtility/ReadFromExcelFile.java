package com.crm.fileUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFromExcelFile 
{
	public static  String getdata(int row , int col) throws IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\VtigerData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("Sheet1");
		
		return sh.getRow(row).getCell(col).toString();
	}
}
