package com.sitetracker.steps;

import com.sitetracker.hooks.Hooks;
import com.sitetracker.sites.SalesforceSite;
import com.sitetracker.utils.Utils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import static org.junit.Assert.assertTrue;

public class ComponentSteps {
	SalesforceSite salesforceSite;

	public ComponentSteps(Hooks hooksClass) {
		this.salesforceSite = hooksClass.getSalesforceSite();
	}

	@When("I select component from the left nav")
	public void iSelectComponentFromTheLeftNav(DataTable table) {
		Utils.fetchParameters(salesforceSite, table);
		String component = salesforceSite.getParameter("component");
		String path = salesforceSite.getParameter("path");
		salesforceSite.nav().clickComponentRefLink();
		salesforceSite.componentLeftNav().searchComponent(component);
		assertTrue(salesforceSite.componentLeftNav().isComponentListed(path));
		salesforceSite.componentLeftNav().selectComponent(path);
		assertTrue(salesforceSite.component().isAt());
	}

	@And("I open example {string} in Playground")
	public void iOpenInPlayground(String componentExample) throws InterruptedException {
		salesforceSite.component().selectExampleOption(componentExample);
		assertTrue(salesforceSite.playground().isAt());
		Thread.sleep(2000);
	}
}
