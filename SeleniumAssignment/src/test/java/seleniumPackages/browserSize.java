package seleniumPackages;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class browserSize {
	WebDriver driver;
	String url = "https://www.google.com";

	
	@Before
	public void setUp()throws Exception{

	System.setProperty("webdriver.chrome.driver","C:\\Users\\NamrathaChakravarthi\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	Thread.sleep(4000);


	}

	@Test
	public void setBrowserWindowSize()throws Exception{

			Dimension originalDim = driver.manage().window().getSize();  //getting original size of browser window
			System.out.println("Browser window size before setting: "+originalDim);
			 driver.manage().window().setSize(new Dimension(100,400));   //setting new size for browser window
			Dimension settingDim = driver.manage().window().getSize();
			System.out.println("Browser window size after setting: "+settingDim);
			
			
			if(originalDim != settingDim) {
			
				System.out.println("Setting Browser window size successful");  //success message
			
		}
	}
	
	@After
	public void tearDown()throws Exception{

		Thread.sleep(4000);	
		driver.quit();
		}
}
