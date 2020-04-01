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

public class HomeSteps {
	SalesforceSite salesforceSite;

	public HomeSteps(Hooks hooksClass) {
		this.salesforceSite = hooksClass.getSalesforceSite();
	}

    @Given("I navigate to Salesforce Developer page")
    public void iNavigateToSalesforceDeveloperPage() {
		salesforceSite.devGuide().goTo();
		assertTrue(salesforceSite.devGuide().isAt());
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
	public void iOpenInPlayground(String componentExample) {
		salesforceSite.component().selectExampleOption(componentExample);
		assertTrue(salesforceSite.playground().isAt());
	}

	@And("I edit row {int} in preview pane")
	public void iEditRowInPreviewPane(int rowNumber, DataTable dataTable) {
		Utils.fetchParameters(salesforceSite, dataTable);
		salesforceSite.setParameter("row", 3 + "");
		salesforceSite.playground().editRow(rowNumber, salesforceSite.getParameters());
	}

	@Then("Row will be populated with data above")
	public void rowWillBePopulatedWithDataAbove() {
		salesforceSite.playground().validateRow(salesforceSite.getParameters());
	}
}
