package demotesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class working_with_excelsheet_basedoncondition {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("C:\\Users\\santhosh\\eclipse-workspace\\teypyramidpractice\\Testdata\\TestData2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int row=wb.getSheet("Sheet1").getLastRowNum();
		System.out.println(row);
		for(int i=0;i<=row;i++) {
			try {
				String data = wb.getSheet("Sheet1").getRow(i).getCell(0).toString();
				if (data.contains("001")) {
					 String da = wb.getSheet("Sheet1").getRow(i).getCell(1).toString();
					 String da1 = wb.getSheet("Sheet1").getRow(i).getCell(2).toString();
					 System.out.println(da);
					 System.out.println(da1);
					 
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		
		}

	}

}
