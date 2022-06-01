package steps;

import common.General;
import pages.BrokenImagesPage;
import reporter.ReportManager;

import org.junit.Assert;

import io.cucumber.java.en.*;

public class BrokenImagesSteps {

    private BrokenImagesPage page = null;
    
    public BrokenImagesSteps() {
        page = new BrokenImagesPage();
    }

    @Then("confirmo o acesso à página Broken Images")
    public void confirmoAcessoPaginaBrokenImages() {
        General.waitToBeVisible(page.getTitle(), 6);
        Assert.assertEquals(page.getExpectedTextTitle(), page.getCurrentTextTitle());
        ReportManager.setTestStep(General.getScenario().getStatus(), "Então confirmo o acesso à página Broken Images");
    }

    @And("valido as imagens em tela")
    public void validoImagensTela() {
        page.getImages().stream().forEach( i -> {
            int httpResponseCode = General.getStatusCodeFromURL(i.getAttribute("src"));
            System.out.println("IMAGEM: " + i.getAttribute("src") + "\tCODE: " + httpResponseCode );
            Assert.assertEquals( 200, httpResponseCode );
        });
        ReportManager.setTestStep(General.getScenario().getStatus(), "E valido as imagens em tela");
    }

    @And("valido a imagem {int} em tela com status {int}")
    public void validoImagenNComStatus(int index, int expectedResponseCode) {
        int httpResponseCode = General.getStatusCodeFromURL(page.getImages().get(index-1).getAttribute("src"));
        Assert.assertEquals(expectedResponseCode, httpResponseCode);
        ReportManager.setTestStep(General.getScenario().getStatus(), "E valido a imagem "+index+" em tela com status " + expectedResponseCode);
    }

}
