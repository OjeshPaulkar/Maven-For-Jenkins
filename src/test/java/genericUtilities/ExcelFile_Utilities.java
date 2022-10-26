package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelFile_Utilities {

	

	   /**
	    *   its used to read the data from Excel-Workbook based on below 
	    * @param sheetName
	    * @param rowNum
	    * @param celNum
	    * @return String data

	 * @throws Throwable
	    */
		

		public String getExcelData(String sheetName , int rowNum , int celNum) throws Throwable  {
			FileInputStream fis = new FileInputStream("./TestData/Book1.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(rowNum);
			String data = row.getCell(celNum).getStringCellValue();
			return data;	
		}
		
		
		
		
		/**
		 * used to get the last used row number on specified Sheet
		 * @param sheetName
		 * @return
		 * @throws Throwable
		 */
		public int getRowCount(String sheetName) throws Throwable {
			FileInputStream fis  = new FileInputStream("./TestData/Book1.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			//wb.close();
			return sh.getLastRowNum();
		}
		
		
		public String[] getAllCellDataOfOneRow(String sheetName, int rowNumber ) throws EncryptedDocumentException, IOException
		
		{
			FileInputStream fis=new FileInputStream("./TestData/Book1.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			String[] data=new String[getExcelCells(sheetName,rowNumber)];
				for(int j=0;j<getExcelCells(sheetName,rowNumber);j++)
				{
					data[j] = wb.getSheet("Sheet1").getRow(rowNumber).getCell(j).getStringCellValue();
				}
			return data;
		}
		
		
		private int getExcelCells(String sheetName, int rowNumber) throws EncryptedDocumentException, IOException 
		  {
		
			FileInputStream fis=new FileInputStream("./TestData/Book1.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			short lastCellNum = wb.getSheet(sheetName).getRow(rowNumber).getLastCellNum();
			return lastCellNum;
		  }
		
		
		
		/**
		 * used to write data back to Excel based on below parameter
		 * @param sheetName
		 * @param rowNum
		 * @param celNum
		 * @param data
		 * @throws Throwable
		 */
		public void setDataExcel(String sheetName , int rowNum, int celNum ,String data) throws Throwable 
		{
			FileInputStream fis  = new FileInputStream(IConstants.EXCELPATH);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(rowNum);
			Cell cel = row.createCell(celNum);
			cel.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(IConstants.EXCELPATH);
			wb.write(fos);
			wb.close();
			
		}

	

	
}
