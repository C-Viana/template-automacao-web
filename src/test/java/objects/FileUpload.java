package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUpload {
    
    @FindBy(tagName = "h3")
    protected WebElement pageTitle;
    protected String txtExpectedTitle = "File Uploader";
    protected String txtExpectedFileUploaded = "File Uploaded!";

    @FindBy(tagName = "p")
    protected WebElement txtBody;
    protected String txtExpectedBody = "Choose a file on your system and then click upload. Or, drag and drop a file into the area below.";

    @FindBy(css = "input#file-upload")
    protected WebElement inputEscolherArquivo;

    @FindBy(id = "file-submit")
    protected WebElement btnUpload;

    @FindBy(id = "uploaded-files")
    protected WebElement listUploadedFilesNames;


}
