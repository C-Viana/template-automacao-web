package pages;

import driver.Driver;
import objects.ABTestingVariation1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ABTestingVariation1Page extends ABTestingVariation1 {

    public ABTestingVariation1Page() {
        PageFactory.initElements( Driver.get(), this );
    }

    public WebElement getTitle() {
        return pageTitle;
    }

    public String getTitleExpectedA() {
        return txtPageTitleExpectedA;
    }

    public String getTitleExpectedB() {
        return txtPageTitleExpectedB;
    }

    public WebElement getInformation() {
        return pageInformation;
    }

    public String getInformationTextExpected() {
        return txtPageInformation;
    }
    
}
