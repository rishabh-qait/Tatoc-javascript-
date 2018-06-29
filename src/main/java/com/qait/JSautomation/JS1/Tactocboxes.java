package com.qait.JSautomation.JS1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Tactocboxes {
	WebDriver driver;
	WebElement link_Basic_Course ;
	String colorofbox1;
	String colorofbox2;
	JavascriptExecutor js =(JavascriptExecutor) driver;
	public Tactocboxes(WebDriver driver,JavascriptExecutor js) {
		this.driver=driver;
		this.js=js;
		
	}
	public void get_Color_Of_Box1()
	{

		
		
		String scriptforbox1="return document.getElementById('main').contentWindow.document.getElementById('answer').getAttribute('class')";
		 colorofbox1=(String) js.executeScript(scriptforbox1);
	System.out.println(colorofbox1);
	}
	public String get_Color_Of_Box2() 
	{

			
			String scriptforbox1="return document.getElementById('main').contentWindow.document.getElementById('child').contentWindow.document.getElementById('answer').getAttribute('class')";
			 colorofbox2=(String) js.executeScript(scriptforbox1);
		System.out.println(colorofbox2);
	return colorofbox2;	
	}
	public void attempt_Nocolormatch_Proceed() 
	{
		
		js.executeScript(" document.getElementById('main').contentWindow.document.getElementsByTagName('a')[1].click()");
		Assert.assertEquals("http://10.0.1.86/tatoc/error",driver.getCurrentUrl());
	driver.navigate().back();
	
	}
	public void attempt_Colormatch_Proceed() 
	{
		boolean status=true;
		while(status) {
			
			
			
			if(colorofbox1.equals(colorofbox2)) {
				status=false;
			}
			else {
				js.executeScript(" document.getElementById('main').contentWindow.document.getElementsByTagName('a')[0].click()");
			colorofbox2=get_Color_Of_Box2();
			}
			
			
		}js.executeScript(" document.getElementById('main').contentWindow.document.getElementsByTagName('a')[1].click()");
		
		Assert.assertEquals("http://10.0.1.86/tatoc/basic/drag",driver.getCurrentUrl());
		
	}
	
	

}
