package excelUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriver {
	public ArrayList getData(String sampleNo) throws IOException {
		
		ArrayList dataList=new ArrayList<String>();
		FileInputStream fis=new FileInputStream("/Users/saranya.vazhampatta/eclipse-workspace/SearchResultsProject/src/main/java/testData/Cities_InputData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		int sheets=workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("cities")) {
				XSSFSheet sheet= workbook.getSheetAt(i); // sheet has all  info about "cities" sheet now
				// Identify the samples column by scanning entire 1st row
				Iterator<Row> rows= sheet.iterator(); // 'rows' will now have ability to iterate thru' all rows of our sheet
				Row firstRow=rows.next();
				Iterator<Cell> ce=firstRow.cellIterator();// 'ce' will now have ability to iterate thru' all cells of first row
				
				int k=0;
				int column=0;
				while(ce.hasNext()) {
					Cell value=ce.next(); //  Control moves to first cell of 1st row 
					if(value.getStringCellValue().equalsIgnoreCase("sampleNo")) {
						//We have now reached desired column
						column=k;
					}
					
					k++; // To get correct value of  column in which our sampleNo is
				}
				System.out.println(column); // Now we got column no where sampleNo is
				
				// Once column is identified, scan entire sampleNo column to identify sample1
				while(rows.hasNext()) {
					Row r=rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(sampleNo)) {
						// After grabbing "sample1" data row, pull all data from that row and feed into test.
						Iterator<Cell> cv=r.cellIterator();
						while(cv.hasNext()) {
							dataList.add(cv.next().getStringCellValue());
						}
						
					}
				}
			} // End if Loop
		} // End Main For Loop
		
		return dataList;
	}
}
