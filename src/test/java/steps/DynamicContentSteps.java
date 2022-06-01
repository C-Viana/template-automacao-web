package steps;

import common.General;
import pages.DynamicContentPage;
import reporter.ReportManager;

import org.junit.Assert;

import io.cucumber.java.en.*;

public class DynamicContentSteps {

    private DynamicContentPage page = null;
    
    public DynamicContentSteps() {
        page = new DynamicContentPage();
    }

    @Then("confirmo o acesso à página Dynamic Content")
    public void confirmoAcessPaginaDynamicContent() {
        General.waitToBeVisible(page.getTitle(), 5);
        Assert.assertEquals(page.getExpectedTextTitle(), page.getTitle().getText().trim());
        ReportManager.setTestStep(General.getScenario().getStatus(), "Então confirmo o acesso à página Dynamic Content");
    }

    @And("valido conteúdo aleatório")
    public void validoConteudoAleatorio() {
        String[] oldImages = page.getImagesURL();
        Object[] oldTexts = page.getTexts();
        General.refreshPage();
        General.waitToBeVisible(page.getTitle(), 10);
        for (int i = 0; i < oldTexts.length; i++) {
            Assert.assertFalse( "Textos comparados no parágrafo "+i+" são iguais.", oldTexts[i].toString().equalsIgnoreCase(page.getPhrases().get(i).getText().trim()) );
            Assert.assertTrue( "URL da imagem "+i+" não corresponde aos valores esperados.", page.imageUrlMatches(oldImages[i]) );
        }

        ReportManager.setTestStep(General.getScenario().getStatus(), "E valido conteúdo aleatório");
    }

    @And("valido conteúdo estático")
    public void validoConteudoEstatico() {
        page.getLinkClickHere().click();
        General.waitToBeVisible(page.getTitle(), 10);

        String[] oldImages = page.getImagesURL();
        String[] oldTexts = page.getTexts();

        General.refreshPage();
        General.waitToBeVisible(page.getTitle(), 10);

        for (int i = 0; i < oldTexts.length; i++) {
            //System.out.println( oldTexts[i] + "\n" + page.getPhrases().get(i).getText()+"\n\n" );
            if( i < page.getTexts().length-1 ){
                Assert.assertTrue("Textos comparados no parágrafo " + i + " são diferentes.", oldTexts[i].equalsIgnoreCase(page.getPhrases().get(i).getText()));
            }
            else {
                Assert.assertFalse("Textos comparados no parágrafo " + i + " são iguais.", oldTexts[i].equalsIgnoreCase(page.getPhrases().get(i).getText()));
            }
            Assert.assertTrue("URL da imagem " + i + " não corresponde aos valores esperados.", page.imageUrlMatches(oldImages[i]));
        }

        ReportManager.setTestStep(General.getScenario().getStatus(), "E valido conteúdo estático");
    }

    

}
