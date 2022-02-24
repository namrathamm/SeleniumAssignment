package seleniumPackages;
import java.time.Duration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class dragDrop {
	WebDriver driver;
	String url = "https://jqueryui.com/droppable/";

	
	@Before
	public void setUp()throws Exception{

	System.setProperty("webdriver.chrome.driver","C:\\Users\\NamrathaChakravarthi\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	Thread.sleep(4000);


	}

	@Test
	public void testDragdrop()throws Exception{

	
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
	WebElement src = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));  //source of element
	WebElement target = driver.findElement(By.xpath("//*[@id=\"droppable\"]")); //target of element
	
	Actions act = new Actions(driver);
	act.dragAndDrop(src, target).pause(Duration.ofSeconds(8)).perform();
	

	String msg = driver.findElement(By.xpath("//*[@id=\"droppable\"]/p")).getText();
	if(msg.equalsIgnoreCase("Dropped!")) {
		
		System.out.println("Dropped Successfully"); //success message
	
		}
	
	}
	
	@After
	public void tearDown()throws Exception{

			driver.quit();
		}
}
