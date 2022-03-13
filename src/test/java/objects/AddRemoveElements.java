package objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddRemoveElements {
    
    @FindBy( tagName = "h3" )
    public WebElement pageTitle;
    public String txtPageTitleExpected = "Add/Remove Elements";

    @FindBy( css = "div.example>button" )
    public WebElement buttonAddElement ;
    public String txtButtonAddElement = "Add Element";

    @FindBy(css = "div>button.added-manually")
    public List<WebElement> buttonRemove;
    public String txtButtonRemove = "Delete";

}
