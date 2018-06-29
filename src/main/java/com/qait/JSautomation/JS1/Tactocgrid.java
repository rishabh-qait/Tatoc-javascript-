package com.qait.JSautomation.JS1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Tactocgrid {
	WebDriver driver;
	WebElement link_Basic_Course ;
	JavascriptExecutor js =(JavascriptExecutor) driver;
	public Tactocgrid(WebDriver driver,JavascriptExecutor js) {
		this.driver=driver;
		this.js=js;
		
	}
	public void click_Redbox() {

			
			js.executeScript("document.getElementsByClassName('redbox')[0].click()");
			Assert.assertEquals("http://10.0.1.86/tatoc/error",driver.getCurrentUrl());
			driver.navigate().back();
		}
	public void click_Greenbox() {

		
		js.executeScript("document.getElementsByClassName('greenbox')[0].click();");
		Assert.assertEquals("http://10.0.1.86/tatoc/basic/frame/dungeon",driver.getCurrentUrl());
	}
	
	
		
}
