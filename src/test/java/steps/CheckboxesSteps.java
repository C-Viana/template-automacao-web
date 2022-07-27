package steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CheckboxesPage;
import reporter.ReportManager;

public class CheckboxesSteps {

    private CheckboxesPage page = null;
    
    public CheckboxesSteps() {
        page = new CheckboxesPage();
    }

    @Then("confirmo o acesso à página Checkboxes")
    public void confirmoAcessoPaginaBrokenImages() {
        Assert.assertEquals(page.getExpectedTextTitle(), page.getCurrentTextTitle());
        ReportManager.setTestStep("Então confirmo o acesso à página Checkboxes");
    }

    @And("valido as opções disponíveis")
    public void validoImagensTela() {
        page.listCheckboxOptions();
        ReportManager.setTestStep("E valido as opções disponíveis");
    }

    @Then("marco o checkbox {string}")
    public void marcoCheckbox(String opt) {
        page.clickCheckBox(false, opt);
        Assert.assertEquals(page.getExpectedTextTitle(), page.getCurrentTextTitle());
        ReportManager.setTestStep("Então marco o checkbox " + opt);
    }

    @Then("desmarco o checkbox {string}")
    public void desmarcoCheckbox(String opt) {
        page.clickCheckBox(true, opt);
        Assert.assertEquals(page.getExpectedTextTitle(), page.getCurrentTextTitle());
        ReportManager.setTestStep("Então desmarco o checkbox " + opt);
    }

    

}
