package com.workday.readData;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @FunctionName : Reading The data from the excel sheet
 * @Description  : Fetching value from each from row using the excel sheet.
 * @CreationDate : 17-09-2024
 * @author       : 
 */


public class Excel_readData {
static Workbook WB;
static Sheet sheet;



public static Object[][] ReadData(String sheetName ,String FileLocation) throws IOException, InvalidFormatException {

//// Open the Excel file
try (FileInputStream file = new FileInputStream(
		FileLocation)) {
	Workbook workbook = WorkbookFactory.create(file);

	// Get the specified sheet
	org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet(sheetName);

	if (sheet == null) {
		throw new IllegalArgumentException("Sheet not found: " + sheetName);
	}

	// Determine the number of rows and columns
	int numRows = sheet.getLastRowNum() + 1; // Add 1 for zero-based indexing
//	System.out.println(numRows);
	int numCols = sheet.getRow(0).getLastCellNum();

	// Create a two-dimensional array to store the data
	Object[][] data = new Object[numRows][numCols];

	// Create a DataFormatter for efficient cell value retrieval
	DataFormatter formatter = new DataFormatter();

	// Iterate through rows and columns, handling potential null cells
	for (int i = 1; i < numRows; i++) {
//		System.out.println(i);
		Row row = sheet.getRow(i);
		if (row == null) {
			// Handle empty rows by filling with nulls
			for (int j = 0; j < numCols; j++) {
				data[i][j] = null;
			}
			continue;
		}

		for (int j = 0; j < numCols; j++) {
			Cell cell = row.getCell(j);
			if (cell != null) {
				data[i][j] = formatter.formatCellValue(cell);
				 //System.out.println("Row " + (i+1) + ", Column " + (j+1) + ": " +data[i][j]);
			} else {
				data[i][j] = null; // Set null for missing cells
				 //System.out.println(data[i][j]);
			}
		}
	}
	return data;
}
}
}
