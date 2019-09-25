package com.demo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demo.base.Testbase;
import com.demo.pages.Homepage;
import com.demo.pages.Jobinductionpage;
import com.demo.pages.Loginpage;

public class HomepageTest extends Testbase {
	
	Loginpage loginpage;
	Homepage homepage;
	Jobinductionpage jobinductionpage;
	public HomepageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		initialisation();
		loginpage=new Loginpage();
		jobinductionpage=new Jobinductionpage();
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void homepagetitletest()
	{
		String homepagetile=homepage.verifyHomepageTitle();
		Assert.assertEquals(homepagetile, "ASCENTONE :: Enterprise Portal","Title not matched");
	}
	@Test(priority=2)
	public void logoutlinktest()
	{
		homepage.verifylogoutlink();
	}
	@Test(priority=3)
	public void supportlinktest()
	{
		homepage.verifysupportlink();
	}
	@Test(priority=4)
	public void profilelinktest()
	{
		homepage.verifyprofilelink();
	}
	
	@Test(priority=5)
	public void verifyJobInductionpage()
	{
		jobinductionpage=homepage.JobInductionpage();
		
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
//		driver.quit();
	}
	

}
