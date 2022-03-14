package objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrokenImages {

    @FindBy(tagName = "h3")
    protected WebElement pageTitle;
    protected String txtExpectedTitle = "Broken Images";

    @FindBy( css = ".example>img" )
    protected List<WebElement> images;
}
