package pages;

import driver.Driver;
import objects.DynamicLoading;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPage extends DynamicLoading {

    public DynamicLoadingPage() {
        PageFactory.initElements( Driver.get(), this );
    }

    public WebElement getTitle() {
        return pageTitle;
    }

    public WebElement getLinkExample1() {
        return linkExample1;
    }

    public String getLinkExample1TextExpected() {
        return txtExpectedLinkExample1;
    }

    public WebElement getLinkExample2() {
        return linkExample2;
    }

    public String getLinkExample2TextExpected() {
        return txtExpectedLinkExample2;
    }

    public WebElement getExampleTitle() {
        return exampleTitle;
    }

    public String getExample1TitleTextExpected() {
        return txtExpectedExample1Title;
    }

    public String getExample2TitleTextExpected() {
        return txtExpectedExample2Title;
    }

    public WebElement getBtnStart() {
        return btnStart;
    }

    public String getBtnStartTextExpected() {
        return txtExpectedBtnStart;
    }

    public WebElement getLoading() {
        return txtLoading;
    }

    public String getLoadingTextExpected() {
        return txtExpectedLoading;
    }

    public WebElement getHiddenElement() {
        return hiddenElement;
    }

    public WebElement getHiddenElementContent() {
        return hiddenElementContent;
    }

    public String getHiddenElementContentTextExpected() {
        return txtExpectedhiddenElementContent;
    }


    
    
    
}
