package steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.AddRemoveElementsPage;
import reporter.ReportManager;

public class AddRemoveElementsSteps {

    private AddRemoveElementsPage page = null;
    private int quantity;

    public AddRemoveElementsSteps() {
        page = new AddRemoveElementsPage();
    }

    @Then("adiciono {int} elementos")
    public void vereiOAPaginaABTestVariation( int quantity ) {
        ReportManager.setStepName(new Object() {}.getClass().getEnclosingMethod().getAnnotations()[0].toString().replace("{int}", String.valueOf(quantity)));
        this.quantity = quantity;
        Assert.assertEquals( page.getTitleExpected(), page.getTitle().getText().trim().toString() );

        Assert.assertEquals(page.getTextButtonAddElement(), page.getButtonAddElement().getText().trim());
        for (int i = 0; i < this.quantity; i++) {
            page.getButtonAddElement().click();
        }
    }

    @And("removo todos os elementos adicionados")
    public void removoTodosOsElementosAdicionados() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals( this.quantity, page.getButtonRemove().size() );
        page.getButtonRemove().stream().forEach( btn -> {
            Assert.assertEquals(btn.getText().trim(), page.getButtonRemoveTextExpected());
            btn.click();
        });
        Assert.assertEquals( 0, page.getButtonRemove().size() );
    }
}
