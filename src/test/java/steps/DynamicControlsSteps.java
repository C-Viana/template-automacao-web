package steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.DynamicControlsPage;
import reporter.ReportManager;

public class DynamicControlsSteps {

    private DynamicControlsPage page = null;
    
    public DynamicControlsSteps() {
        page = new DynamicControlsPage();
    }

    @Then("confirmo o acesso à página Dynamic Controls")
    public void confirmoAcessPaginaDynamicControls() {
        Assert.assertEquals(page.getExpectedTxtTitle(), page.getTitle().getText().trim());
        Assert.assertEquals(page.getExpectedTxtSubtitle(), page.getSubtitle().getText().trim());
        ReportManager.setTestStep(ReportManager.getScenario().getStatus(), "Então confirmo o acesso à página Dynamic Controls");
    }

    @And("removo o checkbox")
    public void removoCheckbox() {
        Assert.assertTrue( "Componente de checkbox não deveria estar ausente.", page.isCheckboxVisible() );
        page.getBtnRemoveAddCheckbox().click();
        Assert.assertEquals( page.getExpectedTextLoading(), page.getLoadingElement().getText().trim() );
        ReportManager.setTestStep(ReportManager.getScenario().getStatus(), "Removendo o elemento de checkbox");
        Assert.assertEquals(page.getTextRemovedCheckbox(), page.getMessageElement().getText().trim());
        Assert.assertFalse("Componente de checkbox deveria estar ausente.", page.isCheckboxVisible());
        ReportManager.setTestStep(ReportManager.getScenario().getStatus(), "E removo o checkbox");
    }

    @And("adiciono o checkbox")
    public void adicionoCheckbox() {
        page.getBtnRemoveAddCheckbox().click();
        Assert.assertEquals(page.getExpectedTextLoading(), page.getLoadingElement().getText().trim());
        ReportManager.setTestStep(ReportManager.getScenario().getStatus(), "Adicionando o elemento de checkbox");
        Assert.assertEquals(page.getTextAddedCheckbox(), page.getMessageElement().getText().trim());
        Assert.assertTrue("Componente de checkbox não deveria estar ausente.", page.isCheckboxVisible());
        ReportManager.setTestStep(ReportManager.getScenario().getStatus(), "E adiciono o checkbox");
    }

    @And("habilito o campo de texto para digitar a palavra {string}")
    public void habilitarInput( String text ) {
        Assert.assertFalse("Input deveria estar desabilitado.", page.getInput().isEnabled());
        page.getBtnEnableDisableInput().click();
        Assert.assertEquals(page.getExpectedTextLoading(), page.getLoadingElement().getText().trim());
        ReportManager.setTestStep(ReportManager.getScenario().getStatus(), "Habilitando o elemento input");
        Assert.assertEquals(page.getExpectedTextEnabledInput(), page.getMessageElement().getText().trim());
        Assert.assertTrue("Input deveria estar habilitado.", page.getInput().isEnabled());
        page.getInput().sendKeys(text);
        ReportManager.setTestStep(ReportManager.getScenario().getStatus(), "E habilito o campo de texto para digitar a palavra "+text);
    }

    @And("desabilito o campo de texto")
    public void desabilitarInput() {
        page.getBtnEnableDisableInput().click();
        Assert.assertEquals(page.getExpectedTextLoading(), page.getLoadingElement().getText().trim());
        ReportManager.setTestStep(ReportManager.getScenario().getStatus(), "Desabilitando o elemento input");
        Assert.assertEquals(page.getExpectedTextDisabledInput(), page.getMessageElement().getText().trim());
        Assert.assertFalse("Input deveria estar desabilitado.", page.getInput().isEnabled());
        ReportManager.setTestStep(ReportManager.getScenario().getStatus(), "E desabilito o campo de texto");
    }

   
    

}
