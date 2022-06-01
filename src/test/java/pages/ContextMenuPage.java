package pages;

import driver.Driver;
import objects.ContextMenu;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import common.General;

public class ContextMenuPage extends ContextMenu {

    public ContextMenuPage() {
        PageFactory.initElements( Driver.get(), this );
    }

    public WebElement getTitle() {
        return pageTitle;
    }

    public String getCurrentTextTitle() {
        return pageTitle.getText().trim();
    }

    public String getExpectedTextTitle() {
        return txtExpectedTitle;
    }

    public void clickHotspotComponent() {
        General.setChromePosition();
        General.setChromeDimensions();
        General.rightClickElement(hotSpot);
    }

    public Alert getAlert() {
        return General.getAlert(5);
    }

    public String getAlertExpectedText() {
        return txtExpectedAlertBody;
    }
    
}
