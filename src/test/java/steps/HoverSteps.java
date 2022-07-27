package steps;

import org.junit.Assert;

import io.cucumber.java.en.Then;
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
            page.hoverProfileCard(i);
            Assert.assertEquals(page.getProfileNameExpected()+(i+1), page.getProfileNames().get(i).getText().trim());
            Assert.assertEquals(page.getProfileLinksTextExpected(), page.getProfileLinks().get(i).getText().trim());
        }
        ReportManager.setTestStep("Então realizo a identificação dos cards de perfil");
    }


}
