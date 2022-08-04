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
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(page.getLinkExample1TextExpected(), page.getLinkExample1().getText().trim());
        Assert.assertEquals(page.getLinkExample2TextExpected(), page.getLinkExample2().getText().trim());
    }

    @And("selecionar o link do exemplo 1")
    public void selecionarLinkExemplo1() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        page.getLinkExample1().click();
        page.getBtnStart();
    }

    @Then("confirmo que há um elemento oculto")
    public void confirmoHaElementoOculto() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertTrue("Elemento oculto deveria ser identificado.", page.getHiddenElement().getAttribute("style").contains("display: none;"));
    }

    @And("habilito esse elemento na página")
    public void habilitoElementoPagina() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(page.getBtnStartTextExpected(), page.getBtnStart().getText().trim());
        page.getBtnStart().click();
        ReportManager.setTestStep("Clicando no botão 'Start'");
        Assert.assertEquals(page.getLoadingTextExpected(), page.getLoading().getText().trim());
        Assert.assertFalse("", page.getHiddenElement().getAttribute("style").contains("display: none;"));
        Assert.assertEquals(page.getHiddenElementContentTextExpected(), page.getHiddenElementContent().getText().trim());
    }

    @And("selecionar o link do exemplo 2")
    public void selecionarLinkExemplo2() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        page.getLinkExample2().click();
        page.getBtnStart();
    }

    @Then("confirmo que não há elemento oculto")
    public void confirmoNaoHaElementoOculto() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertFalse("Elemento oculto deveria ser identificado.", page.hiddenElementExistis());
    }

    
   
    

}
