package com.qait.JSautomation.JS1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Tactochome {
	
	WebDriver driver;
	WebElement link_Basic_Course ;
	JavascriptExecutor js =(JavascriptExecutor) driver;
	public Tactochome(WebDriver driver,JavascriptExecutor js) {
		this.driver=driver;
		this.js=js;
		
	}
	public void get_Basic_Course_Link_And_Click() {
//	WebElement link = driver.findElement(By.linkText("Basic Course"));
		
		js.executeScript("document.getElementsByTagName('a')[0].click();");
		Assert.assertEquals("http://10.0.1.86/tatoc/basic/grid/gate",driver.getCurrentUrl());
	}
	
	
	
	

}
