package assertion;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class switchTab {
	WebDriver driver;
	String url = "http://demo.automationtesting.in/Windows.html";

	
	@BeforeTest
	public void setUp()throws Exception{

			System.setProperty("webdriver.chrome.driver","C:\\Users\\NamrathaChakravarthi\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			Thread.sleep(4000);
	}
	
	@Test
	public void testTabSwitch()throws Exception{
			
			String urlNew = null;
			
			//click button
			driver.findElement(By.xpath("//*[@id=\"Tabbed\"]/a/button")).click();
			
			for(String newTab:driver.getWindowHandles()) {
				
				driver.switchTo().window(newTab);
				urlNew = driver.getCurrentUrl();
				System.out.println(driver.getTitle());
			}
			
			//click on About option and showing sub-options
			WebElement webElement = driver.findElement(By.xpath("/html/body/header/nav/div[1]/span"));
			Thread.sleep(4000);
			
			//for clicking sub-menus and click on Events option 
			webElement.click();
			Thread.sleep(4000);
            
			//loading Events tab
			driver.findElement(By.linkText("Events")).click();
			Thread.sleep(4000);	
			
			urlNew = driver.getTitle();
			Assert.assertTrue(!url.equals(urlNew)); //Assertion used for validation
			System.out.println(urlNew);
	}

	
	@AfterTest
	public void tearDown()throws Exception{

		    driver.quit();
	}
}
