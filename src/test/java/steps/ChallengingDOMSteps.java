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
        Assert.assertEquals(page.getExpectedTextTitle(), page.getCurrentTextTitle());
        ReportManager.setTestStep("Então confirmo o acesso à página Challenging DOM");
    }

    @And("valido o conteúdo do canvas")
    public void validoImagensTela() {
        String test = page.getTextoDoCanvas();
        Assert.assertNotNull(test);
        ReportManager.setTestLog("Texto identificado pelo canvas: " + test);
        ReportManager.setTestStep("E valido o conteúdo do canvas");
    }

    @Then("clico no botão {string}")
    public void clicoNoBotaoCor(String cor) {
        page.clickButtonByColor(cor);
        ReportManager.setTestStep("Então clico no botão "+cor);
    }

    @Then("capturo a tabela da página")
    public void capturoATabelaPagina() {
        WebElement[][] table = page.getTableValues(page.getTableRowsCount(), page.getTableColsCount());
        page.printTable(table, page.getTableRowsCount(), page.getTableColsCount());
        ReportManager.setTestStep("Então capturo a tabela da página");
    }

}
