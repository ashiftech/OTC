package com.paxotech.framework.Scriptbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OTCScript {
	
	protected WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String url = "http://www.otcmarkets.com/stock/OTCM/quote";
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}
}
