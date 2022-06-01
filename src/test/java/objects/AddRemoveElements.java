package objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddRemoveElements {
    
    @FindBy( tagName = "h3" )
    protected WebElement pageTitle;
    protected String txtPageTitleExpected = "Add/Remove Elements";

    @FindBy( css = "div.example>button" )
    protected WebElement buttonAddElement ;
    protected String txtButtonAddElement = "Add Element";

    @FindBy(css = "div>button.added-manually")
    protected List<WebElement> buttonRemove;
    protected String txtButtonRemove = "Delete";

}
