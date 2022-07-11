package steps;

import org.junit.Assert;

import common.General;
import io.cucumber.java.en.*;
import pages.HoverPage;
import reporter.ReportManager;

public class HoverSteps {

    private HoverPage page = null;
    
    public HoverSteps() {
        page = new HoverPage();
    }

    @Then("realizo a identificação dos cards de perfil")
    public void interajoComponenteIFrame() {
        Assert.assertEquals(page.getTitleTextExpected(), page.getTitle().getText().trim());
        for (int i = 0; i < 3; i++) {
            //General.moveMouseTo(page.getProfileCards().get(i).getLocation().x, page.getProfileCards().get(i).getLocation().y);
            General.hoverElement(page.getProfileCards().get(i));
            Assert.assertEquals(page.getProfileNameExpected()+(i+1), page.getProfileNames().get(i).getText().trim());
            Assert.assertEquals(page.getProfileLinksTextExpected(), page.getProfileLinks().get(i).getText().trim());
        }
        ReportManager.setTestStep(General.getScenario().getStatus(), "Então realizo a identificação dos cards de perfil");
    }


}
