package com.kirwa.webdriver.main;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Administrator on 9/23/14.
 */
public class DriverScript {
    static FileInputStream file;// = new FileInputStream(new File("TestSuite.xlsx"));
    static XSSFWorkbook workbook;// = new XSSFWorkbook(file);

    public static void main(String[] args) throws Exception{
        file = new FileInputStream(new File("TestSuite.xlsx"));
        workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Main");
        Iterator<Row> MySuites = sheet.rowIterator();
        MySuites.next();
        while(MySuites.hasNext()){
            Row suite = MySuites.next();
            if(suite.getCell(1).getBooleanCellValue())
            {
                System.out.println("Executing Test Suite" + suite.getCell(0).getStringCellValue());
                ExecuteTestSuite(suite.getCell(0).getStringCellValue());
            }
        }
        file.close();
    }

    private static void ExecuteTestSuite(String SuiteName) throws Exception {
        XSSFSheet tcSheet = workbook.getSheet(SuiteName);
        Iterator<Row> steps = tcSheet.iterator();
        steps.next();
        while(steps.hasNext()){
            Row step = steps.next();
            if(!step.getCell(0).getStringCellValue().equals("")){
                System.out.println("TestCase Started : " + step.getCell(0).getStringCellValue());
            }
            HashMap<String,String> inputList = new HashMap<String,String>();
            try{
                String[] inputs = step.getCell(4).getStringCellValue().split(",");

                for(int i = 8;i<8+inputs.length;i++){
                    inputList.put(inputs[i-8],step.getCell(i).getStringCellValue());
                }
            }catch(Exception e){System.out.println("Keyword not need inputs ");}
            ExecuteKeyWord(step.getCell(3).getStringCellValue(),inputList);

        }

    }

    private static void ExecuteKeyWord(String KeyWord,HashMap<String,String> inputList) throws Exception {
        XSSFSheet kwSheet = workbook.getSheet("Keywords");
        Iterator<Row> keywords = kwSheet.iterator();
        keywords.next();
        while(keywords.hasNext()){
            Row kwrow = keywords.next();
            if(kwrow.getCell(0).getStringCellValue().equals(KeyWord)){
                Class<?> cl = Class.forName(kwrow.getCell(1).getStringCellValue());
                Method m = cl.getMethod(kwrow.getCell(0).getStringCellValue(),inputList.getClass());
                m.invoke(m, inputList);
            }
        }

    }
}
