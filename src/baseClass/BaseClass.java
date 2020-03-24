/* Selenium Base class is the main class which takes care of 
=> Browser setup
=> loading configuration file 
=> Other reusable methods
*/


package baseClass;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static ExtentTest logger;
	public static ExtentReports report;
	public static WebDriver driver;
    	
	
	//_________________Inializing The Driver_________________
	
	@BeforeClass
	public static void InitializeDriver() {
		WebDriverManager.chromedriver().setup();
	 	driver = new ChromeDriver();
	}
	
	
	//_________________Create an Extend Report_________________
	@BeforeClass
	public static void CreateReport() {
			String fileName = new SimpleDateFormat("'XEROReport_'YYYYMMddHHmm'.html'").format(new Date());
			String path = "C:\\GIT\\XEROAutomation\\XEROSeleniumAutomation\\Reports\\" + fileName;
			//String path = "C:\\Selenium\\Report\\" + fileName;
	        report = new ExtentReports(path);
		}
			
		
	//_________________Open The URL_________________________ 
	
	@BeforeClass
	public void OpenApplication() throws InterruptedException
	{  
		logger = report.startTest("=====Test Execution Report=====[Browser Session Started Successfuly]");	
		driver.manage().window().maximize();
		driver.get("https://login.xero.com/");
		Thread.sleep(2000);
		logger.log(LogStatus.INFO,"=====Application Started Successfuly======");
	}
	
	
	//_________________Find Text Box & Log Details _________________
	
	public static void EnterText(WebElement element, String text, String objName) {
		if (element == null || !element.isDisplayed()) {
			logger.log(LogStatus.ERROR, objName + " Textbox is not found.");
		} else {
			logger.log(LogStatus.INFO, objName + " Textbox is found");
			element.sendKeys(text);
		}
	}

	
	//_________________Button Click & Log Details _________________
	
	public static void Click(WebElement element, String objName) {
		if (element == null || !element.isDisplayed()) {
			logger.log(LogStatus.ERROR, objName + "   is not found.");
		} else {
			logger.log(LogStatus.INFO, objName + "   is found");
			element.click();
		}
	}
	
	//_________________Close The Application __________________
	
	
	@AfterClass
	public void closeApplication()
	{
		driver.quit();
		logger.log(LogStatus.INFO,"=====Browser Session End=====");		
	}
	
	//_________________Close The Report __________________
	
	@AfterClass
	public static void CloseReport() {
		report.flush();
	}

}
