package pages;

import driver.Driver;
import objects.Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;

public class FramesPage extends Frames {

    public FramesPage() {
        PageFactory.initElements( Driver.get(), this );
    }

    public WebElement getTitle() {
        return pageTitle;
    }

    public String getTitleTextExpected() {
        return txtExpectedTitle;
    }

    public WebElement getLinkNestedFrames() {
        return linkNestedFrames;
    }

    public String getLinkNestedFramesTextExpected() {
        return linkNestedFramesExpectedText;
    }

    public WebElement getLinkIFrames() {
        return linkIFrame;
    }

    public String getLinkIFramesTextExpected() {
        return linkIFrameExpectedText;
    }
    
    public void returnDefaultContext() {
    	BasePage.setDefaultContext();
    }

    public void enterContextFrameTop() {
        BasePage.setContext(frameTop);
    }

    public void enterContextFrameLeft() {
        BasePage.setContext(frameLeft);
    }

    public void enterContextFrameMiddle() {
        BasePage.setContext(frameMiddle);
    }

    public void enterContextFrameRight() {
        BasePage.setContext(frameRight);
    }

    public void enterContextFrameBottom() {
        BasePage.setContext(frameBottom);
    }

    public WebElement getIFrameTitle() {
        return titleIFrame;
    }

    public String getIFrameTitleTextExpected() {
        return titleIFrameExpectedText;
    }

    public void enterContextIFrame() {
        BasePage.setContext(iFrame);
    }

    public WebElement getIFrameParagraph() {
        return iFrameParagraph;
    }
    
    public String getTextFromFrameBody() {
    	return BasePage.getTextFromElement(By.tagName("body"));
    }
    
    public int getQuantityFramesTop() {
    	return BasePage.getElements(By.tagName("frame")).size();
    }
    
}
