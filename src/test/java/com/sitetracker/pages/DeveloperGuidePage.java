package com.sitetracker.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sitetracker.utils.Properties;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DeveloperGuidePage extends BasePage {

	// page members
	@FindBy(css="div.pane-left")
	WebElement leftNavPane;

	@FindBy(id="topic-title")
	WebElement bodyPane;

	public DeveloperGuidePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}


	public boolean isAt() {
		return waitForElements(leftNavPane, bodyPane);
	}


}
