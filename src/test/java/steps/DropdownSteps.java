package steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.DropdownPage;
import reporter.ReportManager;

public class DropdownSteps {

    private DropdownPage page = null;
    
    public DropdownSteps() {
        page = new DropdownPage();
    }

    @Then("confirmo o acesso à página Dropdown")
    public void confirmoAcessPaginaDropdown() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(page.getExpectedTextTitle(), page.getTitle().getText().trim());
    }

    @And("seleciono a opção {string}")
    public void selecionoOpcao(String opt) {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(page.getExpectedTextOptionDefault(), page.getSelect().getFirstSelectedOption().getText());
        page.getSelect().selectByVisibleText(opt);
        Assert.assertEquals( (opt.endsWith("1")) ? page.getExpectedTextOption1() : page.getExpectedTextOption2(), page.getSelect().getFirstSelectedOption().getText());
    }

    

}
