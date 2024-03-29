package steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.DisappearingElementsPage;
import reporter.ReportManager;

public class DisappearingElementsSteps {

    private DisappearingElementsPage page = null;
    
    public DisappearingElementsSteps() {
        page = new DisappearingElementsPage();
    }

    @Then("confirmo o acesso à Disapearing Elements")
    public void confirmoAcessoDisapearingElements() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(page.getTitleExpected(), page.getTitle().getText().trim());
        Assert.assertEquals(page.getDescriptionExpected(), page.getDescription().getText().trim());
        Assert.assertEquals(page.getBtnHomeTextExpected(), page.getBtnHome().getText().trim());
        Assert.assertEquals(page.getBtnAboutTextExpected(), page.getBtnAbout().getText().trim());
        Assert.assertEquals(page.getBtnContactUsTextExpected(), page.getBtnContactUs().getText().trim());
        Assert.assertEquals(page.getBtnPortfolioTextExpected(), page.getBtnPortfolio().getText().trim());
    }

    @And("valido que o botão Gallery é exibido após atualização")
    public void validoBotaoGalleryExibidoAposAtualizacao() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
    	for (int i = 0; i < 3; i++) {
            if (page.btnGaleriaIsVisible())
                page.atualizarTela();
            else
            	break;
        }
    	
        Assert.assertFalse("Botão 'Gallery' está visível antes da atualização da página", page.btnGaleriaIsVisible());
        page.atualizarTela();
        for (int i = 0; i < 5; i++) {
            if (page.aguardarBtnGaleria() == null)
                page.atualizarTela();
        }
        Assert.assertEquals(page.getBtnGalleryTextExpected(), page.getBtnGallery().getText().trim());
    }

    @And("valido que o botão Gallery não é exibido após atualização")
    public void validoBotaoGalleryNaoExibidoAposAtualizacao() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        for (int i = 0; i < 5; i++) {
            if (!page.btnGaleriaIsVisible())
            	page.atualizarTela();
            else
                break;
        }
        Assert.assertEquals(page.getBtnGalleryTextExpected(), page.getBtnGallery().getText().trim());

        for (int i = 0; i < 5; i++) {
            if (page.aguardarBtnGaleria() != null)
            	page.atualizarTela();
            else
                break;
        }
        Assert.assertFalse("Botão 'Gallery' está visível após atualização da página", page.btnGaleriaIsVisible());
    }
    

}
