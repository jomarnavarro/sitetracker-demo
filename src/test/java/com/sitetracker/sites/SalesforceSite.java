package com.sitetracker.sites;

import com.sitetracker.pages.*;
import org.openqa.selenium.WebDriver;

public class SalesforceSite {
    private DeveloperGuidePage devGuide;
    private NavPage nav;
    private ComponentReferenceLeftNavPage componentLeftNav;
    private ComponentReferenceBodyPage componentBody;
    private ComponentPage component;
    private PlaygroundPage playground;
    private WebDriver driver;

    public SalesforceSite(WebDriver driver) {
        this.driver = driver;
    }

    public DeveloperGuidePage getDevGuide() {
        return devGuide;
    }

    public NavPage nav() {
        if(nav == null)
            nav = new NavPage(driver);
        return nav;
    }

    public ComponentReferenceLeftNavPage componentLeftNav() {
        if(componentLeftNav == null)
            componentLeftNav = new ComponentReferenceLeftNavPage(driver);
        return componentLeftNav;
    }

    public ComponentReferenceBodyPage componentBody() {
        if(componentBody == null)
            componentBody = new ComponentReferenceBodyPage(driver);
        return componentBody;
    }

    public ComponentPage component() {
        if(component == null)
            component = new ComponentPage(driver);
        return component;
    }

    public PlaygroundPage playground() {
        if(playground == null)
            playground = new PlaygroundPage(driver);
        return playground;
    }
}
