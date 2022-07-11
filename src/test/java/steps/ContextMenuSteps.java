package steps;

import common.General;
import pages.ContextMenuPage;
import reporter.ReportManager;

import org.junit.Assert;

import io.cucumber.java.en.*;

public class ContextMenuSteps {

    private ContextMenuPage page = null;
    
    public ContextMenuSteps() {

        page = new ContextMenuPage();
    }

    @Then("valido a exibição do alert ao clicar com o botão direito na área marcada")
    public void validoExibicaoAlertClicarDireitoAreaMarcada() {
        General.waitToBeVisible(page.getTitle(), 6);
        General.setChromePositionLocalVariable();
        General.setChromeDimensionsLocalVariable();
        Assert.assertEquals(page.getExpectedTextTitle(), page.getCurrentTextTitle());
        page.clickHotspotComponent();
        Assert.assertEquals(page.getAlertExpectedText(), page.getAlert().getText());
        ReportManager.setTestStepOutContext(General.getScenario().getStatus(), "Então valido a exibição do alert");
    }

    @And("encerro o alert")
    public void encerroAlert() {
        page.getAlert().dismiss();
        ReportManager.setTestStep(General.getScenario().getStatus(), "E encerro o alert");
    }

    

}
