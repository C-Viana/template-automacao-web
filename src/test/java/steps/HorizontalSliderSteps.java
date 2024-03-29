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
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(page.getTitleTextExpected(), page.getTitle().getText().trim());
        page.clickInputSlider();
        page.robotTeclarSetaDireita();
        page.robotTeclarSetaDireita();
        page.robotTeclarSetaDireita();
        Assert.assertEquals("1.5", page.getSliderCounter().getText().trim());
    }


}
