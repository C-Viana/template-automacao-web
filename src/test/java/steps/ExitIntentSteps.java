package steps;

import common.General;
import pages.ExitIntentPage;
import reporter.ReportManager;

import org.junit.Assert;

import io.cucumber.java.en.*;

public class ExitIntentSteps {

    private ExitIntentPage page = null;
    
    public ExitIntentSteps() {
        page = new ExitIntentPage();
    }

    @And("mover o mouse para fora do viewport")
    public void moverMouseForaViewport() {
        General.waitFor(3);
        Assert.assertTrue("", page.getModal().getAttribute("style").contains("display: none"));
        Assert.assertEquals(page.getTitleTextExpected(), page.getTitle().getText());
        Assert.assertEquals(page.getBodyContentTextExpected(), page.getBodyContent().getText());
        General.moveMouseTo( 10, 150 );
        ReportManager.setTestStep(General.getScenario().getStatus(), "E mover o mouse para fora do viewport");
    }

    @Then("confirmo que o modal de saída é exibido")
    public void confirmoModalExibido() {
        General.waitToBeVisible(page.getModal(), 10);
        Assert.assertTrue("", page.getModal().getAttribute("style").contains("display: block"));
        Assert.assertEquals(page.getModalHeaderTextExpected(), page.getModalHeader().getText().trim());
        Assert.assertEquals(page.getModalBodyTextExpected(), page.getModalBody().getText().trim());
        Assert.assertEquals(page.getModalFooterTextExpected(), page.getModalFooter().getText().trim());
        ReportManager.setTestStep(General.getScenario().getStatus(), "Então confirmo que o modal de saída é exibido");
    }


}
