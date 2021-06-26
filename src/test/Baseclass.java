package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Baseclass {

	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	
	SoftAssert softassert = new SoftAssert();
	
	//@BeforeGroups("Regression")
	@BeforeMethod
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50000, TimeUnit.MILLISECONDS);
		report = new ExtentReports("ExtentReports.html");
	
	}
	
	//@AfterGroups("Regression")
	@AfterMethod
	public void TearDown()
	{
		report.endTest(test);
		report.flush();
		driver.quit();
		softassert.assertAll();
	}
}
