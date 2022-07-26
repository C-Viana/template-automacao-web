package pages;

import driver.Driver;
import objects.FileUpload;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.hotkey.Keys;

import common.BasePage;

public class FileUploadPage extends FileUpload {

    public FileUploadPage() {
        PageFactory.initElements( Driver.get(), this );
        BasePage.setChromeDimensionsLocalVariable();
        BasePage.setChromePositionLocalVariable();
    }

    public WebElement getTitle() {
        BasePage.waitToBeVisible(pageTitle, 5);
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
    
    public void siculixClicarNoComponente(String nameImgSikulix) {
    	BasePage.clickSikulix(nameImgSikulix);
        BasePage.waitFor(2);
    }
    
    public void siculixDigitarTexto(String textToSend) {
    	BasePage.writeSikulix(textToSend);
        BasePage.waitFor(2);
    }
    
    public void siculixTeclarEnter() {
        BasePage.pressKeyboardSikulix(Keys.ENTER);
        BasePage.waitFor(2);
    }
    
}
