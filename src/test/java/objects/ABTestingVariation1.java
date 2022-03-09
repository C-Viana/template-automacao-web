package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ABTestingVariation1 {
    
    @FindBy( tagName = "h3" )
    public WebElement pageTitle;
    public String txtPageTitleExpectedA = "A/B Test Variation 1";
    public String txtPageTitleExpectedB = "A/B Test Control";

    @FindBy( tagName = "p" )
    public WebElement pageInformation;
    public String txtPageInformation = "Also known as split testing. This is a way in which businesses are able to simultaneously test and learn different versions of a page to see which text and/or functionality works best towards a desired outcome (e.g. a user action such as a click-through).";
}
