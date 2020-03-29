package com.sitetracker.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavPage extends BasePage {

    @FindBy(css = "nav a[title='Component Reference']")
    WebElement componentRefnk;

    @FindBy(css="nav a[title='DeveloperGuide']")
    WebElement devGuideLnk;

    public NavPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isAt() {
        return waitForElements(componentRefnk, devGuideLnk);
    }

    public void clickComponentRefLink() {
        componentRefnk.click();
    }

}
