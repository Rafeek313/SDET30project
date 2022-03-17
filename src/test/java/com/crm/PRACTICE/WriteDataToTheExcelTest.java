package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class WriteDataToTheExcelTest {
@Test
public void writeDataToTheExcelTest() throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	 Row row = wb.getSheet("Sheet1").getRow(0);
	 Cell ce = row.createCell(1);
	 ce.setCellValue("OrgName");
	FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\Data.xlsx");
	wb.write(fos);

	
}
}
