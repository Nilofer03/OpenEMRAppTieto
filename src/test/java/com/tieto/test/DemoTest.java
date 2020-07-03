package com.tieto.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DemoTest {
	
/*	public Object[][] fillFormData()
	{
		Object[][] main = new Object [3][2];
		main[0][0] = "john";
		
		return main;
		
	}
	
	@Test
	public void  fillFormTest(String username, String password)
	{
		System.out.println(username+password);
	} */
	@Test
	public void excelRead() throws IOException
	{
		FileInputStream file = new FileInputStream ("testdata/OpenEMRData.xlsx");
		
		XSSFWorkbook book = new XSSFWorkbook(file);
		
		XSSFSheet sheet = book.getSheet("validCretendtialData");
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow rowCheck=sheet.getRow(0);
		int cellCount=rowCheck.getPhysicalNumberOfCells();
		//System.out.println(rowCount);
		//XSSFRow rowCheck=sheet.getRow(0);
		//int cellCount = rowCheck.getPhysicalNumberOfCells();
		//System.out.println(cellCount);

		
		for (int r = 0; r < rowCount; r++)
		{
			XSSFRow  row = sheet.getRow(r);
			for (int c=0; c>cellCount; c++)
			{
				XSSFCell  cell = row.getCell(c);
				DataFormatter format = new DataFormatter ();
				String cellValue  = format.formatCellValue(cell);
				System.out.println(cellValue);
				
			}
			
			
		}
		
		
		book.close();
		file.close();
		
		
	}

}
