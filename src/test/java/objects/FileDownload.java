package objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileDownload {
    
    @FindBy(tagName = "h3")
    protected WebElement pageTitle;
    protected String txtExpectedTitle = "File Download";


    @FindBy(css = "#content a")
    protected List<WebElement> downloadLinks;


}
