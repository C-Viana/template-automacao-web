package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragAndDrop {
    
    @FindBy(tagName = "h3")
    protected WebElement pageTitle;
    protected String txtExpectedTitle = "Drag and Drop";

    @FindBy( id = "column-a" )
    protected WebElement boxA;

    @FindBy(css = "#column-a > header")
    protected WebElement boxAText;
    protected String txtExpectedBoxA = "A";

    @FindBy(id = "column-b")
    protected WebElement boxB;

    @FindBy(css = "#column-b > header")
    protected WebElement boxBText;
    protected String txtExpectedBoxB = "B";
}
