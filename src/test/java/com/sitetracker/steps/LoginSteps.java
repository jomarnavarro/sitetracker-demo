package com.sitetracker.steps;

import com.sitetracker.hooks.Hooks;
import com.sitetracker.sites.SalesforceSite;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	SalesforceSite salesforceSite;

	public LoginSteps(Hooks hooksClass) {
		this.salesforceSite = hooksClass.getSalesforceSite();
	}
}
