package com.demo.testcases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demo.base.Testbase;
import com.demo.pages.DataMapping;
import com.demo.pages.Homepage;
import com.demo.pages.Jobinductionpage;
import com.demo.pages.Loginpage;

public class DataMappingTest extends Testbase {
	
	Loginpage loginpage;
	Homepage homepage;
	DataMapping datamappingpage;
	Jobinductionpage jobinductionpage;
	
	
	public DataMappingTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws AWTException, InterruptedException
	{
		initialisation();
		loginpage=new Loginpage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
//		jobinductionpage= new Jobinductionpage();
		datamappingpage=new DataMapping();
		datamappingpage.uploadJobFile();
		
	}

	
//	@Test(priority=1)
//	public void headertext()
//	{
//		datamappingpage.verifyHeaderText();
//	}
	
	@Test(priority=2)
	public void Matchfilename()
	{
		datamappingpage.verifyHeaderText();
		boolean file=datamappingpage.verifyFileName();
		Assert.assertEquals(file, true,"File name is not matched.");
		boolean records=datamappingpage.VerifySaveRecords();
		Assert.assertEquals(records, true,"All records are not uploaded.");
	}
//	@Test(priority=3)
//	public void Matchuploadrecords()
//	{
//		boolean records=datamappingpage.VerifySaveRecords();
//		Assert.assertEquals(records, true);
//	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
