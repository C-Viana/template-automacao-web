package steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.DynamicLoadingPage;
import reporter.ReportManager;

public class DynamicLoadingSteps {

    private DynamicLoadingPage page = null;
    
    public DynamicLoadingSteps() {
        page = new DynamicLoadingPage();
    }

    @Then("confirmo o acesso à página Dynamic Loading")
    public void confirmoAcessPaginaDynamicLoading() {
        Assert.assertEquals(page.getLinkExample1TextExpected(), page.getLinkExample1().getText().trim());
        Assert.assertEquals(page.getLinkExample2TextExpected(), page.getLinkExample2().getText().trim());
        ReportManager.setTestStep("Então confirmo o acesso à página Dynamic Loading");
    }

    @And("selecionar o link do exemplo 1")
    public void selecionarLinkExemplo1() {
        page.getLinkExample1().click();
        page.getBtnStart();
        ReportManager.setTestStep("E selecionar o link do exemplo 1");
    }

    @Then("confirmo que há um elemento oculto")
    public void confirmoHaElementoOculto() {
        Assert.assertTrue("Elemento oculto deveria ser identificado.", page.getHiddenElement().getAttribute("style").contains("display: none;"));
        ReportManager.setTestStep("Então confirmo que há um elemento oculto");
    }

    @And("habilito esse elemento na página")
    public void habilitoElementoPagina() {
        Assert.assertEquals(page.getBtnStartTextExpected(), page.getBtnStart().getText().trim());
        page.getBtnStart().click();
        ReportManager.setTestStep("Clicando no botão 'Start'");
        Assert.assertEquals(page.getLoadingTextExpected(), page.getLoading().getText().trim());
        Assert.assertFalse("", page.getHiddenElement().getAttribute("style").contains("display: none;"));
        Assert.assertEquals(page.getHiddenElementContentTextExpected(), page.getHiddenElementContent().getText().trim());
        ReportManager.setTestStep("E habilito esse elemento na página");
    }

    @And("selecionar o link do exemplo 2")
    public void selecionarLinkExemplo2() {
        page.getLinkExample2().click();
        page.getBtnStart();
        ReportManager.setTestStep("E selecionar o link do exemplo 2");
    }

    @Then("confirmo que não há elemento oculto")
    public void confirmoNaoHaElementoOculto() {
        Assert.assertFalse("Elemento oculto deveria ser identificado.", page.hiddenElementExistis());
        ReportManager.setTestStep("Então confirmo que não há elemento oculto");
    }

    
   
    

}
