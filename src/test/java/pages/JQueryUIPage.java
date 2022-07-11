package pages;

import driver.Driver;
import objects.JQueryUI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class JQueryUIPage extends JQueryUI {

    public JQueryUIPage() {
        PageFactory.initElements( Driver.get(), this );
    }

    public WebElement getTitle() {
        return pageTitle;
    }

    public String getTitleTextExpected() {
        return txtExpectedTitle;
    }

    public WebElement getItemEnabled() {
        return enabledListItem;
    }

    public String getItemEnabledTextExpected() {
        return enabledListItemTextExpected;
    }

    public WebElement getItemDownload() {
        return downloadsListItem;
    }

    public String getItemDownloadTextExpected() {
        return downloadsListItemTextExpected;
    }

    public WebElement getItemPDF() {
        return pdfListItem;
    }

    public String getItemPDFTextExpected() {
        return pdfListItemTextExpected;
    }

    public WebElement getItemCSV() {
        return csvListItem;
    }

    public String getItemCSVTextExpected() {
        return csvListItemTextExpected;
    }

    public WebElement getItemExcel() {
        return excelListItem;
    }

    public String getItemExcelTextExpected() {
        return excelListItemTextExpected;
    }

    

    
    
    
}
