import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public ArrayList<String> getData(String execute) throws IOException {
		
		FileInputStream fis = new FileInputStream("D:\\Testing\\Selenium\\Data\\test cases.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		ArrayList<String> arrList = new ArrayList<String>(); 
		
		int num = workbook.getNumberOfSheets();
		for (int i=0; i<num; i++) {
			//verify the name of sheet
			if(workbook.getSheetName(i).equalsIgnoreCase("test cases")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
			
				Iterator<Row> row = sheet.rowIterator();
				Row frow = row.next();
				Iterator<Cell> cell = frow.cellIterator();
				
				int tcIDColNum = 0;
				int tcNameColNum = 0;
				int descColNum = 0;
				int exColNum = 0;
				
				while(cell.hasNext()) {
					Cell header = cell.next();
					String colName =  header.getStringCellValue();
					//verify the column name
					if(colName.equalsIgnoreCase("TCID")) {
						tcIDColNum = header.getColumnIndex();
					} else
					if(colName.equalsIgnoreCase("Name")) {
						tcNameColNum = header.getColumnIndex();
					} else
					if(colName.equalsIgnoreCase("Desc")) {
						descColNum = header.getColumnIndex();
					} else
					if(colName.equalsIgnoreCase("Execute")) {
						exColNum = header.getColumnIndex();
						System.out.println("Column no.: " + exColNum + " contains name: " + header.getStringCellValue());
						//break;
					}	
				}
				
				while(row.hasNext()) {
					Row r = row.next();
					if(r.getCell(exColNum).getStringCellValue().equalsIgnoreCase(execute)) {
						//String testCase = r.getCell(tcNameColNum).getStringCellValue();
						//System.out.println(testCase);
						Iterator<Cell> cv = r.cellIterator();
						while(cv.hasNext()) {
							Cell c = cv.next();
							
							if(c.getCellTypeEnum()==CellType.STRING) {
								arrList.add(c.getStringCellValue());
							} else
							if(c.getCellTypeEnum()==CellType.NUMERIC) {
								arrList.add(String.valueOf((c.getNumericCellValue())));
							}
							else {
								arrList.add("Null");
							}
							
						}
						
					}
					
				}
				
			}
		}	
		return arrList;	
	}

}
