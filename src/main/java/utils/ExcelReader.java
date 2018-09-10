package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

	public static String[][] readTestData(String file, String sheetName) {
		FileInputStream fis = null;
		Workbook wb = null;
		try {
			fis = new FileInputStream(new File(file));
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}

		Sheet sh = wb.getSheet(sheetName);

		int rowCnt = sh.getLastRowNum();
		int colCnt = sh.getRow(0).getLastCellNum();
		String data[][] = new String[rowCnt][colCnt];
		
		for(int i=0;i<rowCnt;i++) {
			for(int j=0;j<colCnt;j++) {
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
}
