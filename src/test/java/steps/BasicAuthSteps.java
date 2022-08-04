package steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.BasicAuthPage;
import reporter.ReportManager;

public class BasicAuthSteps {
    private BasicAuthPage page = null;
    
    public BasicAuthSteps() {
        page = new BasicAuthPage();
    }
    
    @Then("realizo a autenticação pelo alert do navegador")
    public void realizoAutenticacaoPeloAlert() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        page.authenticateByKeyboard("admin", "admin");
        page.teclarEnter();
    }

    @Then("cancelo a autenticação")
    public void realizoAutenticacaoComDadosInvalidos() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        page.cancelarAutenticacao();
    }

    @Then("realizo a autenticação pela URL")
    public void realizoAutenticacaoPelaURL() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        page.authenticateByURL("admin", "admin");
    }

    @And("valido a tela a tela com falha de autenticação")
    public void validoFalhaAutenticacao() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(page.getTextExpectedPageNotAuthorized(), page.getTextPageNotAuthorized().getText().trim());
    }

    @And("valido a tela a tela de autenticação bem sucedida")
    public void validoSucessoAutenticacao() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(page.getTextExpectedPageTitle(), page.getPageTitle().getText().trim());
        Assert.assertEquals(page.getTextExpectedPageInformation(), page.getPageInformation().getText().trim());
    }

}
