package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	
	SoftAssert softassert = new SoftAssert();
	
	@BeforeGroups("Regression")
	//@BeforeMethod
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50000, TimeUnit.MILLISECONDS);
		report = new ExtentReports("ExtentReports.html");
	
	}
	
	@Test(groups = {"Regression"})
	@Parameters({"username","password"})
	//@Test
	public void Login(String uname, String pwd) {

		
		
	//	WebElement ResourceLink = driver.findElement(By.linkText("Resources"));
		//ResourceLink.click();
		test = report.startTest("Login Test Case");
		
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		LoginLink.click();
		test.log(LogStatus.PASS, "Successfully clicked on login button");
		
	WebElement username = driver.findElement( By.name("user_login"));
		
	WebDriverWait wait = new WebDriverWait(driver,30);
	        
	  wait.until(ExpectedConditions.elementToBeClickable(username));
		
		username.sendKeys(uname);
		test.log(LogStatus.PASS, "Successfully entered the username");

		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys(pwd);
		test.log(LogStatus.PASS, "Successfully entered the password");
		
		WebElement rememberMe = driver.findElement(By.className("rememberMe"));
		rememberMe.click();
		
		WebElement LoginButton = driver.findElement(By.name("btn_login"));
		LoginButton.click();
		test.log(LogStatus.PASS, "Successfully clicked on login button");
		
		WebElement Error = driver.findElement(By.id("msg_box"));
		String ActMsg = Error.getText();
		String ExpMsg = "The email or password you have entered is invalid";
		
		Assert.assertTrue(Error.isDisplayed());
		
		softassert.assertEquals(ActMsg, ExpMsg);
		System.out.println("After Soft Assert");
	//	test.log(LogStatus.FAIL, "Expected and Actual values does not matched");
	
		/*try {
		Assert.assertEquals(ActMsg, ExpMsg);
		test.log(LogStatus.PASS, "Expected and Actual value matches");
		
		}catch(Throwable e){
		test.log(LogStatus.FAIL, "Expected and Actual values does not matched");
		}*/
	}
//	@AfterMethod
	@AfterGroups("Regression")
	public void TearDown()
	{
		report.endTest(test);
		report.flush();
		driver.quit();
		softassert.assertAll();
	}

}
