package browserSearch;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchFeature {
	
	public static WebDriver driver;
	String url = "http://www.google.com";
	
	@BeforeClass
	public static void setup(){			
		 driver = new FirefoxDriver();	    
	}
	    
	@Test
	public  void gSearch() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(url); 
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		driver.findElement(By.xpath("//div[@id='sbse0']")).click();
		}
	
	@AfterClass
	public void tearDown() throws Exception {
		System.out.println("Closing the browser");
		Thread.sleep(5000);
		driver.quit();
	}
}
