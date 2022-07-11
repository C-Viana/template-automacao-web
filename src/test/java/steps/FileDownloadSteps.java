package steps;

import common.General;
import pages.FileDownloadPage;
import reporter.ReportManager;

import org.junit.Assert;

import io.cucumber.java.en.*;

public class FileDownloadSteps {

    private FileDownloadPage page = null;
    
    public FileDownloadSteps() {
        page = new FileDownloadPage();
    }

    @Then("realizo o download de um elemento aleatório")
    public void realizarDownloadElementoAleatorio() {
        General.waitFor(3);
        String url = page.getRandomDownloadItem().getAttribute("href");
        System.out.println("LOG_1: " + url);
        int responseCode = General.getStatusCodeFromURL(url);
        Assert.assertEquals(200, responseCode);
        General.downloadFile(url, url.split("download/")[1]);
        ReportManager.setTestStep(General.getScenario().getStatus(), "Então realizo o download de um elemento aleatório");
    }


}
