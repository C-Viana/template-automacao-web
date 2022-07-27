package steps;

import org.junit.Assert;

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
        Assert.assertEquals(page.getTitleTextExpected(), page.getTitle().getText().trim());
        Assert.assertEquals(page.getBodyTextExpected(), page.getBody().getText().trim());
        ReportManager.setTestStep("Página para upload de arquivo acessada.");
        
        //General.clickByCoordinates(page.getInputEscolherArquivo());
        page.siculixClicarNoComponente("FileUploader_0.png");
        page.siculixClicarNoComponente("FileUploader_1.png");
        page.siculixDigitarTexto(System.getProperty("user.dir") + "\\uploads");
        page.siculixTeclarEnter();
        page.siculixClicarNoComponente("FileUploader_2.png");
        ReportManager.setTestStepOutBrowser("Janela para seleção de arquivo aberta");
        page.siculixClicarNoComponente("FileUploader_3.png");

        page.getBtnUpload().click();
        Assert.assertEquals(page.getTitleTextExpectedFileUploaded(), page.getTitle().getText().trim());
        Assert.assertEquals("_uploadImageMoon.jpg", page.getUploadedFilesNames().getText().trim());
        ReportManager.setTestStep("Então realizo o upload de um arquivo");
    }


}
