package com.sitetracker.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 15);
        this.actions = new Actions(driver);
    }

    protected boolean waitForElements(WebElement ... elems) {
        for(WebElement w: elems)
            if(!wait.until(ExpectedConditions.visibilityOf(w)).isDisplayed())
                return false;
        return true;
    }
}