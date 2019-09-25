package com.demo.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demo.base.Testbase;
import com.demo.pages.DataMapping;
import com.demo.pages.Homepage;
import com.demo.pages.Jobinductionpage;
import com.demo.pages.Loginpage;

import junit.framework.Assert;

public class JobinductionTest extends Testbase {
	
	Loginpage loginpage;
	Homepage homepage;
	Jobinductionpage jobinduction;
	DataMapping datamapping;
	public JobinductionTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialisation();
		
		
		loginpage=new Loginpage();
		
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		jobinduction=new Jobinductionpage();
		
	}
	
	@Test(priority=1)
	public void verifyImportpageHeader()
	{
		String pageheader=jobinduction.ImportjobsPage();
		Assert.assertEquals(pageheader, "Import Jobs");
	}
	
	@Test(priority=2)
	public void verifyImportpageElements() throws InterruptedException
	{
		boolean elements=jobinduction.ImportPageElements();
		Assert.assertEquals(elements, true);
	}
	
	@Test(priority=3)
	public void verifyDataMappingpage()
	{
		datamapping=jobinduction.DataMappingPage();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	

}
