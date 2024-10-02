package utils;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelDataReader {

    public String [][] getExcelData(String fileLocation, String sheetName) throws IOException {
        String [][] data = null;
//        method body
        FileInputStream fs = new FileInputStream(fileLocation); 
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        int totalRows = sheet.getLastRowNum() + 1;
        int totalCells = sheet.getRow(0).getLastCellNum();
        for (int currentRow = 1; currentRow < totalRows; currentRow++ ){
            for (int currentCell=0; currentCell < totalCells; currentCell++){
                
            }
        }
        return data;
    }

}
