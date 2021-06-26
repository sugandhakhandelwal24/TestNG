package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import test.LoginTest;

public class LoginPage {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	
	
	//================== WebElement ================== 
		
	@FindBy(linkText="Log in")
    WebElement LoginLink;
    
    @FindBy(name="user_login")
    WebElement username;
    
    @FindBy(id="password")
    WebElement password;
    
    @FindBy(className="rememberMe")
    WebElement rememberMe;
    
    @FindBy(name="btn_login")
    WebElement LoginButton;
    
    @FindBy(id="msg_box")
    WebElement Error;
	
	
	
	//================== Constructor ================== 

	public LoginPage()
	{
		driver = LoginTest.driver;
		report = LoginTest.report;
		test = LoginTest.test;
		PageFactory.initElements(driver, this);
	}
	
	//================== Methods ================== 
	
	public void Login (String uname, String pwd)
	{
		
		test = report.startTest("Login Test Case");
		//WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		LoginLink.click();
		test.log(LogStatus.PASS, "Successfully clicked on login button");
		
	//	WebElement username = driver.findElement( By.name("user_login"));
		
		WebDriverWait wait = new WebDriverWait(driver,30);
	        
	  	wait.until(ExpectedConditions.elementToBeClickable(username));
		
		username.sendKeys(uname);
		test.log(LogStatus.PASS, "Successfully entered the username");
		
		//WebElement password = driver.findElement(By.id("password"));
		password.sendKeys(pwd);
		test.log(LogStatus.PASS, "Successfully entered the password");
		
	//	WebElement rememberMe = driver.findElement(By.className("rememberMe"));
		rememberMe.click();
		
	//	WebElement LoginButton = driver.findElement(By.name("btn_login"));
		LoginButton.click();
		test.log(LogStatus.PASS, "Successfully clicked on login button");
		
		//WebElement Error = driver.findElement(By.id("msg_box"));
		String ActMsg = Error.getText();
		String ExpMsg = "The email or password you have entered is invalid.";
		
		Assert.assertTrue(Error.isDisplayed());
		Assert.assertEquals(ActMsg, ExpMsg);
		
	//	softassert.assertEquals(ActMsg, ExpMsg);
		//System.out.println("After Soft Assert");
	//	test.log(LogStatus.FAIL, "Expected and Actual values does not matched");
	
		/*try {
		Assert.assertEquals(ActMsg, ExpMsg);
		test.log(LogStatus.PASS, "Expected and Actual value matches");
		
		}catch(Throwable e){
		test.log(LogStatus.FAIL, "Expected and Actual values does not matched");
		}*/
	}
	
}
