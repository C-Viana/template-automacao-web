package steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.ContextMenuPage;
import reporter.ReportManager;

public class ContextMenuSteps {

    private ContextMenuPage page = null;
    
    public ContextMenuSteps() {
        page = new ContextMenuPage();
    }

    @Then("valido a exibição do alert ao clicar com o botão direito na área marcada")
    public void validoExibicaoAlertClicarDireitoAreaMarcada() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(page.getExpectedTextTitle(), page.getCurrentTextTitle());
        page.clickHotspotComponent();
        Assert.assertEquals(page.getAlertExpectedText(), page.getAlert().getText());
        ReportManager.setTestStepOutBrowser("Validando abertura do alert.");
        page.getAlert().dismiss();
    }

    @And("encerro o alert")
    public void encerroAlert() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertTrue("Alert não deveria estar presente!", page.getAlert()==null);
    }

    

}
