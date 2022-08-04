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
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(page.getExpectedTxtTitle(), page.getTitle().getText().trim());
        Assert.assertEquals(page.getExpectedTxtSubtitle(), page.getSubtitle().getText().trim());
    }

    @And("removo o checkbox")
    public void removoCheckbox() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertTrue( "Componente de checkbox não deveria estar ausente.", page.isCheckboxVisible() );
        page.getBtnRemoveAddCheckbox().click();
        Assert.assertEquals( page.getExpectedTextLoading(), page.getLoadingElement().getText().trim() );
        ReportManager.setTestStep("Removendo o elemento de checkbox");
        Assert.assertEquals(page.getTextRemovedCheckbox(), page.getMessageElement().getText().trim());
        Assert.assertFalse("Componente de checkbox deveria estar ausente.", page.isCheckboxVisible());
    }

    @And("adiciono o checkbox")
    public void adicionoCheckbox() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        page.getBtnRemoveAddCheckbox().click();
        Assert.assertEquals(page.getExpectedTextLoading(), page.getLoadingElement().getText().trim());
        ReportManager.setTestStep("Adicionando o elemento de checkbox");
        Assert.assertEquals(page.getTextAddedCheckbox(), page.getMessageElement().getText().trim());
        Assert.assertTrue("Componente de checkbox não deveria estar ausente.", page.isCheckboxVisible());
    }

    @And("habilito o campo de texto para digitar a palavra {string}")
    public void habilitarInput( String text ) {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString().replace("{string}", text));
        Assert.assertFalse("Input deveria estar desabilitado.", page.getInput().isEnabled());
        page.getBtnEnableDisableInput().click();
        Assert.assertEquals(page.getExpectedTextLoading(), page.getLoadingElement().getText().trim());
        ReportManager.setTestStep("Habilitando o elemento input");
        Assert.assertEquals(page.getExpectedTextEnabledInput(), page.getMessageElement().getText().trim());
        Assert.assertTrue("Input deveria estar habilitado.", page.getInput().isEnabled());
        page.getInput().sendKeys(text);
    }

    @And("desabilito o campo de texto")
    public void desabilitarInput() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        page.getBtnEnableDisableInput().click();
        Assert.assertEquals(page.getExpectedTextLoading(), page.getLoadingElement().getText().trim());
        ReportManager.setTestStep("Desabilitando o elemento input");
        Assert.assertEquals(page.getExpectedTextDisabledInput(), page.getMessageElement().getText().trim());
        Assert.assertFalse("Input deveria estar desabilitado.", page.getInput().isEnabled());
    }

   
    

}
