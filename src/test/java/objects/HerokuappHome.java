package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HerokuappHome 
{
    @FindBy( tagName = "h1" )
    public WebElement pageTitle;
    public String txtPageTitleExpected = "Welcome to the-internet";

    @FindBy(tagName = "h1")
    public WebElement pageSubtitle;
    public String txtPageSubtitleExpected = "Available Examples";

    @FindBy(xpath = "//li[1]/a")
    public WebElement linkABTesting;
    public String linkTextABTestingExpected = "A/B Testing";

    @FindBy(xpath = "//li[2]/a")
    public WebElement linkAddRemoveElements;
    public String linkTextAddRemoveElementsExpected = "Add/Remove Elements";

    @FindBy(xpath = "//li[3]/a")
    public WebElement linkBasicAuth;
    public String linkTextBasicAuthExpected = "Basic Auth";

    
}
