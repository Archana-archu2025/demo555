package com.comcast.crm.generic.fileutiity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class execelsheetutility {
    
	public String getdatafromexcelsheet(String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("C:\\\\Users\\\\santhosh\\\\eclipse-workspace\\\\teypyramidpractice\\\\src\\\\test\\\\resources\\\\TestData2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		wb.close();
		return data;
	}
	
	public int getlastrow(String sheet) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\santhosh\\eclipse-workspace\\teypyramidpractice\\src\\test\\resources\\TestData2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int lastrow = wb.getSheet(sheet).getLastRowNum();
		return lastrow;
		
	}
	public int getlastcell(String sheet, int row) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("C:\\\\Users\\\\santhosh\\\\eclipse-workspace\\\\teypyramidpractice\\\\src\\\\test\\\\resources\\\\TestData2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int lastcell = wb.getSheet(sheet).getRow(row).getLastCellNum();
		return lastcell;
		
	}
	
	
	public void setdataintoexcelsheet(String sheet, int row, int cell,String cellvalue) throws EncryptedDocumentException, IOException {
		
String filePath = "C:\\Users\\santhosh\\eclipse-workspace\\teypyramidpractice\\src\\test\\resources\\TestData2.xlsx"; // Local path
        
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook wb = WorkbookFactory.create(fis);
             FileOutputStream fos = new FileOutputStream(filePath)) {
             Sheet sheet1 = wb.getSheet (sheet);
            if (sheet1 == null) {
                sheet1 = wb.createSheet(sheet);
            }
            Row row1 = sheet1.getRow(row);
            if (row1 == null) {
                row1 = sheet1.createRow(row);
            }
            Cell cell1 = row1.createCell(cell); 
            cell1.setCellValue(cellvalue); 
            wb.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
}
