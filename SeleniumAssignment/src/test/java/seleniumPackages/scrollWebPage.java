package seleniumPackages;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class scrollWebPage {
	WebDriver driver;
	//String url = "http://openclinic.sourceforge.net/openclinic/home/index.php";
	String url = "http://demo.guru99.com/test/guru99home/";
	
	@Before
	public void setUp()throws Exception{

	System.setProperty("webdriver.chrome.driver","C:\\Users\\NamrathaChakravarthi\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	Thread.sleep(2000);


	}

	@Test
	public void testScroll() throws Exception{

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("window.scrollTo(0,1500)"); //window scroll to this location
		
executor.executeScript("window.scrollTo(0,document.body.scrollHeight)");  //scroll to the bottom of the page
		Thread.sleep(4000);
		}
	
	
	@After
	public void tearDown()throws Exception{

		    Thread.sleep(4000);
			driver.quit();
		}
}
