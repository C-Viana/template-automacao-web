package steps;

import common.General;
import pages.CheckboxesPage;
import reporter.ReportManager;

import org.junit.Assert;

import io.cucumber.java.en.*;

public class CheckboxesSteps {

    private CheckboxesPage page = null;
    
    public CheckboxesSteps() {
        page = new CheckboxesPage();
    }

    @Then("confirmo o acesso à página Checkboxes")
    public void confirmoAcessoPaginaBrokenImages() {
        General.waitToBeVisible(page.getTitle(), 6);
        Assert.assertEquals(page.getExpectedTextTitle(), page.getCurrentTextTitle());
        ReportManager.setTestStep(General.getScenario().getStatus(), "Então confirmo o acesso à página Checkboxes");
    }

    @And("valido as opções disponíveis")
    public void validoImagensTela() {
        page.listCheckboxOptions();
        ReportManager.setTestStep(General.getScenario().getStatus(), "E valido as opções disponíveis");
    }

    @Then("marco o checkbox {string}")
    public void marcoCheckbox(String opt) {
        page.clickCheckBox(false, opt);
        Assert.assertEquals(page.getExpectedTextTitle(), page.getCurrentTextTitle());
        ReportManager.setTestStep(General.getScenario().getStatus(), "Então marco o checkbox " + opt);
    }

    @Then("desmarco o checkbox {string}")
    public void desmarcoCheckbox(String opt) {
        page.clickCheckBox(true, opt);
        Assert.assertEquals(page.getExpectedTextTitle(), page.getCurrentTextTitle());
        ReportManager.setTestStep(General.getScenario().getStatus(), "Então desmarco o checkbox " + opt);
    }

    

}
