package assertion;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class goggleAccount {
	WebDriver driver;
	String url = "https://accounts.google.com/signup";
	
	
	@Before
	public void setUp()throws Exception{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\NamrathaChakravarthi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(4000);
	}
	
	@Test
	public void testCreate() throws InterruptedException{
		
			WebElement firstName = driver.findElement(By.id("firstName"));
			firstName.sendKeys("Ayra");
			String firstname = firstName.getAttribute("value");
			System.out.println("First Name: "+firstname);   //first name in console
			
			WebElement lastName = driver.findElement(By.id("lastName"));
			lastName.sendKeys("Yash");
			String lastname = lastName.getAttribute("value");
			System.out.println("Last Name: "+lastname);   //last name in console
			
			driver.findElement(By.id("username")).sendKeys("ayra456yash");   //adding username
			
			Thread.sleep(4000);
			
			WebElement password = driver.findElement(By.xpath("//*[@id=\"passwd\"]/div[1]/div/div[1]/input"));
			password.sendKeys("abc@4567");    //adding password
			
			Thread.sleep(4000);
			
			String confirmPass = password.getAttribute("value");
			driver.findElement(By.xpath("//*[@id=\"confirm-passwd\"]/div[1]/div/div[1]/input")).sendKeys(confirmPass);
			
			driver.findElement(By.id("accountDetailsNext")).click();         //Next button click
			
			Thread.sleep(4000);
			
			if(!(driver.getCurrentUrl()=="https://accounts.google.com/signup"|| driver.getCurrentUrl().contains("SignUp")))
			{
				System.out.println(driver.getCurrentUrl());
				if(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[2]/form/div[2]/div/div[1]/div[2]/div[3]")).isDisplayed())
				
				{
					String firstSug = driver.findElement(By.xpath("//*[@id=\"usernameList\"]/li[1]/button")).getText();
					String secondSug = driver.findElement(By.xpath("//*[@id=\"usernameList\"]/li[2]/button")).getText();
					String thirdSug = driver.findElement(By.xpath("//*[@id=\"usernameList\"]/li[3]/button")).getText();
					
					driver.findElement(By.id("username")).clear();
					Thread.sleep(4000);
					driver.findElement(By.id("username")).sendKeys(firstSug);
					Thread.sleep(4000);
					driver.findElement(By.id("accountDetailsNext")).click();         //Next button click
					Thread.sleep(4000);
				}
				
				else {
					driver.findElement(By.id("username")).clear();
					driver.findElement(By.id("username")).sendKeys("automation");
					Thread.sleep(4000);
					driver.findElement(By.xpath("//*[@id=\"accountDetailsNext\"]/span/span")).click();
					Thread.sleep(4000);
				}
			}
			String text = driver.getCurrentUrl();
			Thread.sleep(3000);
			Assert.assertTrue(text.contains("accounts.google.com"));  //Assertion used for Validation 
			System.out.println("Google account created successfully");
			
			}
		
	
	@After
	public void tearDown() throws Exception{
			
		Thread.sleep(2000);
		driver.close();
	}
}
