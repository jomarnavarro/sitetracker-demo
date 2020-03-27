package com.sitetracker.steps;

import com.sitetracker.hooks.Hooks;
import com.sitetracker.sites.SalesforceSite;
import cucumber.api.java.en.Then;

public class SongCreationSteps {

	SalesforceSite salesforceSite;

	public SongCreationSteps(Hooks hooksClass) {
		this.salesforceSite = hooksClass.getSalesforceSite();
	}
	@Then("I will be able to Add a Song")
	public void i_will_be_able_to_Add_a_Song() {
	    // trabajamos en dos paginas: Home page y SongsListPage
		salesforceSite.home().listSongs();
		salesforceSite.songList().validateCreateSongLinkDisplayed();
	}
}
