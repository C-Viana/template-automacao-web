package pages;

import driver.Driver;
import objects.ABTestingVariation1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ABTestingVariation1Page {

    private ABTestingVariation1 obj = null;

    public ABTestingVariation1Page() {
    	obj = new ABTestingVariation1();
        PageFactory.initElements( Driver.get(), obj );
    }

    public WebElement getTitle() {
        return obj.pageTitle;
    }

    public String getTitleExpectedA() {
        return obj.txtPageTitleExpectedA;
    }

    public String getTitleExpectedB() {
        return obj.txtPageTitleExpectedB;
    }

    public WebElement getInformation() {
        return obj.pageInformation;
    }

    public String getInformationTextExpected() {
        return obj.txtPageInformation;
    }
    
}
