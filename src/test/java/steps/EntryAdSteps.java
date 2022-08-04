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
    public void confirmoQueModalEExibido() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(page.getTitleTextExpected(), page.getTitle().getText().trim());
        Assert.assertTrue("", page.getModal().getAttribute("style").contains("display: block"));
        Assert.assertEquals(page.getModalHeaderTextExpected(), page.getModalHeader().getText().trim());
        Assert.assertEquals(page.getModalBodyTextExpected(), page.getModalBody().getText().trim());
        Assert.assertEquals(page.getModalFooterTextExpected(), page.getModalFooter().getText().trim());
    }

    @And("encerro a exibição do modal")
    public void encerroExibicaoModal() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        page.getModalFooter().click();
        Assert.assertTrue("", page.getModal().getAttribute("style").contains("display: none"));
        Assert.assertEquals(page.getLinkClickHereTextExpected(), page.getLinkClickHere().getText().trim());
    }

}
