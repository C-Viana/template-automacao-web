package steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.DigestAuthenticationPage;
import reporter.ReportManager;

public class DigestAuthenticationSteps {
    private DigestAuthenticationPage page = null;
    
    public DigestAuthenticationSteps() {
        page = new DigestAuthenticationPage();
    }

    @Then("realizo a autenticação por digest")
    public void realizoAutenticacaoPorDigest() {
        page.authenticateByBasicDigest("admin", "admin");
        ReportManager.setTestStep("Então realizo a autenticação por digest");
    }

    @And("valido falha de autenticação via digest")
    public void validoFalhaAutenticacao() {
        Assert.assertEquals(page.getTextExpectedPageNotAuthorized(), page.getTextPageNotAuthorized().getText().trim());
        ReportManager.setTestStep("E valido falha de autenticação via digest");
    }

    @And("valido sucesso de autenticação via digest")
    public void validoSucessoAutenticacao() {
        Assert.assertEquals(page.getTextExpectedPageTitle(), page.getPageTitle().getText().trim());
        Assert.assertEquals(page.getTextExpectedPageInformation(), page.getPageInformation().getText().trim());
        ReportManager.setTestStep("E valido sucesso de autenticação via digest");
    }

}
