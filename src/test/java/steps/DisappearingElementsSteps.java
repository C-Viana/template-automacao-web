package steps;

import common.General;
import pages.DisappearingElementsPage;
import reporter.ReportManager;

import org.junit.Assert;

import io.cucumber.java.en.*;

public class DisappearingElementsSteps {

    private DisappearingElementsPage page = null;
    
    public DisappearingElementsSteps() {
        page = new DisappearingElementsPage();
    }

    @Then("confirmo o acesso à Disapearing Elements")
    public void confirmoAcessoDisapearingElements() {
        General.waitToBeVisible(page.getTitle(), 6);
        Assert.assertEquals(page.getTitleExpected(), page.getTitle().getText().trim());
        Assert.assertEquals(page.getDescriptionExpected(), page.getDescription().getText().trim());
        Assert.assertEquals(page.getBtnHomeTextExpected(), page.getBtnHome().getText().trim());
        Assert.assertEquals(page.getBtnAboutTextExpected(), page.getBtnAbout().getText().trim());
        Assert.assertEquals(page.getBtnContactUsTextExpected(), page.getBtnContactUs().getText().trim());
        Assert.assertEquals(page.getBtnPortfolioTextExpected(), page.getBtnPortfolio().getText().trim());
        ReportManager.setTestStep(General.getScenario().getStatus(), "Então confirmo o acesso à página Disapearing Elements");
    }

    @And("valido que o botão Gallery é exibido após atualização")
    public void validoBotaoGalleryExibidoAposAtualizacao() {
        Assert.assertFalse("Botão 'Gallery' está visível antes da atualização da página", General.elementExists(page.getBtnGallery()));
        General.refreshPage();
        for (int i = 0; i < 5; i++) {
            if (General.waitToBeVisibleIgnoringExceptions(page.getBtnGallery(), 5) == null)
                General.refreshPage();
        }
        Assert.assertEquals(page.getBtnGalleryTextExpected(), page.getBtnGallery().getText().trim());
        ReportManager.setTestStep(General.getScenario().getStatus(), "E valido as opções disponíveis");
    }

    @And("valido que o botão Gallery não é exibido após atualização")
    public void validoBotaoGalleryNaoExibidoAposAtualizacao() {
        for (int i = 0; i < 5; i++) {
            if (!General.elementExists(page.getBtnGallery()))
                General.refreshPage();
            else
                break;
        }
        Assert.assertEquals(page.getBtnGalleryTextExpected(), page.getBtnGallery().getText().trim());

        for (int i = 0; i < 5; i++) {
            if (General.waitToBeVisibleIgnoringExceptions(page.getBtnGallery(), 5) != null)
                General.refreshPage();
            else
                break;
        }
        Assert.assertFalse("Botão 'Gallery' está visível após atualização da página", General.elementExists(page.getBtnGallery()));
        ReportManager.setTestStep(General.getScenario().getStatus(), "E valido as opções disponíveis");
    }
    

}
