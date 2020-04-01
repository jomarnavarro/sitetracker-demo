package com.sitetracker.steps;

import com.sitetracker.hooks.Hooks;
import com.sitetracker.sites.SalesforceSite;
import cucumber.api.java.en.Then;

public class SongCreationSteps {

	SalesforceSite salesforceSite;

	public SongCreationSteps(Hooks hooksClass) {
		this.salesforceSite = hooksClass.getSalesforceSite();
	}
}
