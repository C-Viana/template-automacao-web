package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import reporter.ReportManager;

import common.General;
import driver.Driver;

public class _Hooks {

	@BeforeAll
	public static void beforeAll() {
		
	}

	@AfterAll
	public static void afterAll() {
		ReportManager.endReport();
	}

	@Before
	public void startTest( Scenario scenario ) {
		General.scenario = scenario;
		ReportManager.setResultPath( scenario.getUri().toString(), General.scenario.getName() );
		ReportManager.startReport( scenario.getUri().toString() );
		ReportManager.startTest( General.scenario.getName() );
	}
	
	@After
	public void endTest() {
		ReportManager.endTest();
		Driver.get().close();
	}
}
