package steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.ExitIntentPage;
import reporter.ReportManager;

public class ExitIntentSteps {

    private ExitIntentPage page = null;
    
    public ExitIntentSteps() {
        page = new ExitIntentPage();
    }

    @And("mover o mouse para fora do viewport")
    public void moverMouseForaViewport() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertTrue("", page.getModal().getAttribute("style").contains("display: none"));
        Assert.assertEquals(page.getTitleTextExpected(), page.getTitle().getText());
        Assert.assertEquals(page.getBodyContentTextExpected(), page.getBodyContent().getText());
        page.moverMouseForaDaTela();
    }

    @Then("confirmo que o modal de saída é exibido")
    public void confirmoModalExibido() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
    	page.waitModal();
        Assert.assertTrue("", page.getModal().getAttribute("style").contains("display: block"));
        Assert.assertEquals(page.getModalHeaderTextExpected(), page.getModalHeader().getText().trim());
        Assert.assertEquals(page.getModalBodyTextExpected(), page.getModalBody().getText().trim());
        Assert.assertEquals(page.getModalFooterTextExpected(), page.getModalFooter().getText().trim());
    }


}
