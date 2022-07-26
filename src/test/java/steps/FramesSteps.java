package steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
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
        ReportManager.setTestStep(ReportManager.getScenario().getStatus(), "E acessar a página de frameset");
    }

    @Then("identifico cada um dos frames")
    public void identificoCadaFrame() {
        page.enterContextFrameTop();
        Assert.assertEquals("Frame TOP deveria ter 3 frames internos.", 3, page.getQuantityFramesTop() );

        page.enterContextFrameLeft();
        Assert.assertEquals("LEFT", page.getTextFromFrameBody());

        page.returnDefaultContext();
        page.enterContextFrameTop();
        page.enterContextFrameMiddle();
        Assert.assertEquals("MIDDLE", page.getTextFromFrameBody());

        page.returnDefaultContext();
        page.enterContextFrameTop();
        page.enterContextFrameRight();
        Assert.assertEquals("RIGHT", page.getTextFromFrameBody());

        page.returnDefaultContext();
        page.enterContextFrameBottom();
        Assert.assertEquals("BOTTOM", page.getTextFromFrameBody());

        page.returnDefaultContext();
        ReportManager.setTestStep(ReportManager.getScenario().getStatus(), "Então identifico cada um dos frames");
    }

    @And("acessar a página de iFrame")
    public void acessarPaginaIFrame() {
        Assert.assertEquals(page.getLinkIFramesTextExpected(), page.getLinkIFrames().getText().trim());
        page.getLinkIFrames().click();
        ReportManager.setTestStep(ReportManager.getScenario().getStatus(), "E acessar a página de iFrame");
    }

    @Then("interajo com o componente iFrame")
    public void interajoComponenteIFrame() {
        Assert.assertEquals(page.getIFrameTitleTextExpected(), page.getIFrameTitle().getText().trim());
        page.enterContextIFrame();
        page.getIFrameParagraph().click();
        page.getIFrameParagraph().clear();
        page.getIFrameParagraph().sendKeys("FRASE DE TESTE BEM SUCEDIDO!");

        page.returnDefaultContext();
        ReportManager.setTestStep(ReportManager.getScenario().getStatus(), "Então interajo com o componente iFrame");
    }


}
