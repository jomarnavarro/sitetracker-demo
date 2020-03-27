package com.sitetracker.hooks;

import java.util.concurrent.TimeUnit;

import com.sitetracker.sites.SalesforceSite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	public  WebDriver driver;
	public SalesforceSite salesforceSite;
	
	@Before
	public void before() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,  TimeUnit.SECONDS);
		salesforceSite = new SalesforceSite(driver);
	}
	
	@After
	public void after() {
		driver.quit();
	}

	public SalesforceSite getSalesforceSite() {
		return salesforceSite;
	}

}
