package com.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.base.Testbase;
import com.demo.util.Testutil;

public class Homepage extends Testbase{
	
	@FindBy(xpath="//span[text()='Logout']")
	public WebElement logout;
	
	@FindBy(xpath="//span[text()='Support']")
	WebElement support;
	
	@FindBy(xpath="//span[text()='Profile']")
	WebElement profile;
	
	public String jobinductionurl="http://oca-mel-test:8300/Job%20Management/JobsInducted/MngJobInduction.aspx?i=1&pn=Jobs%20Induction&j=313&prn=Easy%20Print%20Manager";
	
		public Homepage()
		{
			PageFactory.initElements(driver, this);
		}
		
		public String verifyHomepageTitle()
		{
			Testutil.waituntil(logout);
		
			return driver.getTitle();
		}
		
		public boolean verifylogoutlink()
		{
			boolean logoutlink=(logout.isDisplayed()&&logout.isEnabled());
			return logoutlink;
		}
		
		public boolean verifysupportlink()
		{
			boolean supportlink=(support.isDisplayed()&&support.isEnabled());
			return supportlink;
		}
		
		public boolean verifyprofilelink()
		{
			boolean profilelink=(profile.isDisplayed()&&profile.isEnabled());
			return profilelink;
		}
		
		public Jobinductionpage JobInductionpage()
		{
			driver.get(jobinductionurl);
			return new Jobinductionpage();
		}






}
