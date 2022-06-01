package pages;

import driver.Driver;
import objects.DisappearingElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DisappearingElementsPage extends DisappearingElements {
    
    public DisappearingElementsPage() {
        PageFactory.initElements( Driver.get(), this );
    }

    public WebElement getTitle() {
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

    public String getBtnGalleryTextExpected() {
        return btnTextGalleryExpected;
    }

    

}
