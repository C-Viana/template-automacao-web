package steps;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import pages.JavaScriptAlertsPage;
import reporter.ReportManager;

public class JavaScriptAlertsSteps {

    private JavaScriptAlertsPage page = null;
    
    public JavaScriptAlertsSteps() {
        page = new JavaScriptAlertsPage();
    }

    @Then("interajo com o alerta")
    public void interajoComAlertaPrompt() {
        Assert.assertEquals(page.getTitleTextExpected(), page.getTitle().getText().trim());
        Assert.assertEquals(page.getBtnJSAlertTextExpected(), page.getBtnJSAlert().getText().trim());
        page.getBtnJSAlert().click();
        Assert.assertEquals("I am a JS Alert", page.getCurrentAlert().getText().trim());
        page.getCurrentAlert().accept();
        Assert.assertEquals(page.getExpectedTxtResultTextAlert(), page.getTxtResultText().getText().trim());
        ReportManager.setTestStep(ReportManager.getScenario().getStatus(), "Então interajo com o alerta");
    }

    @Then("clico em OK no alerta de confirmação")
    public void clicoOKAlertaConfirmacao() {
        Assert.assertEquals(page.getTitleTextExpected(), page.getTitle().getText().trim());
        Assert.assertEquals(page.getBtnClickForJSConfirmTextExpected(), page.getBtnClickForJSConfirm().getText().trim());
        page.getBtnClickForJSConfirm().click();
        Assert.assertEquals("I am a JS Confirm", page.getCurrentAlert().getText().trim());
        page.getCurrentAlert().accept();
        Assert.assertEquals(page.getExpectedTxtResultTextConfirmOK(), page.getTxtResultText().getText().trim());
        ReportManager.setTestStep(ReportManager.getScenario().getStatus(), "Então clico em OK no alerta de confirmação");
    }

    @Then("clico em CANCEL no alerta de confirmação")
    public void clicoCANCELAlertaConfirmacao() {
        Assert.assertEquals(page.getTitleTextExpected(), page.getTitle().getText().trim());
        Assert.assertEquals(page.getBtnClickForJSConfirmTextExpected(), page.getBtnClickForJSConfirm().getText().trim());
        page.getBtnClickForJSConfirm().click();
        Assert.assertEquals("I am a JS Confirm", page.getCurrentAlert().getText().trim());
        page.getCurrentAlert().dismiss();
        Assert.assertEquals(page.getExpectedTxtResultConfirmCancel(), page.getTxtResultText().getText().trim());
        ReportManager.setTestStep(ReportManager.getScenario().getStatus(), "Então clico em CANCEL no alerta de confirmação");
    }

    @Then("clico em OK no alerta de prompt após digitar {string}")
    public void clicoOKAlertaPrompt(String input) {
        Assert.assertEquals(page.getTitleTextExpected(), page.getTitle().getText().trim());
        Assert.assertEquals(page.getBtnClickForJSPromptTextExpected(), page.getBtnClickForJSPrompt().getText().trim());
        page.getBtnClickForJSPrompt().click();
        Assert.assertEquals("I am a JS prompt", page.getCurrentAlert().getText().trim());
        page.getCurrentAlert().sendKeys(input);
        page.getCurrentAlert().accept();
        Assert.assertEquals(page.getExpectedTxtResultPromptText() + input, page.getTxtResultText().getText().trim());
        ReportManager.setTestStep(ReportManager.getScenario().getStatus(), "Então clico em OK no alerta de prompt após digitar "+input);
    }

    @Then("clico em CANCEL no alerta de prompt")
    public void clicoCANCELAlertaPrompt() {
        Assert.assertEquals(page.getTitleTextExpected(), page.getTitle().getText().trim());
        Assert.assertEquals(page.getBtnClickForJSPromptTextExpected(), page.getBtnClickForJSPrompt().getText().trim());
        page.getBtnClickForJSPrompt().click();
        Assert.assertEquals("I am a JS prompt", page.getCurrentAlert().getText().trim());
        page.getCurrentAlert().dismiss();
        Assert.assertEquals(page.getExpectedTxtResultPromptNull(), page.getTxtResultText().getText().trim());
        ReportManager.setTestStep(ReportManager.getScenario().getStatus(), "clico em CANCEL no alerta de prompt");
    }


}
