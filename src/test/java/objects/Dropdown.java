package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dropdown {
    
    @FindBy(tagName = "h3")
    protected WebElement pageTitle;
    protected String txtExpectedTitle = "Dropdown List";

    @FindBy( id = "dropdown" )
    protected WebElement select;

    protected String selectOptionDefault = "Please select an option";
    protected String selectOption1 = "Option 1";
    protected String selectOption2 = "Option 2";
}
