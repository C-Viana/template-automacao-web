package steps;

import common.General;
import pages.AddRemoveElementsPage;
import reporter.ReportManager;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AddRemoveElementsSteps {

    private AddRemoveElementsPage page = null;
    private int quantity;

    public AddRemoveElementsSteps() {
        page = new AddRemoveElementsPage();
    }

    @Then("adiciono {int} elementos")
    public void vereiOAPaginaABTestVariation( int quantity ) {
        this.quantity = quantity;
        General.waitToBeVisible( page.getTitle(), 10 );
        Assert.assertTrue( page.getTitleExpected().equals(page.getTitle().getText().trim().toString()) );

        Assert.assertEquals(page.getTextButtonAddElement(), page.getButtonAddElement().getText().trim());
        for (int i = 0; i < this.quantity; i++) {
            page.getButtonAddElement().click();
        }
        ReportManager.setTestStep(General.getScenario().getStatus(), "Então adiciono " + this.quantity + " elementos");
    }

    @And("removo todos os elementos adicionados")
    public void removoTodosOsElementosAdicionados() {
        Assert.assertEquals( this.quantity, page.getButtonRemove().size() );
        page.getButtonRemove().stream().forEach( btn -> {
            Assert.assertEquals(btn.getText().trim(), page.getButtonRemoveTextExpected());
            btn.click();
        });
        Assert.assertEquals( 0, page.getButtonRemove().size() );
        ReportManager.setTestStep(General.getScenario().getStatus(), "E removo todos os elementos adicionados");
    }
}
