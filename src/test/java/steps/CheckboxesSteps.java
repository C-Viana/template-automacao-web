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
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(page.getExpectedTextTitle(), page.getCurrentTextTitle());
    }

    @And("valido as opções disponíveis")
    public void validoImagensTela() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        page.listCheckboxOptions();
    }

    @Then("marco o checkbox {string}")
    public void marcoCheckbox(String opt) {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString().replace("{string}", opt));
        page.clickCheckBox(false, opt);
        Assert.assertEquals(page.getExpectedTextTitle(), page.getCurrentTextTitle());
    }

    @Then("desmarco o checkbox {string}")
    public void desmarcoCheckbox(String opt) {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString().replace("{string}", opt));
        page.clickCheckBox(true, opt);
        Assert.assertEquals(page.getExpectedTextTitle(), page.getCurrentTextTitle());
    }

    

}
