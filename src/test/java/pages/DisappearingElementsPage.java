package pages;

import driver.Driver;
import objects.DisappearingElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;

public class DisappearingElementsPage extends DisappearingElements {
    
    public DisappearingElementsPage() {
        PageFactory.initElements( Driver.get(), this );
    }
    
    public void atualizarTela() {
    	BasePage.refreshPage();
    }

    public WebElement getTitle() {
        BasePage.waitToBeVisible(pageTitle, 6);
        return pageTitle;
    }

    public WebElement getDescription() {
        return pageDescription;
    }

    public String getTitleExpected() {
        return txtPageTitleExpected;
    }

    public String getDescriptionExpected() {
        return txtPageDescriptionExpected;
    }

    public WebElement getBtnHome() {
        return btnHome;
    }

    public String getBtnHomeTextExpected() {
        return btnTextHomeExpected;
    }

    public WebElement getBtnAbout() {
        return btnAbout;
    }

    public String getBtnAboutTextExpected() {
        return btnTextAboutExpected;
    }

    public WebElement getBtnContactUs() {
        return btnContactUs;
    }

    public String getBtnContactUsTextExpected() {
        return btnTextContactUsExpected;
    }

    public WebElement getBtnPortfolio() {
        return btnPortfolio;
    }

    public String getBtnPortfolioTextExpected() {
        return btnTextPortfolioExpected;
    }

    public WebElement getBtnGallery() {
        return btnGallery;
    }
    
    public boolean btnGaleriaIsVisible() {
    	return BasePage.elementExists(btnGallery);
    }
    
    public Object aguardarBtnGaleria() {
    	return BasePage.waitToBeVisibleIgnoringExceptions(btnGallery, 5);
    }

    public String getBtnGalleryTextExpected() {
        return btnTextGalleryExpected;
    }

    

}
