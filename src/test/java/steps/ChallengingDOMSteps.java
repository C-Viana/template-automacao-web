package steps;

import common.General;
import pages.ChallengingDOMPage;
import reporter.ReportManager;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.*;

public class ChallengingDOMSteps {

    private ChallengingDOMPage page = null;
    
    public ChallengingDOMSteps() {
        page = new ChallengingDOMPage();
    }

    @Then("confirmo o acesso à página Challenging DOM")
    public void confirmoAcessoPaginaChallengingDOM() {
        General.waitToBeVisible(page.getTitle(), 6);
        Assert.assertEquals(page.getExpectedTextTitle(), page.getCurrentTextTitle());
        ReportManager.setTestStep(General.getScenario().getStatus(), "Então confirmo o acesso à página Challenging DOM");
    }

    @And("valido o conteúdo do canvas")
    public void validoImagensTela() {
        String test = General.getTextFromImage(page.getCanvasAsImage());
        Assert.assertNotNull(test);
        ReportManager.setTestLog("Texto identificado pelo canvas: " + test);
        ReportManager.setTestStep(General.getScenario().getStatus(), "E valido o conteúdo do canvas");
    }

    @Then("clico no botão {string}")
    public void clicoNoBotaoCor(String cor) {
        General.waitToBeVisible(page.getButton(0), 6);
        page.clickButtonByColor(cor);
        ReportManager.setTestStep(General.getScenario().getStatus(), "Então clico no botão "+cor);
    }

    @Then("capturo a tabela da página")
    public void capturoATabelaPagina() {
        WebElement[][] table = page.getTableValues(page.getTableRowsCount(), page.getTableColsCount());
        page.printTable(table, page.getTableRowsCount(), page.getTableColsCount());
        ReportManager.setTestStep(General.getScenario().getStatus(), "Então capturo a tabela da página");
    }

}
