package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasicAuth {
    
    @FindBy( tagName = "body" )
    protected WebElement pageTextNotAuthorized;
    protected String txtExpectedNotAuthorized = "Not authorized";

    @FindBy(tagName = "h3")
    protected WebElement pageTitle;
    protected String txtExpectedTitle = "Basic Auth";

    @FindBy( tagName = "p" )
    protected WebElement pageInformation;
    protected String txtPageInformation = "Congratulations! You must have the proper credentials.";
}
