package es.uniovi.asw;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Main application
 * 
 * @author Labra
 *
 */
public class LoadUsers {

	public static void main(String... args) {
		final LoadUsers runner = new LoadUsers();
		try {
			runner.run(args);
		} catch (Exception e) {
			System.err.println("Fallo");
		}
	}

	// TODO
	@SuppressWarnings("deprecation")
	void run(String... args) throws Exception {
		File myFile = new File("test.xlsx");
		FileInputStream fis = new FileInputStream(myFile);
		// Finds the workbook instance for XLSX file
		XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
		// Return first sheet from the XLSX workbook
		XSSFSheet mySheet = myWorkBook.getSheetAt(0);
		// Get iterator to all the rows in current sheet
		Iterator<Row> rowIterator = mySheet.iterator();
		// Traversing over each row of XLSX file
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			// For each row, iterate through each columns
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					System.out.print(cell.getStringCellValue() + " - ");
					break;
				case Cell.CELL_TYPE_NUMERIC:
					System.out.print(cell.getNumericCellValue() + " - ");
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					System.out.print(cell.getBooleanCellValue() + " - ");
					break;
				default:
				}
			}
			System.out.println("");
		}
		myWorkBook.close();
	}
}
