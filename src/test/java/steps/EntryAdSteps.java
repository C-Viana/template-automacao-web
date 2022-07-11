package steps;

import common.General;
import pages.EntryAdPage;
import reporter.ReportManager;

import org.junit.Assert;

import io.cucumber.java.en.*;

public class EntryAdSteps {

    private EntryAdPage page = null;
    
    public EntryAdSteps() {
        page = new EntryAdPage();
    }

    @Then("confirmo que o modal é exibido")
    public void a() {
        General.waitToBeVisible(page.getTitle(), 5);
        Assert.assertEquals(page.getTitleTextExpected(), page.getTitle().getText().trim());
        General.waitToBeVisible(page.getModal(), 5);
        Assert.assertTrue("", page.getModal().getAttribute("style").contains("display: block"));
        Assert.assertEquals(page.getModalHeaderTextExpected(), page.getModalHeader().getText().trim());
        Assert.assertEquals(page.getModalBodyTextExpected(), page.getModalBody().getText().trim());
        Assert.assertEquals(page.getModalFooterTextExpected(), page.getModalFooter().getText().trim());
        ReportManager.setTestStep(General.getScenario().getStatus(), "Então confirmo que o modal é exibido");
    }

    @And("encerro a exibição do modal")
    public void b() {
        page.getModalFooter().click();
        General.waitFor(3);
        Assert.assertTrue("", page.getModal().getAttribute("style").contains("display: none"));
        Assert.assertEquals(page.getLinkClickHereTextExpected(), page.getLinkClickHere().getText().trim());
        ReportManager.setTestStep(General.getScenario().getStatus(), "E encerro a exibição do modal");
    }


}
