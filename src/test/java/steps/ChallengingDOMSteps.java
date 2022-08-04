package steps;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.ChallengingDOMPage;
import reporter.ReportManager;

public class ChallengingDOMSteps {

    private ChallengingDOMPage page = null;
    
    public ChallengingDOMSteps() {
        page = new ChallengingDOMPage();
    }

    @Then("confirmo o acesso à página Challenging DOM")
    public void confirmoAcessoPaginaChallengingDOM() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(page.getExpectedTextTitle(), page.getCurrentTextTitle());
    }

    @And("valido o conteúdo do canvas")
    public void validoImagensTela() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        String test = page.getTextoDoCanvas();
        Assert.assertNotNull(test);
        ReportManager.setTestLog("Texto identificado pelo canvas: " + test);
    }

    @Then("clico no botão {string}")
    public void clicoNoBotaoCor(String cor) {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString().replace("{string}", cor));
        page.clickButtonByColor(cor);
    }

    @Then("capturo a tabela da página")
    public void capturoATabelaPagina() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        WebElement[][] table = page.getTableValues(page.getTableRowsCount(), page.getTableColsCount());
        page.printTable(table, page.getTableRowsCount(), page.getTableColsCount());
    }

}
