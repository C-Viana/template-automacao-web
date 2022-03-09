package steps;

import common.General;
import pages.ABTestingVariation1Page;
import reporter.ReportManager;

import org.junit.Assert;

import io.cucumber.java.en.Then;

public class ABTestingVariation1Steps {

    private ABTestingVariation1Page page = null;

    public ABTestingVariation1Steps() {
        page = new ABTestingVariation1Page();
    }

    @Then("verei a página AB Test Variation")
    public void vereiOAPaginaABTestVariation() {
        General.waitToBeVisible( page.getTitle(), 10 );
        Assert.assertTrue( page.getTitleExpectedA().equals(page.getTitle().getText().trim().toString()) || page.getTitleExpectedB().equals(page.getTitle().getText().trim().toString()) );
        Assert.assertEquals(page.getInformationTextExpected(), page.getInformation().getText().trim());
        ReportManager.setTestStep( General.getScenario().getStatus(), "Então verei a página AB Test Variation" );
    }
}
