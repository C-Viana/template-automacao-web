package steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.EntryAdPage;
import reporter.ReportManager;

public class EntryAdSteps {

    private EntryAdPage page = null;
    
    public EntryAdSteps() {
        page = new EntryAdPage();
    }

    @Then("confirmo que o modal é exibido")
    public void a() {
        Assert.assertEquals(page.getTitleTextExpected(), page.getTitle().getText().trim());
        Assert.assertTrue("", page.getModal().getAttribute("style").contains("display: block"));
        Assert.assertEquals(page.getModalHeaderTextExpected(), page.getModalHeader().getText().trim());
        Assert.assertEquals(page.getModalBodyTextExpected(), page.getModalBody().getText().trim());
        Assert.assertEquals(page.getModalFooterTextExpected(), page.getModalFooter().getText().trim());
        ReportManager.setTestStep("Então confirmo que o modal é exibido");
    }

    @And("encerro a exibição do modal")
    public void b() {
        page.getModalFooter().click();
        Assert.assertTrue("", page.getModal().getAttribute("style").contains("display: none"));
        Assert.assertEquals(page.getLinkClickHereTextExpected(), page.getLinkClickHere().getText().trim());
        ReportManager.setTestStep("E encerro a exibição do modal");
    }


}
