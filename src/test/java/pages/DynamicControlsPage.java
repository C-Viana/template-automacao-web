package pages;

import driver.Driver;
import objects.DynamicControls;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlsPage extends DynamicControls {

    public DynamicControlsPage() {
        PageFactory.initElements( Driver.get(), this );
    }

    public WebElement getTitle() {
        return pageTitle;
    }

    public String getExpectedTxtTitle() {
        return txtExpectedTitle;
    }

    public WebElement getSubtitle() {
        return pageSubtitle;
    }

    public String getExpectedTxtSubtitle() {
        return txtExpectedSubtitle;
    }

    public WebElement getCheckbox() {
        return checkbox;
    }

    public WebElement getBtnRemoveAddCheckbox() {
        return btnAddRemoveCheckbox;
    }

    public WebElement getLoadingElement() {
        return txtLoading;
    }

    public String getExpectedTextLoading() {
        return txtExpectedLoading;
    }

    public WebElement getMessageElement() {
        return txtMessageElement;
    }

    public String getTextAddedCheckbox() {
        return txtExpectedAddedCheckbox;
    }

    public String getTextRemovedCheckbox() {
        return txtExpectedRemovedCheckbox;
    }

    public WebElement getInput() {
        return input;
    }

    public WebElement getBtnEnableDisableInput() {
        return btnEnableDisableInput;
    }

    public String getExpectedTextEnabledInput() {
        return txtExpectedEnabledInput;
    }

    public String getExpectedTextDisabledInput() {
        return txtExpectedDisabledInput;
    }
    
    
}
