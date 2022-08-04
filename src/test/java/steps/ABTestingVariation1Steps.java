package steps;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import pages.ABTestingVariation1Page;
import reporter.ReportManager;

public class ABTestingVariation1Steps {

    private ABTestingVariation1Page page = null;

    public ABTestingVariation1Steps() {
        page = new ABTestingVariation1Page();
    }

    @Then("verei a página AB Test Variation")
    public void vereiOAPaginaABTestVariation() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertTrue( page.getTitleExpectedA().equals(page.getTitle().getText().trim().toString()) || page.getTitleExpectedB().equals(page.getTitle().getText().trim().toString()) );
        Assert.assertEquals(page.getInformationTextExpected(), page.getInformation().getText().trim());
    }
    
}
