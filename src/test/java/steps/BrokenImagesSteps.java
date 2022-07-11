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
        for (int j = 0; j < page.getImages().size(); j++) {
            int httpResponseCode = General.getStatusCodeFromURL(page.getImages().get(j).getAttribute("src"));
            System.out.println("IMAGEM: " + page.getImages().get(j).getAttribute("src") + "\tCODE: " + httpResponseCode);
            if(j == page.getImages().size()-1)
                Assert.assertEquals(200, httpResponseCode);
            else
                Assert.assertEquals(404, httpResponseCode);
        }
        ReportManager.setTestStep(General.getScenario().getStatus(), "E valido as imagens em tela");
    }

    @And("valido a imagem {int} em tela com status {int}")
    public void validoImagenNComStatus(int index, int expectedResponseCode) {
        int httpResponseCode = General.getStatusCodeFromURL(page.getImages().get(index-1).getAttribute("src"));
        Assert.assertEquals(expectedResponseCode, httpResponseCode);
        ReportManager.setTestStep(General.getScenario().getStatus(), "E valido a imagem "+index+" em tela com status " + expectedResponseCode);
    }

}
