package com.qait.JSautomation.JS1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Tactocdragdrop {
	WebDriver driver ;
	JavascriptExecutor js ;
WebElement drag;
	WebElement drop;
	
	public Tactocdragdrop(WebDriver driver,JavascriptExecutor js) {
		this.driver=driver;
		this.js=js;
		
	}
	
	public WebElement get_dragelement() 
	{
		String script= "return document.getElementById('dragbox')" ;
		 drag= (WebElement) js.executeScript(script);
		System.out.println(drag.getText());
		return drag;
		
	}
	public WebElement get_dropelement() 
	{
		String script= " return document.getElementById('dropbox')" ;
		 drop= (WebElement) js.executeScript(script);
		System.out.println(drop.getText());
		return drop;
		
	}
	
	public void draganddrop(WebElement from,WebElement to)
	{
		

		js.executeScript("document.getElementById('dragbox').style.left= '32px' ");
		js.executeScript("document.getElementById('dragbox').style.top= '-59px' ");
		js.executeScript("document.getElementsByTagName('a')[0].click();");
        Assert.assertEquals("http://10.0.1.86/tatoc/basic/windows",driver.getCurrentUrl());		
	
	}
	
	public void nodraganddrop(WebElement from,WebElement to) 
	{
		js.executeScript("document.getElementsByTagName('a')[0].click();");
		 Assert.assertEquals("http://10.0.1.86/tatoc/error",driver.getCurrentUrl());	
	driver.navigate().back();
	}
	
	
	
}
