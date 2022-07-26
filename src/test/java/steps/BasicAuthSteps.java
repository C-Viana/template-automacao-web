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
        page.authenticateByKeyboard("admin", "admin");
        ReportManager.setTestStep(ReportManager.getScenario().getStatus(), "Então realizo a autenticação pelo alert do navegador");
        page.teclarEnter();
    }

    @Then("cancelo a autenticação")
    public void realizoAutenticacaoComDadosInvalidos() {
        page.cancelarAutenticacao();
        ReportManager.setTestStep(ReportManager.getScenario().getStatus(), "Então cancelo a autenticação");
    }

    @Then("realizo a autenticação pela URL")
    public void realizoAutenticacaoPelaURL() {
        page.authenticateByURL("admin", "admin");
        ReportManager.setTestStep(ReportManager.getScenario().getStatus(), "Então realizo a autenticação pela URL");
    }

    @And("valido a tela a tela com falha de autenticação")
    public void validoFalhaAutenticacao() {
        Assert.assertEquals(page.getTextExpectedPageNotAuthorized(), page.getTextPageNotAuthorized().getText().trim());
        ReportManager.setTestStep(ReportManager.getScenario().getStatus(), "E valido a tela a tela com falha de autenticação");
    }

    @And("valido a tela a tela de autenticação bem sucedida")
    public void validoSucessoAutenticacao() {
        Assert.assertEquals(page.getTextExpectedPageTitle(), page.getPageTitle().getText().trim());
        Assert.assertEquals(page.getTextExpectedPageInformation(), page.getPageInformation().getText().trim());
        ReportManager.setTestStep(ReportManager.getScenario().getStatus(), "E valido a tela a tela de autenticação bem sucedida");
    }

}
