package pages;

import driver.Driver;
import objects.ExitIntent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;

public class ExitIntentPage extends ExitIntent {

    public ExitIntentPage() {
        PageFactory.initElements( Driver.get(), this );
        BasePage.setChromeDimensionsLocalVariable();
        BasePage.setChromePositionLocalVariable();
    }

    public WebElement getTitle() {
        return pageTitle;
    }

    public String getTitleTextExpected() {
        return txtExpectedTitle;
    }

    public WebElement getBodyContent() {
        return txtBody;
    }

    public String getBodyContentTextExpected() {
        return txtExpectedBody;
    }

    public WebElement getModal() {
        return modal;
    }
    
    public void waitModal() {
    	BasePage.waitToBeVisible(modal, null);
    }

    public WebElement getModalHeader() {
        return modalTitle;
    }

    public String getModalHeaderTextExpected() {
        return txtExpectedModalTitle;
    }

    public WebElement getModalBody() {
        return modalBody;
    }

    public String getModalBodyTextExpected() {
        return txtExpectedModalBody;
    }

    public WebElement getModalFooter() {
        return modalClose;
    }

    public String getModalFooterTextExpected() {
        return txtExpectedModalClose;
    }

    public void moverMouseForaDaTela() {
        BasePage.moveMouseTo( 
        		BasePage.getChromePosition().x+BasePage.getChromeDimensions().width/2, 
        		BasePage.getChromePosition().y+BasePage.getChromeDimensions().height/2 );
        BasePage.waitFor(1);
        BasePage.moveMouseTo( 10, 150 );
    }
    
    
    
}
