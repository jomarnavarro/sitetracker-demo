package com.sitetracker.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
			"src/test/resources/features/salesforceComponents.feature"
		},
        strict = false, plugin = {"pretty",
        "json:target/cucumber_json_reports/login.json",
        "html:target/login-html"},
        glue = {"com.sitetracker.sites",
				"com.sitetracker.pages",
                "com.sitetracker.steps",
                "com.sitetracker.utils",
                "com.sitetracker.hooks"})


public class LoginRunner {}
