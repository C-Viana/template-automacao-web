package pages;

import driver.Driver;
import objects.BasicAuth;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;

public class BasicAuthPage extends BasicAuth {

    public BasicAuthPage() {
        PageFactory.initElements( Driver.get(), this );
    }

    public void authenticateByKeyboard( String userName, String passCode) {
        BasePage.typeKeyboard(userName);
        BasePage.waitFor(1);
        BasePage.typeKeyboardTAB();
        BasePage.waitFor(1);
        BasePage.typeKeyboard(passCode);
        BasePage.waitFor(1);
    }
    
    public void teclarEnter() {
    	BasePage.typeKeyboardENTER();
    }

    public void cancelarAutenticacao() {
        BasePage.typeKeyboardTAB();
        BasePage.waitFor(1);
        BasePage.typeKeyboardTAB();
        BasePage.waitFor(1);
        BasePage.typeKeyboardTAB();
        BasePage.waitFor(1);
        BasePage.typeKeyboardENTER();
    }

    public void authenticateByURL(String userName, String passCode) {
        Driver.get().get("https://" + userName + ":" + passCode + "@the-internet.herokuapp.com/basic_auth");
        BasePage.waitFor(3);
        
    }

    public void authenticateByBasicDigest(String userName, String passCode) {
        ((HasAuthentication)Driver.get()).register(UsernameAndPassword.of(userName, passCode));
        Driver.get().get("https://the-internet.herokuapp.com/basic_auth");
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
