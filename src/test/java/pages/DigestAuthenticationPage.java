package pages;

import driver.Driver;
import objects.DigestAuthentication;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DigestAuthenticationPage extends DigestAuthentication {

    public DigestAuthenticationPage() {
        PageFactory.initElements( Driver.get(), this );
    }

    public void authenticateByBasicDigest(String userName, String passCode) {
        ((HasAuthentication)Driver.get()).register(UsernameAndPassword.of(userName, passCode));
        Driver.get().get("https://the-internet.herokuapp.com/digest_auth");
    }

    public WebElement getTextPageNotAuthorized() {
        return pageTextNotAuthorized;
    }

    public String getTextExpectedPageNotAuthorized() {
        return txtExpectedNotAuthorized;
    }

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public String getTextExpectedPageTitle() {
        return txtExpectedTitle;
    }

    public WebElement getPageInformation() {
        return pageInformation;
    }

    public String getTextExpectedPageInformation() {
        return txtPageInformation;
    }
    
}
