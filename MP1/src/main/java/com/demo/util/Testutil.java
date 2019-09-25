package com.demo.util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.base.Testbase;
import com.demo.pages.Homepage;

public class Testutil extends Testbase{

	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	public static long ELEMENT_TIMEOUT=20;
	
	
	
	public static void waituntil(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, ELEMENT_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void waituntilHomepageLoad()
	{
		
		Homepage homepage=new Homepage();
		waituntil(homepage.logout);
	}
}
