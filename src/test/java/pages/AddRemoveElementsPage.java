package pages;

import driver.Driver;
import objects.AddRemoveElements;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;

public class AddRemoveElementsPage extends AddRemoveElements {

    public AddRemoveElementsPage() {
        PageFactory.initElements( Driver.get(), this );
    }

    public WebElement getTitle() {
        BasePage.waitToBeVisible( pageTitle, 10 );
        return pageTitle;
    }

    public String getTitleExpected() {
        return txtPageTitleExpected;
    }

    public WebElement getButtonAddElement() {
        return buttonAddElement;
    }

    public String getTextButtonAddElement() {
        return txtButtonAddElement;
    }

    public List<WebElement> getButtonRemove() {
        return buttonRemove;
    }

    public String getButtonRemoveTextExpected() {
        return txtButtonRemove;
    }
    
}
