package com.sitetracker.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComponentPage extends BasePage {

    @FindBy(css="[class='slds-card'] h2[title='datatable']")
    WebElement pageHeader;

    @FindBy(xpath="//*[@class='slds-card;]//*[text() = 'Lightning Web Component']")
    WebElement componentTypeHeader;

    @FindBy(css="[id='example__item']")
    WebElement exampleTab;

    @FindBy(css="[id='documentation__item']")
    WebElement documentationTab;

    @FindBy(css="[id='specification__item']")
    WebElement specificationTab;

    @FindBy(name="example")
    WebElement exampleInput;

    @FindBy(linkText="Open in Playground")
    WebElement openInPlaygroundBtn;

    //Dyn object
    String inlineEditPartLnkTxt = "Inline Edit";

    public ComponentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isAt() {
        return this.waitForElements(pageHeader, componentTypeHeader, exampleTab,
                documentationTab, specificationTab, exampleInput,
                openInPlaygroundBtn);
    }

    public void selectExampleOption(String option) {

    }
}
