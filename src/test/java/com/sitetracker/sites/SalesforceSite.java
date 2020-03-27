package com.sitetracker.sites;

import com.sitetracker.pages.*;
import org.openqa.selenium.WebDriver;

public class SalesforceSite {
    private DeveloperGuidePage home;
    private LoginPage login;
    private SongInfoPage songInfo;
    private SongsListPage songList;
    private SongCreationPage songCreation;
    private WebDriver driver;

    public SalesforceSite(WebDriver driver) {
        this.driver = driver;
    }

    public DeveloperGuidePage home() {
        if(home == null) {
            return new DeveloperGuidePage(driver);
        }
        return home;
    }

    public LoginPage login() {
        if(home == null) {
            return new LoginPage(driver);
        }
        return login;
    }

    public SongInfoPage songInfo() {
        if(songInfo == null) {
            return new SongInfoPage(driver);
        }
        return songInfo;
    }

    public SongsListPage songList() {
        if(songList == null) {
            return new SongsListPage(driver);
        }
        return songList;
    }

    public SongCreationPage songCreation() {
        if(songCreation == null) {
            return new SongCreationPage(driver);
        }
        return songCreation;
    }
}
