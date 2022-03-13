package steps;

import common.General;
import common.StaticResources;
import pages.HerokuappHomePage;
import reporter.ReportManager;

import org.junit.Assert;

import io.cucumber.java.en.*;

public class HerokuappHomeSteps {
    private HerokuappHomePage home = null;
    
    public HerokuappHomeSteps() {
        home = new HerokuappHomePage();
    }
    
    @Given("que abri a página Herokuapp")
    public void queAbriAPaginaHerokuapp() {
        General.goTo(StaticResources.HEROKUAPP);
        Assert.assertEquals(home.getTitleExpected(), home.getTitle());
        ReportManager.setTestStep(General.getScenario().getStatus(), "Dado que abri a página HerokuApp");
    }

    @When("acessar o link AB Testing")
    public void acessarOLinkABTesting() {
        Assert.assertEquals(home.getABTestingLinkText(), home.getLinkTextABTestingExpected());
        home.clickABTestingLink();
        ReportManager.setTestStep(General.getScenario().getStatus(), "Quando acessar o link A/B Testing");
    }

    @When("acessar o link Add-Remove Elements")
    public void acessarOLinkAddRemoveElements() {
        Assert.assertEquals(home.getAddRemoveElementsText(), home.getLinkTextAddRemoveElementsExpected());
        home.clickAddRemoveElements();
        ReportManager.setTestStep(General.getScenario().getStatus(), "Quando acessar o link Add/Remove Elements");
    }

    @When("acessar o link Basic Auth")
    public void acessarOLinkBasicAuth() {
        Assert.assertEquals(home.getBasicAuthText(), home.getLinkTextBasicAuthExpected());
        home.clickBasicAuth();
        ReportManager.setTestStep(General.getScenario().getStatus(), "Quando acessar o link Basic Auth");
    }

}
