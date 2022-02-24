package seleniumPackages;
import java.util.Iterator;
import java.util.Set;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class WindowPopUp {
	WebDriver driver;
	String url = "http://popuptest.com/goodpopups.html";

	
	@Before
	public void setUp()throws Exception{

	System.setProperty("webdriver.chrome.driver","C:\\Users\\NamrathaChakravarthi\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	Thread.sleep(4000);


	}

	@Test
	public void testPopup()throws Exception{

		driver.findElement(By.linkText("Good PopUp #4")).click();  //clicking element
		
		Set<String> handleWindow = driver.getWindowHandles();
		Iterator<String> i = handleWindow.iterator();
		
		String parentWindow = i.next();
		String childWindow = i.next();
		
		driver.switchTo().window(childWindow);    //switch to popup window
		
		System.out.println("Child Window Title: "+driver.getTitle());
		driver.close();   //closes child window
		
		driver.switchTo().window(parentWindow);  //switch to parent window
		System.out.println("Parent Window Title: "+driver.getTitle());
		
	}
	
	@After
	public void tearDown()throws Exception{
			
			Thread.sleep(4000);
			driver.quit();
		}
}
