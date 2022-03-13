package pages;

import driver.Driver;
import objects.BasicAuth;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import common.General;

public class BasicAuthPage {

    private BasicAuth obj = null;

    public BasicAuthPage() {
    	obj = new BasicAuth();
        PageFactory.initElements( Driver.get(), obj );
    }

    public void authenticateByKeyboard( String userName, String passCode) {
        General.typeKeyboard(userName);
        General.waitFor(1);
        General.typeKeyboardTAB();
        General.waitFor(1);
        General.typeKeyboard(passCode);
        General.waitFor(1);
    }

    public void cancelarAutenticacao() {
        General.typeKeyboardTAB();
        General.waitFor(1);
        General.typeKeyboardTAB();
        General.waitFor(1);
        General.typeKeyboardTAB();
        General.waitFor(1);
        General.typeKeyboardENTER();
    }

    public void authenticateByURL(String userName, String passCode) {
        Driver.get().get("https://" + userName + ":" + passCode + "@the-internet.herokuapp.com/basic_auth");
        General.waitFor(3);
        
    }

    public void authenticateByBasicDigest(String userName, String passCode) {
        ((HasAuthentication)Driver.get()).register(UsernameAndPassword.of(userName, passCode));
        Driver.get().get("https://the-internet.herokuapp.com/basic_auth");
    }

    public WebElement getTextPageNotAuthorized() {
        return obj.pageTextNotAuthorized;
    }

    public String getTextExpectedPageNotAuthorized() {
        return obj.txtExpectedNotAuthorized;
    }

    public WebElement getPageTitle() {
        return obj.pageTitle;
    }

    public String getTextExpectedPageTitle() {
        return obj.txtExpectedTitle;
    }

    public WebElement getPageInformation() {
        return obj.pageInformation;
    }

    public String getTextExpectedPageInformation() {
        return obj.txtPageInformation;
    }
    
}
