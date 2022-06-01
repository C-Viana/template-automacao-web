package objects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContextMenu {

    @FindBy(tagName = "h3")
    protected WebElement pageTitle;
    protected String txtExpectedTitle = "Context Menu";

    @FindBy( id = "hot-spot" )
    protected WebElement hotSpot;

    protected Alert alert;
    protected String txtExpectedAlertBody = "You selected a context menu";

}
