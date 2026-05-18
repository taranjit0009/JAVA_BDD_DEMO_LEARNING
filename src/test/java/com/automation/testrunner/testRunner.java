package com.automation.testrunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/com/automation/features", glue = { "com.automation.stepdefinitions",
		"com.automation.hooks" }, monochrome = true, plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"

})
public class testRunner extends AbstractTestNGCucumberTests{
	static {
		String  timestamp = new SimpleDateFormat("yyyyMMdd_hh-mm-ss-a").format(new Date());
		System.setProperty("extent.reporter.spark.out", "target/Reports/AutomationReport_"+timestamp+".html");
	}
}
