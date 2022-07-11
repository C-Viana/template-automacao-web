package pages;

import driver.Driver;
import objects.Frames;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

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

    public WebElement getFrameTop() {
        return frameTop;
    }

    public WebElement getFrameLeft() {
        return frameLeft;
    }

    public WebElement getFrameMiddle() {
        return frameMiddle;
    }

    public WebElement getFrameRight() {
        return frameRight;
    }

    public WebElement getFrameBottom() {
        return frameBottom;
    }

    public WebElement getIFrameTitle() {
        return titleIFrame;
    }

    public String getIFrameTitleTextExpected() {
        return titleIFrameExpectedText;
    }

    public WebElement getIFrame() {
        return iFrame;
    }

    public WebElement getIFrameParagraph() {
        return iFrameParagraph;
    }
    
    
    
}
