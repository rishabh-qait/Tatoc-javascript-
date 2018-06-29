package com.qait.JSautomation.JS1;

import org.junit.AfterClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testall {
  
	
	WebDriver driveroftest;
	JavascriptExecutor jsoftest;
	Tactochome homeobj;
	Tactocgrid gridobj;
	Tactocboxes boxesobj;
	Tactocdragdrop dragdropobj;
	Tactocpopup popupobj;
	@Test(priority=1)
	public void attemptclickonbasiccourse() 
	
	{
		homeobj.get_Basic_Course_Link_And_Click();
		
	}
	
	@Test(priority=2)
	public void attemptclickonredbox_Errorpage() 
	
	{
		gridobj.click_Redbox();
		
	}
	@Test(priority=3)
	public void attemptclickongreenbox_Nextpage() 
	
	{
		gridobj.click_Greenbox();
		
	}
	@Test (priority=4)
	public void attemptproceed_Nocolormatch() 
	{
		boxesobj.attempt_Nocolormatch_Proceed();
		
	}
	@Test(priority=5)
	public void attemptproceed_Colormatch() 
	
	{
	boxesobj.get_Color_Of_Box1();
	boxesobj.get_Color_Of_Box2();	
	boxesobj.attempt_Colormatch_Proceed();
	}
	
	
	@Test (priority=6)
	public void attempt_nodragdrop_proceed() 
	{
		WebElement from=dragdropobj.get_dragelement();
		WebElement to=dragdropobj.get_dropelement();
		dragdropobj.nodraganddrop(from, to);
		
		
	}
	@Test (priority=7)
	public void attempt_dragdrop_proceed() 
	{
		WebElement from=dragdropobj.get_dragelement();
		WebElement to=dragdropobj.get_dropelement();
		dragdropobj.draganddrop(from, to);
		
		
	}
	
	@Test(priority=8)
	public void attempt_proceed_directly_without_popup()
	{
		popupobj.get_Proceed_Link().click();
		popupobj.proceed_withoutpopup();
		
		
		
	}
	@Test(priority=9)
	public void attempt_proceed_popup_but_notext()
	{
		
		popupobj.launchpopupandnotwrite();
		
		
	}
	
	
@Test(priority=10)
public void attempt_proceed_popup__sometext()
{
	
	popupobj.launchpopupandwrite();
	
	
}
	

	
	
	
	
	@BeforeClass
	public void launchBrowser() 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\rishabh.jain\\eclipse-workspace\\chromedriver.exe");
		driveroftest=new ChromeDriver();
		jsoftest = (JavascriptExecutor) driveroftest;
		driveroftest.get("http://10.0.1.86/tatoc");
		 homeobj= new Tactochome(driveroftest,jsoftest); 
		 gridobj= new Tactocgrid(driveroftest,jsoftest);
		boxesobj=new Tactocboxes(driveroftest,jsoftest);
	dragdropobj= new Tactocdragdrop(driveroftest,jsoftest);
	popupobj= new Tactocpopup(driveroftest,jsoftest);
	
	}
	@AfterClass
	public void closeBrowser() 
	{
		driveroftest.quit();
		
	}
	
  
}
