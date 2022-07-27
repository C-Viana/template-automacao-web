package steps;

import org.junit.Assert;

import io.cucumber.java.en.Then;
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
        page.clickInputSlider();
        page.robotTeclarSetaDireita();
        page.robotTeclarSetaDireita();
        page.robotTeclarSetaDireita();
        Assert.assertEquals("1.5", page.getSliderCounter().getText().trim());
        ReportManager.setTestStep("Então realizo a interação com o slider");
    }


}
