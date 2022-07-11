package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavaScriptAlerts {
    
    @FindBy(tagName = "h3")
    protected WebElement pageTitle;
    protected String txtExpectedTitle = "JavaScript Alerts";

    @FindBy(css = "li:nth-child(1) > button")
    protected WebElement btnJSAlert;
    protected String txtExpectedBtnJSAlert = "Click for JS Alert";

    @FindBy(css = "li:nth-child(2) > button")
    protected WebElement btnClickForJSConfirm;
    protected String txtExpectedBtnClickForJSConfirm = "Click for JS Confirm";

    @FindBy(css = "li:nth-child(3) > button")
    protected WebElement btnClickForJSPrompt;
    protected String txtExpectedBtnClickForJSPrompt = "Click for JS Prompt";

    @FindBy(id = "result")
    protected WebElement txtResultText;
    protected String txtExpectedTxtResultAlert = "You successfully clicked an alert";
    protected String txtExpectedTxtResultConfirmOK = "You clicked: Ok";
    protected String txtExpectedTxtResultConfirmCancel = "You clicked: Cancel";
    protected String txtExpectedTxtResultPromptText = "You entered: ";
    protected String txtExpectedTxtResultPromptNull = "You entered: null";
}
