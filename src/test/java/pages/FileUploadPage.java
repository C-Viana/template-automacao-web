package pages;

import driver.Driver;
import objects.FileUpload;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPage extends FileUpload {

    public FileUploadPage() {
        PageFactory.initElements( Driver.get(), this );
    }

    public WebElement getTitle() {
        return pageTitle;
    }

    public String getTitleTextExpected() {
        return txtExpectedTitle;
    }

    public WebElement getBody() {
        return txtBody;
    }

    public String getBodyTextExpected() {
        return txtExpectedBody;
    }

    public WebElement getInputEscolherArquivo() {
        return inputEscolherArquivo;
    }

    public WebElement getBtnUpload() {
        return btnUpload;
    }

    public String getTitleTextExpectedFileUploaded() {
        return txtExpectedFileUploaded;
    }

    public WebElement getUploadedFilesNames() {
        return listUploadedFilesNames;
    }
    
    
    
}
