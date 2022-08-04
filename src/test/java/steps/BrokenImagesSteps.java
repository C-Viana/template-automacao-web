package steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.BrokenImagesPage;
import reporter.ReportManager;

public class BrokenImagesSteps {

    private BrokenImagesPage page = null;
    
    public BrokenImagesSteps() {
        page = new BrokenImagesPage();
    }

    @Then("confirmo o acesso à página Broken Images")
    public void confirmoAcessoPaginaBrokenImages() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(page.getExpectedTextTitle(), page.getCurrentTextTitle());
    }

    @And("valido as imagens em tela")
    public void validoImagensTela() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        for (int j = 0; j < page.getImages().size(); j++) {
            int httpResponseCode = page.validarIntegridadeImagens(j);
            //System.out.println("IMAGEM: " + page.getImages().get(j).getAttribute("src") + "\tCODE: " + httpResponseCode);
            if(j == page.getImages().size()-1)
                Assert.assertEquals(200, httpResponseCode);
            else
                Assert.assertEquals(404, httpResponseCode);
        }
    }

    @And("valido a imagem {int} em tela com status {int}")
    public void validoImagenNComStatus(int index, int expectedResponseCode) {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString()
            .replaceFirst("\\{int\\}", String.valueOf(index)).replace("{int}", String.valueOf(expectedResponseCode))
            );
        int httpResponseCode = page.validarIntegridadeImagens(index-1);
        Assert.assertEquals(expectedResponseCode, httpResponseCode);
    }

}
