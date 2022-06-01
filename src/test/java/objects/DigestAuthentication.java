package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DigestAuthentication {
    
    @FindBy( css = "div.error-code" )
    protected WebElement pageTextNotAuthorized;
    protected String txtExpectedNotAuthorized = "HTTP ERROR 401";

    @FindBy(tagName = "h3")
    protected WebElement pageTitle;
    protected String txtExpectedTitle = "Digest Auth";

    @FindBy( tagName = "p" )
    protected WebElement pageInformation;
    protected String txtPageInformation = "Congratulations! You must have the proper credentials.";
}
