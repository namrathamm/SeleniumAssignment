package assertion;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class pinCode {
	WebDriver driver;
	String url = "http://chennaiiq.com/chennai/pincode-by-name.php";

	
	@Before
	public void setUp()throws Exception{

				System.setProperty("webdriver.chrome.driver","C:\\Users\\NamrathaChakravarthi\\Downloads\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.get(url);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		}

	@Test
	public void testPincode()throws Exception{
		
		WebElement tablePin = driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table[1]"));
		
		List<WebElement> row =tablePin.findElements(By.tagName("tr"));
		for(int i=3;i<row.size();i++)
		{
			List<WebElement> col =row.get(i).findElements(By.tagName("td"));
			String pinA = col.get(2).getText();
			
			for(int j=i;j<row.size();j++)
			{
				List<WebElement> colNew =row.get(j).findElements(By.tagName("td"));
				String pinB = colNew.get(2).getText();
				Assert.assertFalse(pinA==pinB);
			}
			
	
		}
		   
	}
	
	@After
	public void tearDown()throws Exception{
	
					driver.close();
		}
}
