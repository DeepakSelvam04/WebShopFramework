package genricLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class FileUtility implements FrameworkConstants{
	public static String getProperty(String key) {
		
		//Step 1: Get the java representation object of the physical file using "FileInputStream"
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(PROPERTY_FILE_PATH);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//Step 2: Create a object of "Properties" class & load all the keys
		Properties p=new Properties();
		try {
			p.load(fis);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//Step 3:Read the data using getProperty("key")
		return p.getProperty(key);
		
		
	}
		
		//public static void readDataFromExcel() throws EncryptedDocumentException, IOException {
		public static String readCellDataFromExcel(String sheet,int row,int cell) throws EncryptedDocumentException, IOException {
			//Step 1: Get the java representation of excel file
			FileInputStream fis=new FileInputStream(EXCEL_PATH);
			
//			Workbook book=WorkbookFactory.create(fis);
//			
//			Sheet sheet=book.getSheet("Seet1");
//			
//			Row row=sheet.getRow(3);
//			
//			System.out.println(row.getCell(4));
			
			//Reading the data from cell using method chaining
			return WorkbookFactory.create(fis).getSheet("seet1").getRow(row).getCell(cell).toString();
		}
		
		public static String[][] readRowDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException {
			//Step 1: Get the java representation of excel file
			FileInputStream fis=new FileInputStream("./Resource/Register.xlsx");
			
			Workbook book=WorkbookFactory.create(fis);
			
      		Sheet sheet=book.getSheet(sheetName);
            
      		int rowCount=sheet.getPhysicalNumberOfRows();
      		
      		int cellCount=sheet.getRow(0).getPhysicalNumberOfCells();
      		
      		String [][] data=new String[rowCount-1][cellCount];
      		
      		for(int i=1;i<rowCount;i++) {
      			for(int j=0;j<cellCount;j++) {
      				data[i-1][j]=sheet.getRow(i).getCell(j).toString();
      			}
      		}
      		
      		return data;
			
		}
		
		public static void main(String[] args) throws EncryptedDocumentException, IOException {
			readRowDataFromExcel("register");
	        
		}
		
	
}


