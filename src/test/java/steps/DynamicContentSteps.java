package steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.DynamicContentPage;
import reporter.ReportManager;

public class DynamicContentSteps {

    private DynamicContentPage page = null;
    
    public DynamicContentSteps() {
        page = new DynamicContentPage();
    }

    @Then("confirmo o acesso à página Dynamic Content")
    public void confirmoAcessPaginaDynamicContent() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(page.getExpectedTextTitle(), page.getTitle().getText().trim());
    }

    @And("valido conteúdo aleatório")
    public void validoConteudoAleatorio() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        String[] oldImages = page.getImagesURL();
        Object[] oldTexts = page.getTexts();
        page.recarregarTela();
        for (int i = 0; i < oldTexts.length; i++) {
            Assert.assertFalse( "Textos comparados no parágrafo "+i+" são iguais.", oldTexts[i].toString().equalsIgnoreCase(page.getPhrases().get(i).getText().trim()) );
            Assert.assertTrue( "URL da imagem "+i+" não corresponde aos valores esperados.", page.imageUrlMatches(oldImages[i]) );
        }
    }

    @And("valido conteúdo estático")
    public void validoConteudoEstatico() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        page.getLinkClickHere().click();

        String[] oldImages = page.getImagesURL();
        String[] oldTexts = page.getTexts();

        page.recarregarTela();

        for (int i = 0; i < oldTexts.length; i++) {
            //System.out.println( oldTexts[i] + "\n" + page.getPhrases().get(i).getText()+"\n\n" );
            if( i < page.getTexts().length-1 ){
                Assert.assertTrue("Textos comparados no parágrafo " + i + " são diferentes.", oldTexts[i].equalsIgnoreCase(page.getPhrases().get(i).getText()));
            }
            else {
                Assert.assertFalse("Textos comparados no parágrafo " + i + " são iguais.", oldTexts[i].equalsIgnoreCase(page.getPhrases().get(i).getText()));
            }
            System.out.println("URL: " + oldImages[i]);
            Assert.assertTrue("URL da imagem " + i + " não corresponde aos valores esperados.", page.imageUrlMatches(oldImages[i]));
        }
        System.out.println();
    }

    

}
