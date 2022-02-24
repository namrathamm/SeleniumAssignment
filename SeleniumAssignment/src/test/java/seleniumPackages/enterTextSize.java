package seleniumPackages;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class enterTextSize {
	WebDriver driver;
	String url = "https://twitter.com/login";

	
	@Before
	public void setUp()throws Exception{

	System.setProperty("webdriver.chrome.driver","C:\\Users\\NamrathaChakravarthi\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	Thread.sleep(4000);


	}

	@Test
	public void testEnterText()throws Exception{

			
				WebElement email = driver.findElement(By.name("session[username_or_email]"));
				WebElement password = driver.findElement(By.name("session[password]"));
				
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].value='abc@gmail.com'", email);  //passing email address
				js.executeScript("arguments[0].value='abc@321'", password);     //passing password
				System.out.println("Entering text without sendkeys successful"); //success message
			
		
	}
	
	@After
	public void tearDown()throws Exception{

		Thread.sleep(4000);	
		driver.quit();
		}
}
