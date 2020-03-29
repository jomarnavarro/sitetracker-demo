package com.sitetracker.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class PlaygroundPage extends BasePage {

    @FindBy(css="[title='Data Table with Inline Edit']")
    WebElement header;

    @FindBy(xpath="//h1[@slot='title' and .='Project']")
    WebElement projectHeader;

    @FindBy(xpath="//h1[@slot='title' and .='Project Files']")
    WebElement projectFilesHeader;

    @FindBy(xpath="//h1[contains(@class, 'title') and contains(.,'Editing')]")
    WebElement editingHeader;

    @FindBy(xpath="//h1[contains(@class, 'title') and .='Preview']")
    WebElement previewHeader;

    @FindBy(css="table.slds-table_edit")
    WebElement dataTbl;

    public PlaygroundPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isAt() {
        return waitForElements(header, projectHeader, projectFilesHeader,
                editingHeader, previewHeader, dataTbl);
    }

    public void editRow(int rowNumber, HashMap<String, String> rowData) {

    }

}
