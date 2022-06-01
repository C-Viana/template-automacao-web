package objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Checkboxes {

    @FindBy(tagName = "h3")
    protected WebElement pageTitle;
    protected String txtExpectedTitle = "Checkboxes";

    @FindBy( css = "#checkboxes > input" )
    protected List<WebElement> checkboxes;

    @FindBy( id = "checkboxes" )
    protected WebElement checkboxForm;

}
