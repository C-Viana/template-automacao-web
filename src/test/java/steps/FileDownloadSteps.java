package steps;

import common.BasePage;
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
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        String url = page.getRandomDownloadItem().getAttribute("href");
        System.out.println("LOG_1: " + url);
        int responseCode = BasePage.getStatusCodeFromURL(url);
        Assert.assertEquals(200, responseCode);
        page.realizarDownloadDoArquivo(url);
    }


}
