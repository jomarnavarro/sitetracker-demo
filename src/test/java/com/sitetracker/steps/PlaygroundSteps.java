package com.sitetracker.steps;

import com.sitetracker.hooks.Hooks;
import com.sitetracker.sites.SalesforceSite;
import com.sitetracker.utils.Utils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.sitetracker.utils.Constants;

public class PlaygroundSteps {

	SalesforceSite salesforceSite;

	public PlaygroundSteps(Hooks hooksClass) {
		this.salesforceSite = hooksClass.getSalesforceSite();
	}

	@And("I edit row {int} in preview pane")
	public void iEditRowInPreviewPane(int rowNumber, DataTable dataTable) {
		Utils.fetchParameters(salesforceSite, dataTable);
		salesforceSite.setParameter("rowNumber", rowNumber + "");
		salesforceSite.playground().editRow(salesforceSite.getParameters());
	}

	@Then("Row will be populated with data above")
	public void rowWillBePopulatedWithDataAbove() {
		assertEquals(salesforceSite.getParameter(Constants.LABEL_COL),
				salesforceSite.playground().getValue(salesforceSite.getParameters(), Constants.LABEL_COL));
		assertEquals(salesforceSite.getParameter(Constants.WEBSITE_COL),
				salesforceSite.playground().getValue(salesforceSite.getParameters(), Constants.WEBSITE_COL));
		assertEquals(salesforceSite.getParameter(Constants.PHONE_COL),
				salesforceSite.playground().getValue(salesforceSite.getParameters(), Constants.PHONE_COL));
		assertEquals("$"+salesforceSite.getParameter(Constants.BALANCE_COL),
				salesforceSite.playground().getValue(salesforceSite.getParameters(), Constants.BALANCE_COL));
		assertEquals(salesforceSite.getParameter(Constants.CLOSE_AT_COL),
				salesforceSite.playground().getValue(salesforceSite.getParameters(), Constants.CLOSE_AT_COL));
//		assertTrue(salesforceSite.playground().validateRows(salesforceSite.getParameters()));
	}

	@And("I select details from last row menu")
	public void iSelectDetailsFromLastRowMenu() {
		salesforceSite.playground().showDetailsLastRow();
	}

	@Then("details will be displayed")
	public void detailsWillBeDisplayed() {
		assertTrue(salesforceSite.playground().validateLastRowDetails());
	}
}
