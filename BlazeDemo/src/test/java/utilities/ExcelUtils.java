package utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static Object[][] getExcelData(String filePath, String sheetName) {
	    try (FileInputStream fis = new FileInputStream(filePath);
	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
	    	
	        XSSFSheet sheet = workbook.getSheet(sheetName);
	        int rowCount = sheet.getLastRowNum();
	        int cellCount = sheet.getRow(0).getLastCellNum();

	        Object[][] data = new Object[rowCount][cellCount];
	        DataFormatter formatter = new DataFormatter();
	        for (int i = 1; i <= rowCount; i++) {
	            for (int j = 0; j < cellCount; j++) {
	                data[i - 1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
	            }
	        }
	        return data;
	    } catch (Exception e) {
	        throw new RuntimeException("Unable to read excel data", e);
	    }
	}
}