package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import reporter.ReportManager;

import common.General;
import common.StaticResources;
import driver.Driver;

public class _Hooks {

	@BeforeAll
	public static void beforeAll() {
		StaticResources.suite_test = true;
	}

	@AfterAll
	public static void afterAll() {
		if (StaticResources.suite_test) ReportManager.endReport();
	}

	@Before
	public void startTest( Scenario scenario ) {
		General.scenario = scenario;
		ReportManager.setResultPath( scenario.getUri().toString(), General.scenario.getName() );
		ReportManager.startReport();
		ReportManager.startTest( General.scenario.getName() );
	}
	
	@After
	public void endTest() {
		ReportManager.endTest();
		if(!StaticResources.suite_test) 
			ReportManager.endReport();
		Driver.close();
	}
}
