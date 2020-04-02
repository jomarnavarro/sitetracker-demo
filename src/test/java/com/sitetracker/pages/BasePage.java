package com.sitetracker.pages;

import com.sitetracker.utils.Constants;
import org.openqa.selenium.By;
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
            WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(w));
            if (!elem.isDisplayed())
                return false;
        }
        return true;
    }

    protected void jsClick(WebElement elem) {

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
        sleep(Constants.SHORT_WAIT);
    }

    protected void jsClick(By by) {
        this.jsClick(wait.until(ExpectedConditions.elementToBeClickable(by)));
    }

    protected void jsClick(String xpath) {
        this.jsClick(By.xpath(xpath));
    }

    protected void moveToElement(WebElement elem) {
        actions.moveToElement(elem).build();
    }

    protected void moveToElement(By by) {
        moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(by)));
    }

    protected void moveToElement(String xpath) {
        moveToElement(By.xpath(xpath));
    }


    protected void jsReset(WebElement elem) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", elem);
        sleep(Constants.SHORT_WAIT);
    }

    protected void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}