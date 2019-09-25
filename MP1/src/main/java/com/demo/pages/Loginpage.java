package com.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.base.Testbase;

public class Loginpage extends Testbase {
	
	@FindBy(id="txtLogin")
	WebElement username;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement loginbtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive center-block')]")
	WebElement logo;
	
	
	public Loginpage()
	{
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTile()
	{
		return driver.getTitle();
	}
	
	public boolean validatelogo()
	{
		return logo.isDisplayed();
	}
	public Homepage login(String un,String pwd)
	{
//		username.clear();
		username.sendKeys(un);
		password.clear();
		password.sendKeys(pwd);
		loginbtn.click();
		System.out.println(new Homepage());
		 return new Homepage();
	}
	
	
	
	
	
	
}

