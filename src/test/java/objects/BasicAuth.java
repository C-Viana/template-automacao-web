package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasicAuth {
    
    @FindBy( tagName = "body" )
    public WebElement pageTextNotAuthorized;
    public String txtExpectedNotAuthorized = "Not authorized";

    @FindBy(tagName = "h3")
    public WebElement pageTitle;
    public String txtExpectedTitle = "Basic Auth";

    @FindBy( tagName = "p" )
    public WebElement pageInformation;
    public String txtPageInformation = "Congratulations! You must have the proper credentials.";
}
