package browserSearch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ExcelCapture {
	
	public WebDriver driver;
	
	String filePath = "E:\\Study\\workspace\\OCM25_26_OCE_19\\OCM25_26_OCE_19\\BlackDogFrameWork\\TestData\\Test_Data.xlsx";
	
	@Parameters({ "data", "rowNum", "colNum" })
	@BeforeClass
	public String excelFunction(String sheetName, int rowNum, int colNum) throws EncryptedDocumentException, InvalidFormatException, IOException  {
		
		
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		String data = row.getCell(colNum).getStringCellValue();
		return data;		
	}
	
	
	
	@Test
	public void login() throws EncryptedDocumentException, InvalidFormatException, IOException 
	{		driver = new FirefoxDriver();
		driver.get("http://www.gmail.com");
		String userName1 = excelFunction("datad", 1, 2);
		String passWord1 = excelFunction("datad", 1, 3);
		
		driver.findElement(By.id("Email")).sendKeys(userName1);
		driver.findElement(By.id("Email")).sendKeys(passWord1);		
	}
	
/*	@AfterClass
	public void exit(){
		driver.quit();
	}
*/
}
