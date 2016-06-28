package stancu.Main;

import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.Number;


import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Stefan on 2015-03-15.
 */
public class ExcelReader {
    static String file = "Krispy Kreme Sales.xls";


    static DateFormat customDateFormat = new DateFormat("dd MM yyyy hh:mm:ss");
    static WritableCellFormat dateFormat = new WritableCellFormat(customDateFormat);

    public static void log(){

        try {
            File f = new File(file);
            if(!f.exists()){
                WritableWorkbook workbook = Workbook.createWorkbook(f);
                WritableSheet sheet = workbook.createSheet("Sheet 1", 0);
                Label timeStamp = new Label(3,1,"Time Stamp");
                Label totalSales = new Label(7,1," Total Inventory Sold");
                Label singleD = new Label(4,1,"Donuts");
                Label boxD = new Label(6,1,"Boxes");
                Label order = new Label(2,1,"Order");
                Label fivesD = new Label(5,1,"Half-Box");

                sheet.addCell(timeStamp);
                sheet.addCell(order);
                sheet.addCell(totalSales);
                sheet.addCell(singleD);
                sheet.addCell(boxD);
                sheet.addCell(fivesD);
                workbook.write();
                workbook.close();
            }
            Workbook workbook = Workbook.getWorkbook(f);
            WritableWorkbook copy = Workbook.createWorkbook(f, workbook);

            WritableSheet sheet = copy.getSheet(0);

            int rowIndex = sheet.getColumn(3).length;

            Date date = new Date();
            DateTime dateTime = new DateTime(3,rowIndex,date,dateFormat);
            sheet.addCell(dateTime);
            Number dSales = new Number(4, rowIndex, Main.orderDonuts);
            Number bSales = new Number(6,rowIndex,Main.orderBox);
            Number fSales = new Number(5,rowIndex,Main.orderFives);
            sheet.addCell(dSales);
            sheet.addCell(bSales);
            sheet.addCell(fSales);
            Number totalSales = new Number(7,rowIndex,(Main.singleSales+12*Main.boxSales+6*Main.fiveSales));
            sheet.addCell(totalSales);

            Number order = new Number(2,rowIndex,Main.ordernum);
            sheet.addCell(order);

            copy.write();
            copy.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }
    }


    public static int getSales(String type){
        int sales = 0;
        int column = 0;
        if (type.equals("Donut"))
            column=4;
        else if (type.equals("Fives"))
        column=5;
        else
        column=6;
        File f = new File(file);
        if(f.exists()&&!f.isDirectory()) {
            try {
                Workbook workbook = Workbook.getWorkbook(f);
                Sheet sheet = workbook.getSheet(0);

                int length = sheet.getColumn(column).length;
                if(length>=3){
                    for (int i = 2; i <length ; i++) {
                        Cell cell = sheet.getCell(column,i);
                        sales+= Integer.parseInt(cell.getContents());
                    }
                }
                else {
                    sales = 0;
                }
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (BiffException e) {
                e.printStackTrace();
            }
        }

        return sales;
    }

    public static int getOrder(){
        int i = 0;

        File f = new File(file);
        if(f.exists()&&!f.isDirectory()) {
            try {
                Workbook workbook = Workbook.getWorkbook(f);
                Sheet sheet = workbook.getSheet(0);

                i  = sheet.getColumn(2).length-2;

                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (BiffException e) {
                e.printStackTrace();
            }
        }

        return i;
    }

}
