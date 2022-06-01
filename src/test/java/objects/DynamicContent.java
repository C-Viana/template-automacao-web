package objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicContent {
    
    @FindBy(tagName = "h3")
    protected WebElement pageTitle;
    protected String txtExpectedTitle = "Dynamic Content";

    @FindBy(css = "code+a")
    protected WebElement linkSetStatic;

    @FindBy( css = "div>img" )
    protected List<WebElement> images;
    protected List<String> imagesPath;

    @FindBy( css = "div#content > div > div.large-10" )
    protected List<WebElement> phraseContent;
    protected List<String> textExpectedPhrases;
}
