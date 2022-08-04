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
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        page.authenticateByBasicDigest("admin", "admin");
    }

    @And("valido falha de autenticação via digest")
    public void validoFalhaAutenticacao() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(page.getTextExpectedPageNotAuthorized(), page.getTextPageNotAuthorized().getText().trim());
    }

    @And("valido sucesso de autenticação via digest")
    public void validoSucessoAutenticacao() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(page.getTextExpectedPageTitle(), page.getPageTitle().getText().trim());
        Assert.assertEquals(page.getTextExpectedPageInformation(), page.getPageInformation().getText().trim());
    }

}
