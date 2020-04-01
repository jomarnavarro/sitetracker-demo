package com.sitetracker.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sitetracker.utils.Properties;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DeveloperGuidePage extends BasePage {

	// page members
	@FindBy(xpath="//input[@name='search']")
	WebElement searchDevGuideTxt;

	@FindBy(xpath="//h4[.='Lightning Web Components Dev Guide']")
	WebElement leftNavHeader;

	@FindBy(xpath="//h1[//span[@id='topic-title']]")
	WebElement mainBodyHeader;

	public DeveloperGuidePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}


	public boolean isAt() {
		return waitForElements(searchDevGuideTxt, leftNavHeader, mainBodyHeader);
	}


    public void goTo() {
		driver.get(Properties.MAIN_URL);
    }
}
