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

public class DataMapping extends Testbase {
	
	Jobinductionpage jobinduction = new Jobinductionpage();;
	
	
	@FindBy(xpath="//*[@id='hdrRcrdCnt']")
	WebElement FileName;
	@FindBy(xpath="//h1[text()='Data mapping']")
	WebElement HeaderText;
	@FindBy(xpath="//button[@id='btnSaveClose']")
	WebElement SaveCloseBtn;
	@FindBy(xpath="//*[@id='Form1']/div[5]/span[1]")
	WebElement Flashalert;
	
	
	public static String records;
	
	
	public DataMapping()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void uploadJobFile() throws AWTException, InterruptedException
	{
		Testutil.waituntil(jobinduction.ImportJobs);
		Thread.sleep(5000);
		jobinduction.ImportJobs.click();
		Thread.sleep(2000);
//		Specify the file location with extension.
		StringSelection sel=new StringSelection(prop.getProperty("JobInductFilePath")+prop.getProperty("JobInductionFileName"));
		
//		Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
		
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
	public String verifyHeaderText()
	{
//		Testutil.waituntil(jobinduction.ImportJobs);
//		jobinduction.ImportJobs.click();
		return HeaderText.getText();
	}
	
	public String GetFileName()
	{
		Testutil.waituntil(FileName);
		String f1=FileName.getText();
		System.out.println(f1);
		String filename=f1.substring(0, f1.indexOf(","));
		String r1=f1.substring((f1.indexOf(",")+1), f1.length()).trim();
		records=r1.substring(0, r1.indexOf(" "));
		System.out.println(filename);
		System.out.println(records);
		return filename;	
	}
	
	public Boolean verifyFileName()
	{
//		Testutil.waituntil(jobinduction.ImportJobs);
//		jobinduction.ImportJobs.click();
		if(GetFileName().equals(prop.getProperty("JobInductionFileName")))
		{
			return true;
		}
		else return false;
		
	}
	
	public Boolean VerifySaveRecords()
	{
		SaveCloseBtn.click();
		
//		COMPARE NUMBER of EXCEL UPLOADED RECORDS AND ADDED RECORDS DISPLAY IN FLASH MESSAGE INTO THE SYSTEM	 
		
//		Get record count from flash bar
			Testutil.waituntil(Flashalert);
			String flr=Flashalert.getText();
			int in2=flr.indexOf(" ");
			String flashrecords=flr.substring(0,in2);
			if(records.equals(flashrecords))
			{
			return true;
			}
			else{
				return false;
			}
		 
	}

}
