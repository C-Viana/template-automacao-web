package steps;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import pages.JQueryUIPage;
import reporter.ReportManager;

public class JQueryUISteps {

    private JQueryUIPage page = null;
    
    public JQueryUISteps() {
        page = new JQueryUIPage();
    }

    @Then("verifico as opções de download disponíveis")
    public void interajoComponenteIFrame() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(page.getTitleTextExpected(), page.getTitle().getText().trim());
        Assert.assertEquals(page.getItemEnabledTextExpected(), page.getItemEnabled().getText().trim());
        page.hoverItemEnabled();
        Assert.assertEquals(page.getItemDownloadTextExpected(), page.getItemDownload().getText().trim());
        page.hoverItemDownload();
        Assert.assertEquals(page.getItemPDFTextExpected(), page.getItemPDF().getText().trim());
        Assert.assertEquals(page.getItemCSVTextExpected(), page.getItemCSV().getText().trim());
        Assert.assertEquals(page.getItemExcelTextExpected(), page.getItemExcel().getText().trim());
    }


}
