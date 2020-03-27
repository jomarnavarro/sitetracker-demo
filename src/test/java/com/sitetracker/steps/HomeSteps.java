package com.sitetracker.steps;

import static org.junit.Assert.*;

import com.sitetracker.hooks.Hooks;
import com.sitetracker.sites.SalesforceSite;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HomeSteps {
	SalesforceSite salesforceSite;

	public HomeSteps(Hooks hooksClass) {
		this.salesforceSite = hooksClass.getSalesforceSite();
	}

	@Given("I navigate to Home Page")
	public void i_navigate_to_Home_Page() {
	    salesforceSite.home().goTo();
	}

	
	@Then("I will be in Home Page")
	public void i_will_be_in_Home_Page() {
	    assertTrue(salesforceSite.home().isAt());
	}
}
