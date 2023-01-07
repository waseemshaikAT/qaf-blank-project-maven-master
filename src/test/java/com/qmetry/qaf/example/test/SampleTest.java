package com.qmetry.qaf.example.test;

import static com.qmetry.qaf.automation.step.CommonStep.get;
import static com.qmetry.qaf.automation.step.CommonStep.verifyLinkWithPartialTextPresent;
import static com.qmetry.qaf.automation.step.client.RuntimeScenarioFactory.scenario;
import static com.qmetry.qaf.example.steps.StepsLibrary.searchFor;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class SampleTest extends WebDriverTestCase {

	@Test
	public void testGoogleSearch() {
		get("/");
		searchFor("qaf github infostretch");
		verifyLinkWithPartialTextPresent("qaf");
	}
	@Test
	public void reRun(){
		scenario().given("I am lauching chrome page",()-> {
			get("/");
		}).when("I am searching for git hub",()->{
			searchFor("qaf github infostretch");
		}).then("I verify link",()->{
			verifyLinkWithPartialTextPresent("qaf");
		}).execute();
	}
}
