package assertion;
import java.io.File;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.google.common.io.Files;
public class TakeScreenshot {
	WebDriver driver;
	String url = "https://api.jquery.com/dblclick/";

	
	@Before
	public void setUp()throws Exception{

				System.setProperty("webdriver.chrome.driver","C:\\Users\\NamrathaChakravarthi\\Downloads\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.get(url);
				driver.manage().window().maximize();
				Thread.sleep(4000);
		}

	@Test
	public void takeShot()throws Exception{

				try {
					File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					File target = new File(System.getProperty("user.dir") + "/Screenshots/screen.jpg");
					Files.copy(source, target);
				}
				catch(IOException e) {
					System.out.println("Message: "+e.getMessage());
				}
	}
	
	@After
	public void tearDown()throws Exception{

					Thread.sleep(4000);	
					driver.close();
		}
}
