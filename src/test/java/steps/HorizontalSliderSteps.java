package steps;

import java.awt.event.KeyEvent;

import org.junit.Assert;

import common.General;
import io.cucumber.java.en.*;
import pages.HorizontalSliderPage;
import reporter.ReportManager;

public class HorizontalSliderSteps {

    private HorizontalSliderPage page = null;
    
    public HorizontalSliderSteps() {
        page = new HorizontalSliderPage();
    }

    @Then("realizo a interação com o slider")
    public void interajoComponenteIFrame() {
        Assert.assertEquals(page.getTitleTextExpected(), page.getTitle().getText().trim());
        General.clickByCoordinates(page.getInputSlider().getLocation().x, page.getInputSlider().getLocation().y);
        General.typeKeyboard(KeyEvent.VK_RIGHT);
        General.typeKeyboard(KeyEvent.VK_RIGHT);
        General.typeKeyboard(KeyEvent.VK_RIGHT);
        General.waitFor(2);
        Assert.assertEquals("1.5", page.getSliderCounter().getText().trim());
        ReportManager.setTestStep(General.getScenario().getStatus(), "Então realizo a interação com o slider");
    }


}
