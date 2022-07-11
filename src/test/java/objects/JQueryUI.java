package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JQueryUI {
    
    @FindBy(tagName = "h3")
    protected WebElement pageTitle;
    protected String txtExpectedTitle = "JQueryUI - Menu";

    @FindBy(css = "ul#menu > li:nth-child(2) > a")
    protected WebElement enabledListItem;
    protected String enabledListItemTextExpected = "Enabled";

    @FindBy(css = "ul#menu > li:nth-child(2) > ul > li:nth-child(1) > a")
    protected WebElement downloadsListItem;
    protected String downloadsListItemTextExpected = "Downloads";

    @FindBy(css = "ul#menu > li:nth-child(2) > ul > li:nth-child(1) > ul > li:nth-child(1) > a")
    protected WebElement pdfListItem;
    protected String pdfListItemTextExpected = "PDF";

    @FindBy(css = "ul#menu > li:nth-child(2) > ul > li:nth-child(1) > ul > li:nth-child(2) > a")
    protected WebElement csvListItem;
    protected String csvListItemTextExpected = "CSV";

    @FindBy(css = "ul#menu > li:nth-child(2) > ul > li:nth-child(1) > ul > li:nth-child(3) > a")
    protected WebElement excelListItem;
    protected String excelListItemTextExpected = "Excel";


}
