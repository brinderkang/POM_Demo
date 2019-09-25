package com.demo.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.base.Testbase;
import com.demo.util.Testutil;

public class Jobinductionpage extends Testbase {
	
	
	
	@FindBy(xpath="//a[text()='Jobs']")
	WebElement JobsTab;
	
	@FindBy(xpath="//span[@class='icon_add x3']")
	WebElement AddButton;
	
	@FindBy (xpath="//*[@id='dvJobDetail']/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]")
	WebElement DateIcon;
	
	@FindBy(xpath="//td[@class='k-today k-state-focused']")
	WebElement TodayDate;
	
	@FindBy(xpath="//h1[text()='Import Jobs']")
	WebElement ImportJobsHeader;
	
	@FindBy(xpath="//h3[text()='Search records']")
	WebElement SearchRecords;
	@FindBy(xpath="//label[text()='Added by']")
	WebElement AddedBy;
	@FindBy(xpath="//label[text()='Start date']")
	WebElement StartDate;
	@FindBy(xpath="//label[text()='End date']")
	WebElement EndDate;
	@FindBy(xpath="//input[@id='btnJobIndctSearch']")
	WebElement SearchBtn;
	@FindBy(xpath="//input[@id='btnJobIndctClear']")
	WebElement ClearBtn;
	@FindBy(xpath="//a[@id='btnDwnldTemplate']")
	WebElement DownloadTemplate;
	@FindBy(xpath="//i[text()='IMPORT']")
	public WebElement ImportJobs;
	@FindBy(xpath="//input[@id='btnClose']")
	WebElement CloseBtn;
	
	
	
	
	public Jobinductionpage()
	{
		PageFactory.initElements(driver, this);
//		String abc1=prop.getProperty("url")+prop.getProperty("importjobUrl");
//		System.out.println(abc1);
		Testutil.waituntilHomepageLoad();
		driver.get(prop.getProperty("url")+prop.getProperty("importjobUrl"));

	}
	
	public String ImportjobsPage()
	{	
		Testutil.waituntilHomepageLoad();
		return(ImportJobsHeader.getText());
	}
	
	public Boolean ImportPageElements() throws InterruptedException
	{
		Testutil.waituntil(ImportJobsHeader);
	
		int elecount=0;
		Testutil.waituntil(SearchRecords);
		if(SearchRecords.isDisplayed())
			{elecount=elecount+1;};
			Thread.sleep(2000);
		SearchRecords.click();
		
		if(AddedBy.isDisplayed())
			{elecount=elecount+1;};
		
		if(StartDate.isDisplayed())
			{elecount=elecount+1;};
		
		if(EndDate.isDisplayed())
			{elecount=elecount+1;};
		
		if(SearchBtn.isDisplayed())
			{elecount=elecount+1;}
		
		if(SearchBtn.isDisplayed())
			{elecount=elecount+1;};
		
		if(ClearBtn.isDisplayed())
			{elecount=elecount+1;};
		SearchRecords.click();
		
		if(DownloadTemplate.isDisplayed())
			{elecount=elecount+1;};
		if(ImportJobs.isDisplayed())
			{elecount=elecount+1;};
		
		if(elecount==9)
		{
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	public DataMapping DataMappingPage()
	{
		
		return new DataMapping();
		
	}
	
	
	

}
