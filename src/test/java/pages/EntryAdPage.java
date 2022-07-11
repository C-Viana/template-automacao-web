package pages;

import driver.Driver;
import objects.EntryAd;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class EntryAdPage extends EntryAd {

    public EntryAdPage() {
        PageFactory.initElements( Driver.get(), this );
    }

    public WebElement getTitle() {
        return pageTitle;
    }

    public String getTitleTextExpected() {
        return txtExpectedTitle;
    }

    public WebElement getModal() {
        return modal;
    }

    public WebElement getModalHeader() {
        return modalTitle;
    }

    public String getModalHeaderTextExpected() {
        return txtExpectedModalTitle;
    }

    public WebElement getModalBody() {
        return modalBody;
    }

    public String getModalBodyTextExpected() {
        return txtExpectedModalBody;
    }

    public WebElement getModalFooter() {
        return modalClose;
    }

    public String getModalFooterTextExpected() {
        return txtExpectedModalClose;
    }

    public WebElement getLinkClickHere() {
        return linkClickHere;
    }

    public String getLinkClickHereTextExpected() {
        return txtExpectedLinkClickHere;
    }


    
    
    
}
