package steps;

import org.junit.Assert;
import org.sikuli.hotkey.Keys;

import common.General;
import io.cucumber.java.en.Then;
import pages.FileUploadPage;
import reporter.ReportManager;

public class FileUploadSteps {

    private FileUploadPage page = null;
    
    public FileUploadSteps() {
        page = new FileUploadPage();
    }

    @Then("realizo o upload de um arquivo")
    public void realizoOUploadDeUmArquivo() {
        General.waitToBeVisible(page.getTitle(), 5);
        Assert.assertEquals(page.getTitleTextExpected(), page.getTitle().getText().trim());
        Assert.assertEquals(page.getBodyTextExpected(), page.getBody().getText().trim());
        ReportManager.setTestStep(General.getScenario().getStatus(), "Página para upload de arquivo acessada.");
        
        //General.clickByCoordinates(page.getInputEscolherArquivo());
        General.clickSikulix("FileUploader_0.png");

        General.waitFor(3);
        
        General.clickSikulix("FileUploader_1.png");
        General.writeSikulix(System.getProperty("user.dir") + "\\uploads");
        General.pressKeyboardSikulix(Keys.ENTER);
        General.waitFor(2);
        General.clickSikulix("FileUploader_2.png");
        ReportManager.setTestStep(General.getScenario().getStatus(), "Janela para seleção de arquivo aberta");
        General.clickSikulix("FileUploader_3.png");

        General.waitFor(3);
        page.getBtnUpload().click();
        Assert.assertEquals(page.getTitleTextExpectedFileUploaded(), page.getTitle().getText().trim());
        Assert.assertEquals("_uploadImageMoon.jpg", page.getUploadedFilesNames().getText().trim());
        ReportManager.setTestStep(General.getScenario().getStatus(), "Então realizo o upload de um arquivo");
    }


}
