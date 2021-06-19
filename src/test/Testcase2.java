package test;

import org.testng.annotations.Test;

public class Testcase2 {


	//@Test(priority=0, description = "Verify that homepage test functionality is working fine", groups = {"Regression"})
	@Test(description = "Verify that homepage test functionality is working fine", groups = {"Regression"})
	public void HomepageTest()
	{
		System.out.println("Inside Homepage Test");
	}

	//@Test(priority=2)
	@Test(dependsOnMethods="HomepageTest")
	public void LogoutTest()
	{
		System.out.println("Inside Logout Test");
	}
	

	//@Test(priority=1)
	@Test(dependsOnMethods="LogoutTest")
	public void CartTest()
	{
		System.out.println("Inside Cart Test");
	}
}
