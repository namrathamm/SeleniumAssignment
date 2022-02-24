package seleniumPackages;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class brokenLinks {
	private static WebDriver driver = null;
	String url = "http://www.zlti.com";
	String website = "";
	HttpURLConnection httpConnect = null;
	int statusCode = 200;
	
	@Before
	public void setUp()throws Exception{

	System.setProperty("webdriver.chrome.driver","C:\\Users\\NamrathaChakravarthi\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	Thread.sleep(4000);


	}

	@Test
	public void findBrokenLinks()throws Exception{

			
		List<WebElement> listElement = driver.findElements(By.tagName("a"));
		Iterator<WebElement> iterate = listElement.iterator();
		while(iterate.hasNext()) {
			website = iterate.next().getAttribute("href");
			System.out.println(website);
			
			if(website==null || website.isEmpty()) {
				System.out.println("URL is either not configured for anchor tag or is empty");
				continue;
			}
			
			if(!website.startsWith(url)) {
				System.out.println("URL belongs to another domain,skip it");
				continue;
			}
			
			try {
				
				httpConnect = (HttpURLConnection)(new URL(website).openConnection());
				httpConnect.setRequestMethod("HEAD");
				httpConnect.connect();
				statusCode = httpConnect.getResponseCode();
				
				if(statusCode >= 400)
					System.out.println(website+" is broken link");
				else
					System.out.println(website+" is valid link");
				
			}
			
			catch(MalformedURLException e) {
				e.printStackTrace();
			}
			
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	@After
	public void tearDown()throws Exception{

		Thread.sleep(4000);	
		driver.quit();
		}
}
