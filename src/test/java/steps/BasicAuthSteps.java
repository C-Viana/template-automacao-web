package steps;

import common.General;
import pages.BasicAuthPage;
import reporter.ReportManager;

import org.junit.Assert;

import io.cucumber.java.en.*;

public class BasicAuthSteps {
    private BasicAuthPage page = null;
    
    public BasicAuthSteps() {
        page = new BasicAuthPage();
    }
    
    @Then("realizo a autenticação pelo alert do navegador")
    public void realizoAutenticacaoPeloAlert() {
        page.authenticateByKeyboard("admin", "admin");
        ReportManager.setTestStep(General.getScenario().getStatus(), "Então realizo a autenticação pelo alert do navegador");
        General.typeKeyboardENTER();
    }

    @Then("cancelo a autenticação")
    public void realizoAutenticacaoComDadosInvalidos() {
        page.cancelarAutenticacao();
        ReportManager.setTestStep(General.getScenario().getStatus(), "Então cancelo a autenticação");
    }

    @Then("realizo a autenticação pela URL")
    public void realizoAutenticacaoPelaURL() {
        page.authenticateByURL("admin", "admin");
        ReportManager.setTestStep(General.getScenario().getStatus(), "Então realizo a autenticação pela URL");
    }

    @Then("realizo a autenticação por digest")
    public void realizoAutenticacaoPorDigest() {
        page.authenticateByBasicDigest("admin", "admin");
        ReportManager.setTestStep(General.getScenario().getStatus(), "Então realizo a autenticação por digest");
    }

    @And("valido a tela a tela com falha de autenticação")
    public void validoFalhaAutenticacao() {
        Assert.assertEquals(page.getTextExpectedPageNotAuthorized(), page.getTextPageNotAuthorized().getText().trim());
        ReportManager.setTestStep(General.getScenario().getStatus(), "E valido a tela a tela com falha de autenticação");
    }

    @And("valido a tela a tela de autenticação bem sucedida")
    public void validoSucessoAutenticacao() {
        Assert.assertEquals(page.getTextExpectedPageTitle(), page.getPageTitle().getText().trim());
        Assert.assertEquals(page.getTextExpectedPageInformation(), page.getPageInformation().getText().trim());
        ReportManager.setTestStep(General.getScenario().getStatus(), "E valido a tela a tela de autenticação bem sucedida");
    }

}
