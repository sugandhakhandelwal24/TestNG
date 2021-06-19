package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testcase1 {

	@BeforeGroups("Regression")
    public void BeforeGroupMethod() {
        System.out.println("Before Groups");
    } 
	
	@BeforeTest
	public void BeforeTes()
	{
		System.out.println("Inside Before Test");
	}
	
	@BeforeMethod
	public void Setup()
	{
		System.out.println("Inside before method");
	}
	
	@Test(groups= {"Sanity"})
	public void LoginTest()
	{
		System.out.println("Inside Login Test");
	}

	//@Test(enabled=false)
	@Test(groups= {"Regression"})
	public void signUpTest()
	{
		System.out.println("Inside Sign Up Test");
	}
	
	
	@Test(groups= {"Regression"})
	public void RandomMethod()
	{
		System.out.println("Inside Random Method");
	}
	
	@AfterMethod
	public void AfterMeth()
	{
		System.out.println("Inside after method");
	}
	
	@AfterTest
	public void AfterTes()
	{
		System.out.println("Inside After Test");
	}
}
