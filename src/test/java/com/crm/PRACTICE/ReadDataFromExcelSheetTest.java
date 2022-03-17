package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadDataFromExcelSheetTest {
	@Test
	public void readDataFromExcelSheetTest() throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		 String text = wb.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();
		 System.out.println(text);
	}

}
