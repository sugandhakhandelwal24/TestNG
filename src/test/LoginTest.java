package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver driver;
	
	@BeforeGroups("Regression")
	//@BeforeMethod
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");
		
		driver.manage().window().maximize();
		
	driver.manage().timeouts().implicitlyWait(50000, TimeUnit.MILLISECONDS);
	}
	
	@Test(groups = {"Regression"})
	@Parameters({"username","password"})
	//@Test
	public void Login(String uname, String pwd) {

		
		
	//	WebElement ResourceLink = driver.findElement(By.linkText("Resources"));
		//ResourceLink.click();
		
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		LoginLink.click();
		
	WebElement username = driver.findElement( By.name("user_login"));
		
	WebDriverWait wait = new WebDriverWait(driver,30);
	        
	  wait.until(ExpectedConditions.elementToBeClickable(username));
		
		username.sendKeys(uname);

		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys(pwd);
		
		WebElement rememberMe = driver.findElement(By.className("rememberMe"));
		rememberMe.click();
		
		WebElement LoginButton = driver.findElement(By.name("btn_login"));
		LoginButton.click();

	}
//	@AfterMethod
	@AfterGroups("Regression")
	public void TearDown()
	{
		driver.quit();
	}

}
