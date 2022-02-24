package seleniumPackages;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDowns {
	WebDriver driver;
	String url = "https://www.jquery-az.com/boots/demo.php?ex=63.0_2";

	
	@Before
	public void setUp()throws Exception{

	System.setProperty("webdriver.chrome.driver","C:\\Users\\NamrathaChakravarthi\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);   //implicit wait 5sec
	Thread.sleep(2000);
	}


	@Test
	public void testBootStrap()throws Exception{

	driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[2]/td[3]/div/span/div/button")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[2]/td[3]/div/span/div/ul/li[4]/a/label/input")).click();  //unchecking element
	driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[2]/td[3]/div/span/div/ul/li[5]/a/label/input")).click();  //unchecking element
	Thread.sleep(2000);
	List<WebElement> webElement = driver.findElements(By.xpath("//ul[contains(@class, 'multiselect-container' )]//li//a//label"));

	for(int i = 0; i<webElement.size(); i++) {
		
		String value = webElement.get(i).getText();
		if (value.equalsIgnoreCase("Java")||value.equalsIgnoreCase("Oracle")) {
			Thread.sleep(8000);
				webElement.get(i).click();  //checks elements

			}
		}
	Thread.sleep(2000);

	}
	
	@After
	public void tearDown()throws Exception{

			Thread.sleep(4000);
			driver.quit();
}
}
