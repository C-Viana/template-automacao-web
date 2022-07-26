package pages;

import driver.Driver;
import objects.DynamicLoading;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;

public class DynamicLoadingPage extends DynamicLoading {

    public DynamicLoadingPage() {
        PageFactory.initElements( Driver.get(), this );
    }

    public WebElement getTitle() {
        return pageTitle;
    }

    public WebElement getLinkExample1() {
        BasePage.waitToBeVisible(linkExample1, 5);
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
        BasePage.waitToBeVisible(btnStart, 5);
        return btnStart;
    }

    public String getBtnStartTextExpected() {
        return txtExpectedBtnStart;
    }

    public WebElement getLoading() {
        BasePage.waitToBeVisible(txtLoading, 5);
        return txtLoading;
    }

    public String getLoadingTextExpected() {
        return txtExpectedLoading;
    }

    public WebElement getHiddenElement() {
        BasePage.waitToBeVisibleIgnoringExceptions(hiddenElement, null);
        return hiddenElement;
    }
    
    public boolean hiddenElementExistis() {
    	return BasePage.elementExists(hiddenElement);
    }

    public WebElement getHiddenElementContent() {
        return hiddenElementContent;
    }

    public String getHiddenElementContentTextExpected() {
        return txtExpectedhiddenElementContent;
    }


    
    
    
}
