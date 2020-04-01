package com.sitetracker.pages;

import org.openqa.selenium.JavascriptExecutor;
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
        for(WebElement w: elems) {
            WebElement elem = wait.until(ExpectedConditions.visibilityOf(w));
            if (!elem.isDisplayed())
                return false;
        }
        return true;
    }

    protected void jsClick(WebElement elem) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem );
    }
}