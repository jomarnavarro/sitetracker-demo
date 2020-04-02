package com.sitetracker.steps;

import com.sitetracker.hooks.Hooks;
import com.sitetracker.sites.SalesforceSite;
import com.sitetracker.utils.Utils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;

import static org.junit.Assert.assertTrue;

public class PlaygroundSteps {

	SalesforceSite salesforceSite;

	public PlaygroundSteps(Hooks hooksClass) {
		this.salesforceSite = hooksClass.getSalesforceSite();
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
