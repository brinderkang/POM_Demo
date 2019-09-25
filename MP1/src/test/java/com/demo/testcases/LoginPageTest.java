package com.demo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demo.base.Testbase;
import com.demo.pages.Homepage;
import com.demo.pages.Loginpage;

public class LoginPageTest extends Testbase {
	
	Loginpage loginpage;
	Homepage homepage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialisation();
		loginpage=new Loginpage();
	}
	
	
	@Test(priority=1)
	public void loginpagetitletest()
	{
		String title=loginpage.validateLoginPageTile();
		Assert.assertEquals(title, "ASCENT ONE Login");
	}
	
	@Test(priority=2)
	public void logoImagetest()
	{
		boolean flag=loginpage.validatelogo();
		Assert.assertEquals(flag, true);
	}
	
	@Test(priority=3)
	public void logintest()
	{
		
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println(homepage);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
