package steps;

import common.General;
import common.StaticResources;
import pages.HerokuappHomePage;

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
    }

    @When("acessar o link AB Testing")
    public void acessarOLinkABTesting() {
        home.clickABTestingLink();
    }

}
