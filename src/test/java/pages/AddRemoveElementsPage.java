package pages;

import driver.Driver;
import objects.AddRemoveElements;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AddRemoveElementsPage {

    private AddRemoveElements obj = null;

    public AddRemoveElementsPage() {
    	obj = new AddRemoveElements();
        PageFactory.initElements( Driver.get(), obj );
    }

    public WebElement getTitle() {
        return obj.pageTitle;
    }

    public String getTitleExpected() {
        return obj.txtPageTitleExpected;
    }

    public WebElement getButtonAddElement() {
        return obj.buttonAddElement;
    }

    public String getTextButtonAddElement() {
        return obj.txtButtonAddElement;
    }

    public List<WebElement> getButtonRemove() {
        return obj.buttonRemove;
    }

    public String getButtonRemoveTextExpected() {
        return obj.txtButtonRemove;
    }
    
}
