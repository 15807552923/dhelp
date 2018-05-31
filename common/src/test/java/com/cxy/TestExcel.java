package com.cxy;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class TestExcel {

    // 读取，全部sheet表及数据
    @Test
    public void showExcel() throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File("C:/Users/admin/Desktop/celltest.xlsx")));
        XSSFSheet sheet = null;
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {// 获取每个Sheet表
            sheet = workbook.getSheetAt(i);
            for (int j = 0; j < sheet.getLastRowNum() + 1; j++) {// getLastRowNum，获取最后一行的行标
                XSSFRow row = sheet.getRow(j);
                if (row != null) {
                    for (int k = 0; k < row.getLastCellNum(); k++) {// getLastCellNum，是获取最后一个不为空的列是第几个
                        if (row.getCell(k) != null) { // getCell 获取单元格数据
                            System.out.print("k:"+k+";"+row.getCell(k) + "\t");
                        } else {
                            System.out.print("\t");
                        }
                    }
                }
                System.out.println(""); // 读完一行后换行
            }
            System.out.println("读取sheet表：" + workbook.getSheetName(i) + " 完成");
        }
    }

    // 读取，指定sheet表及数据
    @Test
    public void showExcel2() throws Exception {
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(new File("E:/temp/t1.xls")));
        HSSFSheet sheet = null;
        int i = workbook.getSheetIndex("xt"); // sheet表名
        sheet = workbook.getSheetAt(i);
        for (int j = 0; j < sheet.getLastRowNum() + 1; j++) {// getLastRowNum
            // 获取最后一行的行标
            HSSFRow row = sheet.getRow(j);
            if (row != null) {
                for (int k = 0; k < row.getLastCellNum(); k++) {// getLastCellNum
                    // 是获取最后一个不为空的列是第几个
                    if (row.getCell(k) != null) { // getCell 获取单元格数据
                        System.out.print(row.getCell(k) + "\t");
                    } else {
                        System.out.print("\t");
                    }
                }
            }
            System.out.println("");
        }
    }

    // 写入，往指定sheet表的单元格
    @Test
    public void insertExcel3() throws Exception {
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(new File("E:/temp/t1.xls"))); // 读取的文件
        HSSFSheet sheet = null;
        int i = workbook.getSheetIndex("xt"); // sheet表名
        sheet = workbook.getSheetAt(i);

        HSSFRow row = sheet.getRow(0); // 获取指定的行对象，无数据则为空，需要创建
        if (row == null) {
            row = sheet.createRow(0); // 该行无数据，创建行对象
        }

        Cell cell = row.createCell(1); // 创建指定单元格对象。如本身有数据会替换掉
        cell.setCellValue("tt"); // 设置内容

        FileOutputStream fo = new FileOutputStream("E:/temp/t1.xls"); // 输出到文件
        workbook.write(fo);

    }



    @Test
    public void reduce() {
        int[] count = new int[17];
        for(int i=0 ;i<100000;i++) {
            Integer[] vecData =test();
           for(int index :vecData){
               count[index] =count[index]+1;
           }

        }
        for(int sum :count){
            System.out.print(sum+";");
        }
    }

    //平均抽取算法---------------------222
    public  Integer[] test(){
        int m=2;
        List<Integer> vals = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
        Iterator iterator = vals.iterator();
        Integer[] vecData = new Integer[m];
        int nCurrentIndex = 0;
        while(iterator.hasNext()){
            Integer tValue = (Integer) iterator.next();
            if(nCurrentIndex < m){
                vecData[nCurrentIndex] = tValue;
            }
            else if(frand() < (float)m / (nCurrentIndex+1)) {
                int nReplaceIndex = (int)(frand() * m);
                vecData[nReplaceIndex] = tValue;
            }
            nCurrentIndex ++;
        }
        return  vecData;
    }


    public double frand(){
        Random rand = new Random();
        return  Math.random();
    }


}