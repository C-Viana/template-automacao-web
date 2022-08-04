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
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(page.getLinkNestedFramesTextExpected(), page.getLinkNestedFrames().getText().trim());
        page.getLinkNestedFrames().click();
    }

    @Then("identifico cada um dos frames")
    public void identificoCadaFrame() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
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
    }

    @And("acessar a página de iFrame")
    public void acessarPaginaIFrame() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(page.getLinkIFramesTextExpected(), page.getLinkIFrames().getText().trim());
        page.getLinkIFrames().click();
    }

    @Then("interajo com o componente iFrame")
    public void interajoComponenteIFrame() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(page.getIFrameTitleTextExpected(), page.getIFrameTitle().getText().trim());
        page.enterContextIFrame();
        page.getIFrameParagraph().click();
        page.getIFrameParagraph().clear();
        page.getIFrameParagraph().sendKeys("FRASE DE TESTE BEM SUCEDIDO!");

        page.returnDefaultContext();
    }


}
