/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsiit.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author salisu14
 */
public class ExcelExporter {

    public ArrayList<Object[]> getTableData() throws DBException {
        ArrayList<Object[]> tableDataList = null;
        Connection con = DBUtil.getConnection();
        String query = "SELECT * FROM student";
        if (con != null) {
            try (PreparedStatement ps = con.prepareStatement(query);
                    ResultSet result = ps.executeQuery()) {
                tableDataList = new ArrayList<>();
                while (result.next()) {
                    Object[] objArray = new Object[9];
                    objArray[0] = result.getString(1);
                    objArray[1] = result.getString(2);
                    objArray[2] = result.getString(3);
                    objArray[3] = result.getString(4);
                    objArray[4] = result.getString(5);
                    objArray[5] = result.getString(6);
                    objArray[6] = result.getInt(7);
                    objArray[7] = result.getString(8);
                    objArray[8] = result.getString(9);
                    tableDataList.add(objArray);
                }
            } catch (SQLException e) {
                System.out.println("Unable to create PreparedStatement");
                System.err.println(e.toString());
            }
        }
        return tableDataList;
    }

    public void doExport(ArrayList<Object[]> dataList) {
        if (dataList != null && !dataList.isEmpty()) {
            HSSFWorkbook workBook = new HSSFWorkbook();
            HSSFSheet sheet = workBook.createSheet();
            HSSFRow headingRow = sheet.createRow(0);
            headingRow.createCell((short) 0).setCellValue("Jamb Number");
            headingRow.createCell((short) 1).setCellValue("First Name");
            headingRow.createCell((short) 2).setCellValue("Last Name");
            headingRow.createCell((short) 3).setCellValue("Middle Name");
            headingRow.createCell((short) 4).setCellValue("Gender");
            headingRow.createCell((short) 5).setCellValue("State");
            headingRow.createCell((short) 6).setCellValue("Aggregate");
            headingRow.createCell((short) 7).setCellValue("Course");
            headingRow.createCell((short) 8).setCellValue("Local Govt");
            short rowNo = 1;
            for (Object[] objects : dataList) {
                HSSFRow row = sheet.createRow(rowNo);
                row.createCell((short) 0).setCellValue(objects[0].toString());
                row.createCell((short) 1).setCellValue(objects[1].toString());
                row.createCell((short) 2).setCellValue(objects[2].toString());
                row.createCell((short) 3).setCellValue(objects[3].toString());
                row.createCell((short) 4).setCellValue(objects[4].toString());
                row.createCell((short) 5).setCellValue(objects[5].toString());
                row.createCell((short) 6).setCellValue(objects[6].toString());
                row.createCell((short) 7).setCellValue(objects[7].toString());
                row.createCell((short) 8).setCellValue(objects[8].toString());
                rowNo++;
            }
            // Create a local time to append to the file name
            LocalTime now = LocalTime.now();
            String file = "./Student_details" + "_" + now.getNano() + ".xls";
            try {
                FileOutputStream fos = new FileOutputStream(file);
                workBook.write(fos);
                fos.flush();
            } catch (FileNotFoundException e) {
                System.out.println("Invalid directory or file not found");
            } catch (IOException e) {
                System.out.println("Error occurred while writting excel file to directory");
            }
        }
    }
/*
    public static void main(String[] args) throws DBException {
        ExcelExporter exporter = new ExcelExporter();
        ArrayList<Object[]> dataList = exporter.getTableData();
        if (dataList != null && dataList.size() > 0) {
            exporter.doExport(dataList);
        } else {
            System.out.println("There is no data available in the table to export");
        }
    }
*/
}
