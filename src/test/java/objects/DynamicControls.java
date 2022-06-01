package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicControls {
    
    @FindBy(tagName = "h4")
    protected WebElement pageTitle;
    protected String txtExpectedTitle = "Dynamic Controls";

    @FindBy(tagName = "p")
    protected WebElement pageSubtitle;
    protected String txtExpectedSubtitle = "This example demonstrates when elements (e.g., checkbox, input field, etc.) are changed asynchronously.";

    @FindBy(id = "checkbox")
    protected WebElement checkbox;

    @FindBy(css = "#checkbox-example > button")
    protected WebElement btnAddRemoveCheckbox;

    @FindBy(id = "loading")
    protected WebElement txtLoading;
    protected String txtExpectedLoading = "Wait for it...";

    @FindBy(id = "message")
    protected WebElement txtMessageElement;
    protected String txtExpectedRemovedCheckbox = "It's gone!";
    protected String txtExpectedAddedCheckbox = "It's back!";



    @FindBy( css = "#input-example > input" )
    protected WebElement input;

    @FindBy(css = "#input-example > button")
    protected WebElement btnEnableDisableInput;

    protected String txtExpectedEnabledInput = "It's enabled!";
    protected String txtExpectedDisabledInput = "It's disabled!";
}
