package pages;

import driver.Driver;
import objects.ContextMenu;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;

public class ContextMenuPage extends ContextMenu {

    public ContextMenuPage() {
        PageFactory.initElements( Driver.get(), this );
        BasePage.setChromePositionLocalVariable();
        BasePage.setChromeDimensionsLocalVariable();
    }

    public WebElement getTitle() {
        return pageTitle;
    }

    public String getCurrentTextTitle() {
        BasePage.waitToBeVisible(pageTitle, 6);
        return pageTitle.getText().trim();
    }

    public String getExpectedTextTitle() {
        return txtExpectedTitle;
    }

    public void clickHotspotComponent() {
        BasePage.getChromePosition();
        BasePage.getChromeDimensions();
        BasePage.rightClickOnElement(hotSpot);
    }

    public Alert getAlert() {
        try {
            return BasePage.getAlert(5);
        } catch (Exception e) {
            return null;
        }
    }

    public String getAlertExpectedText() {
        return txtExpectedAlertBody;
    }

    public void setToDefaultContext() {
        BasePage.setDefaultContext();
        BasePage.waitFor(2);
    }
    
}
