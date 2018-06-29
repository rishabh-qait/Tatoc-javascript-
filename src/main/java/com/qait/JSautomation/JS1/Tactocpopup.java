package com.qait.JSautomation.JS1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class Tactocpopup {
	
	
	WebDriver driver;
	JavascriptExecutor js;
	public Tactocpopup(WebDriver driver,JavascriptExecutor js) {
		this.driver=driver;
		this.js=js;
	}
	
	public void launchpopupandwrite() 
	{
		js.executeScript("document.getElementsByTagName('a')[0].click();");
		String parentwindowhandler=driver.getWindowHandle();
		String subwindowhandle=null;
		Set<String> handles= driver.getWindowHandles();
		Iterator<String> iterator=handles.iterator();
		while(iterator.hasNext()) 
		{
			subwindowhandle=iterator.next();
			
		}
		driver.switchTo().window(subwindowhandle);
		js.executeScript("document.getElementById('name').click();");
        js.executeScript("document.getElementById('name').value='Rishabh jain'");
        js.executeScript("document.getElementById('submit').click();");
	
	driver.switchTo().window(parentwindowhandler);
	js.executeScript("document.getElementsByTagName('a')[1].click();");
	
	}
	public void launchpopupandnotwrite() 
	{
		js.executeScript("document.getElementsByTagName('a')[0].click();");
		String parentwindowhandler=driver.getWindowHandle();
		String subwindowhandle=null;
		Set<String> handles= driver.getWindowHandles();
		Iterator<String> iterator=handles.iterator();
		while(iterator.hasNext()) 
		{
			subwindowhandle=iterator.next();
			
		}
		driver.switchTo().window(subwindowhandle);
		js.executeScript("document.getElementById('name').click();");
        js.executeScript("document.getElementById('name').value=''");
        js.executeScript("document.getElementById('submit').click();");
	
	driver.switchTo().window(parentwindowhandler);
	js.executeScript("document.getElementsByTagName('a')[1].click();");
	Assert.assertEquals("http://10.0.1.86/tatoc/error",driver.getCurrentUrl());
	driver.navigate().back();
	}
	public void proceed_withoutpopup() {
		Assert.assertEquals("http://10.0.1.86/tatoc/error",driver.getCurrentUrl());
		driver.navigate().back();
	}
	
	
	
	public WebElement get_Proceed_Link() {
		WebElement proceedlink = driver.findElement(By.linkText("Proceed"));
		return proceedlink;
	}
	
	
	

}
