package steps;

import org.junit.Assert;
import org.openqa.selenium.By;

import common.General;
import io.cucumber.java.en.*;
import pages.FramesPage;
import reporter.ReportManager;

public class FramesSteps {

    private FramesPage page = null;
    
    public FramesSteps() {
        page = new FramesPage();
    }

    @And("acessar a página de frameset")
    public void acessarPaginaFrameset() {
        Assert.assertEquals(page.getLinkNestedFramesTextExpected(), page.getLinkNestedFrames().getText().trim());
        page.getLinkNestedFrames().click();
        ReportManager.setTestStep(General.getScenario().getStatus(), "E acessar a página de frameset");
    }

    @Then("identifico cada um dos frames")
    public void identificoCadaFrame() {
        General.setContext(page.getFrameTop());
        Assert.assertEquals("Frame TOP deveria ter 3 frames internos.", 3, General.getElements(By.tagName("frame")).size() );

        General.setContext(page.getFrameLeft());
        Assert.assertEquals("LEFT", General.getTextFromElement(By.tagName("body")));

        General.setDefaultContext();
        General.setContext(page.getFrameTop());
        General.setContext(page.getFrameMiddle());
        Assert.assertEquals("MIDDLE", General.getTextFromElement(By.tagName("body")));

        General.setDefaultContext();
        General.setContext(page.getFrameTop());
        General.setContext(page.getFrameRight());
        Assert.assertEquals("RIGHT", General.getTextFromElement(By.tagName("body")));

        General.setDefaultContext();
        General.setContext(page.getFrameBottom());
        Assert.assertEquals("BOTTOM", General.getTextFromElement(By.tagName("body")));

        General.setDefaultContext();
        ReportManager.setTestStep(General.getScenario().getStatus(), "Então identifico cada um dos frames");
    }

    @And("acessar a página de iFrame")
    public void acessarPaginaIFrame() {
        Assert.assertEquals(page.getLinkIFramesTextExpected(), page.getLinkIFrames().getText().trim());
        page.getLinkIFrames().click();
        ReportManager.setTestStep(General.getScenario().getStatus(), "E acessar a página de iFrame");
    }

    @Then("interajo com o componente iFrame")
    public void interajoComponenteIFrame() {
        Assert.assertEquals(page.getIFrameTitleTextExpected(), page.getIFrameTitle().getText().trim());
        General.setContext(page.getIFrame());
        page.getIFrameParagraph().click();
        page.getIFrameParagraph().clear();
        page.getIFrameParagraph().sendKeys("FRASE DE TESTE BEM SUCEDIDO!");

        General.setDefaultContext();
        ReportManager.setTestStep(General.getScenario().getStatus(), "Então interajo com o componente iFrame");
    }


}
