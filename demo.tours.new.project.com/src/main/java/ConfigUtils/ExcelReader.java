package ConfigUtils;

import java.io.File;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.testng.annotations.Test;

public class ExcelReader {
	
	private XSSFWorkbook wb = null;
	
	private XSSFSheet sheet1 = null;
	
	private File f1 = null;
		
	public String getExcelData(String path, int index, int cell, int column) { 
	
	f1 = new File(path);
	
	wb = new XSSFWorkbook();
	
	sheet1 = wb.getSheetAt(index);
	
	String s1 = sheet1.getRow(cell).getCell(column).getStringCellValue();
	
	return s1;	
	
	}
		
}
