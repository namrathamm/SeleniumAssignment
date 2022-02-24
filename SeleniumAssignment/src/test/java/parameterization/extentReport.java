package parameterization;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
public class extentReport {
	WebDriver driver;
	String url = "https://www.google.com/";
	static ExtentTest test;
	static ExtentReports report;

	public ExtentHtmlReporter htmlReporter;
	
	@BeforeTest
	public void reportSetup() {
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Report/ExtentReport.html");
		report = new ExtentReports();  
		report.attachReporter(htmlReporter);
		report.setSystemInfo("User Name", "Feba Mary John");
		htmlReporter.config().setDocumentTitle("Generated Extent Report"); 
	        // Name of the report
		htmlReporter.config().setReportName("Extent Report "); 
		
	}
	

	
	@BeforeMethod
	public void setUp()throws Exception{
      
		System.setProperty("webdriver.chrome.driver","C:\\Users\\NamrathaChakravarthi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	
	@Test
	public void googleTitleValidation() {
		test = report.createTest("GoogleTitleValidation");
		Assert.assertEquals(driver.getTitle(),"Google");
	}
	
	
	
	@AfterMethod
	public void getResult(ITestResult result) throws Exception
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			//MarkupHelper is used to display the output in different colors
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

		}
		else if(result.getStatus() == ITestResult.SKIP){
			//logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE)); 
		} 
		
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
		}
		driver.close();
	}
			
	
	@AfterTest
	public void tearDown()throws Exception{

		report.flush();
			
}

}
