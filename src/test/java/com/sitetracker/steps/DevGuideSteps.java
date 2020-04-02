package com.sitetracker.steps;

import static org.junit.Assert.*;

import com.sitetracker.hooks.Hooks;
import com.sitetracker.sites.SalesforceSite;
import com.sitetracker.utils.Utils;
import io.cucumber.datatable.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;
import com.sitetracker.utils.Constants;

public class DevGuideSteps {
	SalesforceSite salesforceSite;

	public DevGuideSteps(Hooks hooksClass) {
		this.salesforceSite = hooksClass.getSalesforceSite();
	}

    @Given("I navigate to Salesforce Developer page")
    public void iNavigateToSalesforceDeveloperPage() {
		salesforceSite.devGuide().goTo(Constants.MAIN_URL);
		assertTrue(salesforceSite.devGuide().isAt());
    }
}
