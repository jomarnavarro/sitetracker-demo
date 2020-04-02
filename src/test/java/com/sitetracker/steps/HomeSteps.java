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

public class HomeSteps {
	SalesforceSite salesforceSite;

	public HomeSteps(Hooks hooksClass) {
		this.salesforceSite = hooksClass.getSalesforceSite();
	}

    @Given("I navigate to Salesforce Developer page")
    public void iNavigateToSalesforceDeveloperPage() {
		salesforceSite.devGuide().goTo(Constants.MAIN_URL);
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
	public void iOpenInPlayground(String componentExample) throws InterruptedException {
		salesforceSite.component().selectExampleOption(componentExample);
		assertTrue(salesforceSite.playground().isAt());
		Thread.sleep(2000);
	}

	@And("I edit row {int} in preview pane")
	public void iEditRowInPreviewPane(int rowNumber, DataTable dataTable) {
		Utils.fetchParameters(salesforceSite, dataTable);
		salesforceSite.setParameter("rowNumber", 3 + "");
		salesforceSite.playground().editRow(salesforceSite.getParameters());
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Row will be populated with data above")
	public void rowWillBePopulatedWithDataAbove() {
		assertTrue(salesforceSite.playground().validateRows(salesforceSite.getParameters()));
	}

	@And("I select details from last row menu")
	public void iSelectDetailsFromLastRowMenu() {
		salesforceSite.playground().showDetailsLastRow();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("details will be displayed")
	public void detailsWillBeDisplayed() {
		assertTrue(salesforceSite.playground().validateLastRowDetails());
	}
}
