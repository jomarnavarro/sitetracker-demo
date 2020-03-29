package com.sitetracker.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ComponentReferenceLeftNavPage extends BasePage {

    @FindBy(name="Quick Find")
    WebElement quickFindTxt;

    @FindBy(xpath="//h3[.='Lightning Web Components']")
    WebElement lightningWebComponentsSection;

    @FindBy(xpath="//h3[contains(.,' Aura')]")
    WebElement auraSection;

    //dyn element
    By componentLblLinkText = By.linkText("datatable");

    String componentLabelXpath =
            "//h3[contains(.,'%s')]/following-sibling::*//h4[.='%s']/following-sibling::*" +
            "//div[.='%s']/following-sibling::*//a[.='%s']";

    public ComponentReferenceLeftNavPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void searchComponent(String compoName) {
        quickFindTxt.clear();
        quickFindTxt.sendKeys(compoName);
    }

    public boolean isComponentListed(String componentPath) {
        String[] path = componentPath.split(">");
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(
                                String.format(componentLabelXpath, path[0], path[1], path[2], path[3])
                        )
                )
        ).isDisplayed();
    }

    public void selectComponent(String componentPath) {

    }

}
