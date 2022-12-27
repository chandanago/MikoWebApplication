package com.miko.genericLibrary;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility  {
	PropertiesClass property = new PropertiesClass();
	
	/**
	 * This method is used to read data from Excel based on below parameters
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return String 
	 */
	public String readDataFromExcel(String sheetName,int rowNo,int cellNo)  {
		File absPath = new File(property.readDataFromProperty("EXCELDATA_PATH"));
		Workbook wrkbook=null;
		try {
			FileInputStream fis= new FileInputStream(absPath);
			wrkbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wrkbook.getSheet(sheetName).getRow(rowNo).getCell(cellNo).toString();
	}

	/**
	 * This method is used to get count of rows in a particular Sheet
	 * @param sheetName
	 * @return int
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) {
		Workbook wrkbook=null;
		try {
			FileInputStream fis=new FileInputStream(property.readDataFromProperty("EXCELDATA_PATH"));

			wrkbook=WorkbookFactory.create(fis);
		}
		catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wrkbook.getSheet(sheetName).getLastRowNum();
	}


	/**
	 * This method is used to get count of cells in a particular Sheet
	 * @param sheetName
	 * @return int
	 * @throws Throwable
	 */
	public int getCellCount(String sheetName) throws Throwable
	{
		Workbook wrkbook=null;
		try {
			FileInputStream fis=new FileInputStream(property.readDataFromProperty("EXCELDATA_PATH"));

			wrkbook=WorkbookFactory.create(fis);
		}
		catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return wrkbook.getSheet(sheetName).getRow(0).getLastCellNum();
	}


	/**
	 * This method is used to write data to excel file
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param data
	 * @throws Throwable
	 */
	public void setDataToExcel(String sheetName,int row,int cell,String data) 
	{

		Workbook wrkbook=null;
		try {
			FileInputStream fis=new FileInputStream(property.readDataFromProperty("EXCELDATA_PATH"));

			wrkbook=WorkbookFactory.create(fis);
		}
		catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Sheet sheet=wrkbook.getSheet(sheetName);
		sheet.getRow(row).getCell(cell).setCellValue(data);


		FileOutputStream fos;
		try {
			fos = new FileOutputStream(property.readDataFromProperty("EXCELDATA_PATH"));
			wrkbook.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * This method is used to read data from excel file and provide data for DataProvider
	 * @param sheetName
	 * @return Object[][]
	 * @throws Throwable
	 * @throws Throwable
	 */
	public Object[][] getDataUsingDataProvider(String sheetName) 
	{

		Workbook wrkbook=null;
		try {
			FileInputStream fis=new FileInputStream(property.readDataFromProperty("EXCELDATA_PATH"));

			wrkbook=WorkbookFactory.create(fis);
		}
		catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Sheet sheet = wrkbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		int cellCount=sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[rowCount][cellCount];
		for(int i=1;i<rowCount;i++) {
			for(int j=0;j<cellCount;j++)
			{
				data[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
}
