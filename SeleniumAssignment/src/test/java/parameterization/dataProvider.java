package parameterization;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class dataProvider {
	WebDriver driver;
  	@DataProvider(name = "test-data")
  	public Object[][] dataProvFunc(){
        	return new Object[][]{
        		{"Python"},{"Java"},{"SQL"}
        	};
  	}
  	
  	@BeforeMethod
	  public void setUpData() {
       	  System.out.println("Start test");
      	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\NamrathaChakravarthi\\Downloads\\chromedriver_win32\\chromedriver.exe");
      	  driver = new ChromeDriver();
      	  String url = "https://www.google.com";
      	  driver.get(url);
      	  driver.manage().window().maximize();
      	 
	  }
  	
  	@Test(dataProvider ="test-data")
  	public void search(String keyWord)throws InterruptedException{
        	  
  		      WebElement text = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        	  text.sendKeys(keyWord);
        	  Thread.sleep(8000);
        	 
  	}
  	
  	
  	@AfterMethod
  	public void tearDown(){
        	driver.close();
  	}
}
