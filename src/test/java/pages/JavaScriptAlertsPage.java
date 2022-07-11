package pages;

import driver.Driver;
import objects.JavaScriptAlerts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptAlertsPage extends JavaScriptAlerts {

    public JavaScriptAlertsPage() {
        PageFactory.initElements( Driver.get(), this );
    }

    public WebElement getTitle() {
        return pageTitle;
    }

    public String getTitleTextExpected() {
        return txtExpectedTitle;
    }

    public WebElement getBtnJSAlert() {
        return btnJSAlert;
    }

    public String getBtnJSAlertTextExpected() {
        return txtExpectedBtnJSAlert;
    }

    public WebElement getBtnClickForJSConfirm() {
        return btnClickForJSConfirm;
    }

    public String getBtnClickForJSConfirmTextExpected() {
        return txtExpectedBtnClickForJSConfirm;
    }

    public WebElement getBtnClickForJSPrompt() {
        return btnClickForJSPrompt;
    }

    public String getBtnClickForJSPromptTextExpected() {
        return txtExpectedBtnClickForJSPrompt;
    }

    public WebElement getTxtResultText() {
        return txtResultText;
    }

    public String getExpectedTxtResultTextAlert() {
        return txtExpectedTxtResultAlert;
    }

    public String getExpectedTxtResultTextConfirmOK() {
        return txtExpectedTxtResultConfirmOK;
    }

    public String getExpectedTxtResultConfirmCancel() {
        return txtExpectedTxtResultConfirmCancel;
    }

    public String getExpectedTxtResultPromptText() {
        return txtExpectedTxtResultPromptText;
    }

    public String getExpectedTxtResultPromptNull() {
        return txtExpectedTxtResultPromptNull;
    }

    
    
    
}
