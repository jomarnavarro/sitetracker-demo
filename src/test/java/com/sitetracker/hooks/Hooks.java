package com.sitetracker.hooks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.sitetracker.sites.SalesforceSite;
import com.sitetracker.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	public  WebDriver driver;
	public SalesforceSite salesforceSite;
	public Properties props;
	
	@Before
	public void before() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,  TimeUnit.SECONDS);
		salesforceSite = new SalesforceSite(driver);
		props = fetchProperties();
	}

	private Properties fetchProperties() {
		try {
			props = new Properties();
			props.load(new FileInputStream(Constants.PROP_PATH));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}

	@After
	public void after() {
		driver.quit();
	}

	public SalesforceSite getSalesforceSite() {
		return salesforceSite;
	}

}
