package common.utils;


//public class TestData {
//}

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class TestData {

//    private static final String FILE_NAME = "venzo_TestData.xlsx";
    Iterator<Row> iterator;

    public TestData(String strWorkBookPath,String strSheetName) throws IOException {
        FileInputStream excelFile = new FileInputStream(new File(strWorkBookPath));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet datatypeSheet = workbook.getSheetAt(0);
        iterator = datatypeSheet.iterator();
    }

    public Iterator<Row> getRows(){
        return iterator;
    }

//    public static void main(String[] args) throws IOException {
//
//
//
//        try {
//
//            while (iterator.hasNext()) {
//
//                Row currentRow = iterator.next();
//
//                System.out.println(currentRow.getRowNum());
//                Iterator<Cell> cellIterator = currentRow.iterator();
//
//                while (cellIterator.hasNext()) {
//                    Cell currentCell = cellIterator.next();
//                    if(currentRow.getRowNum()!=0){
//                        System.out.println(currentCell.getStringCellValue().trim());
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
}
