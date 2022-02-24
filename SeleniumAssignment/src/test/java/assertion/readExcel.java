package assertion;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class readExcel {
	Workbook workbook;
	FileInputStream input;
	 Sheet sheet;

 @BeforeTest
 public void getExcel() throws Exception {
	
	input= new FileInputStream(new File(System.getProperty("user.dir") + "\"C:\\Users\\NamrathaChakravarthi\\OneDrive\\Documents\\Test.xlsx\""));
  	//get the excel sheet file location               
	 workbook = new XSSFWorkbook(input);
    //get the sheet which needs read operation
	 sheet= workbook.getSheetAt(0);
}
 
	
@Test
 public void testExcel() throws Exception { 
            
	//get the total row count in the excel sheet	
	   int rowcount = sheet.getLastRowNum();
	   System.out.println("::Excel data::");
	            for (int i = 0; i <= rowcount; i++) 
                {
                  
	            	// get the total cell count in the excel sheet
		          int cellcount = sheet.getRow(i).getLastCellNum();
		          for (int j = 0; j < cellcount; j++) 
                    {                         
                        //get cell value at the given position [i][j]
	                        String value = sheet.getRow(i).getCell(j).getStringCellValue();
                        //print the cell value
			                    System.out.print(value+"\t");
			
		            }
		          System.out.println();
	         }	
	   }

	
	@AfterTest
	public void teardown() throws Exception {
			
			workbook.close();
			input.close();	
	
			
}
}
