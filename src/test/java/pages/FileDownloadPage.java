package pages;

import driver.Driver;
import objects.FileDownload;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

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
        return downloadLinks.get(new Random().nextInt(downloadLinks.size()));
    }
    
    
    
}
