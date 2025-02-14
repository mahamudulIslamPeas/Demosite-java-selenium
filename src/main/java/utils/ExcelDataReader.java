package utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelDataReader {
    public static void main(String[] args) throws IOException {
        System.out.println(getExcelData("Web"));
    }

    public static ArrayList<String> getExcelData(String sheetName) throws IOException {

        ArrayList<String>testData = new ArrayList<String>();
        String path = System.getProperty("user.dir")+"//TestData//TestData.xlsx";
        System.out.println(path);
        FileInputStream fs = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        String sheetNameString = sheet.getSheetName();
        System.out.println(sheetNameString);

        int sheetCount  = workbook.getNumberOfSheets();
        System.out.println(sheetCount);


        int totalRows = sheet.getLastRowNum() + 1;

        int totalCells = sheet.getRow(0).getLastCellNum();
//        for (int currentRow = 1; currentRow < totalRows; currentRow++ ){
//            for (int currentCell=0; currentCell < totalCells; currentCell++){
//
//            }
//        }
        // Access Sheet by Index
        for (int i=0; i < sheetCount ; i++){
            if (workbook.getSheetName(i).equalsIgnoreCase("Web")){
                XSSFSheet excelSheet = workbook.getSheetAt(i);
                System.out.println("Sheet Name by Index: "+ excelSheet.getSheetName());
            }
        }

        String columnName = "Scenario";
        Iterator<Row> rowsObject = sheet.iterator();
        Row firstRow = rowsObject.next();
        Iterator<Cell>  cellObject = firstRow.cellIterator();
        int k = 0;
        int columnIndex=0;
        while (cellObject.hasNext()) {
            Cell cellValue = cellObject.next();
            if ( cellValue.getStringCellValue().equalsIgnoreCase(columnName)){
                System.out.println("Column Header Name from excel: "+cellValue.getStringCellValue());
                columnIndex = k;
            }
            k++;
        }
        System.out.println("Targeted Column Index: " + columnIndex);
        while (rowsObject.hasNext()){
            Row r = rowsObject.next();
            if(r.getCell(columnIndex).getStringCellValue().equalsIgnoreCase("Login")){
                Iterator<Cell> cv = r.cellIterator();
                while (cv.hasNext()){
                    testData.add(cv.next().getStringCellValue());
                }
            }
        }
        return testData;
    }

}
