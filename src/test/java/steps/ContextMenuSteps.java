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
        Assert.assertEquals(page.getExpectedTextTitle(), page.getCurrentTextTitle());
        page.clickHotspotComponent();
        Assert.assertEquals(page.getAlertExpectedText(), page.getAlert().getText());
        ReportManager.setTestStepOutBrowser("Então valido a exibição do alert");
    }

    @And("encerro o alert")
    public void encerroAlert() {
        page.getAlert().dismiss();
        ReportManager.setTestStep("E encerro o alert");
    }

    

}
