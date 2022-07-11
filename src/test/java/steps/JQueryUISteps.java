package steps;

import org.junit.Assert;

import common.General;
import io.cucumber.java.en.*;
import pages.JQueryUIPage;
import reporter.ReportManager;

public class JQueryUISteps {

    private JQueryUIPage page = null;
    
    public JQueryUISteps() {
        page = new JQueryUIPage();
    }

    @Then("verifico as opções de download disponíveis")
    public void interajoComponenteIFrame() {
        Assert.assertEquals(page.getTitleTextExpected(), page.getTitle().getText().trim());
        Assert.assertEquals(page.getItemEnabledTextExpected(), page.getItemEnabled().getText().trim());
        General.hoverElement(page.getItemEnabled());
        General.waitFor(2);
        Assert.assertEquals(page.getItemDownloadTextExpected(), page.getItemDownload().getText().trim());
        General.hoverElement(page.getItemDownload());
        General.waitFor(2);
        Assert.assertEquals(page.getItemPDFTextExpected(), page.getItemPDF().getText().trim());
        Assert.assertEquals(page.getItemCSVTextExpected(), page.getItemCSV().getText().trim());
        Assert.assertEquals(page.getItemExcelTextExpected(), page.getItemExcel().getText().trim());
        ReportManager.setTestStep(General.getScenario().getStatus(), "Então verifico as opções de download disponíveis");
    }


}
