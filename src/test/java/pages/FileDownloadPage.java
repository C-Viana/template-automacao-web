package pages;

import driver.Driver;
import objects.FileDownload;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;

public class FileDownloadPage extends FileDownload {

    public FileDownloadPage() {
        PageFactory.initElements( Driver.get(), this );
    }

    public WebElement getTitle() {
        return pageTitle;
    }

    public String getTitleTextExpected() {
        return txtExpectedTitle;
    }

    public List<WebElement> getDownloadLinks() {
        return downloadLinks;
    }

    public WebElement getRandomDownloadItem() {
    	BasePage.waitToBeVisible(downloadLinks.get(0), 5);
        return downloadLinks.get(new Random().nextInt(downloadLinks.size()));
    }
    
    public void realizarDownloadDoArquivo(String url) {
    	BasePage.downloadFile(url, url.split("download/")[1]);
    }
    
}
