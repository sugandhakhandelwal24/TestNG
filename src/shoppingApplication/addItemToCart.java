package shoppingApplication;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

public class addItemToCart {
	WebDriver driver;
	
	@BeforeTest
		public void setup() {
			
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
			driver.get("https://www.saucedemo.com/");
			
			driver.manage().window().maximize();
		//	driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
			//report = new ExtentReports("ExtentReports.html");
		
		}
	
	@Test
	public void login()
	{
		
		WebElement username = driver.findElement(By.xpath("//*[@id ='user-name']"));
		username.sendKeys("standard_user");
		
		WebElement password = driver.findElement(By.xpath("//*[@name='password']"));
		password.sendKeys("secret_sauce");
		
		WebElement loginButton = driver.findElement(By.xpath("//*[@id='login-button']"));
		loginButton.click();
		
		String HomePageTitle = driver.getTitle();
		System.out.println("Title of the homepage is : " + HomePageTitle);
	
		
	}

	@Test(dependsOnMethods="login")
	public void addToCart()
	{
	
		WebElement addToCartItem = driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-bolt-t-shirt']"));
		addToCartItem.click();
		
		WebElement cart = driver.findElement(By.xpath("//*[@class = 'shopping_cart_link']"));
		cart.click();
		
		
	}
	
	@AfterTest
	public void TearDown()
	{
		
		driver.quit();
		
	}
}
