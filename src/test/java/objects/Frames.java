package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Frames {
    
    @FindBy(tagName = "h3")
    protected WebElement pageTitle;
    protected String txtExpectedTitle = "Frames";

    @FindBy(css = "div#content li:nth-child(1) > a")
    protected WebElement linkNestedFrames;
    protected String linkNestedFramesExpectedText = "Nested Frames";

    @FindBy(css = "div#content li:nth-child(2) > a")
    protected WebElement linkIFrame;
    protected String linkIFrameExpectedText = "iFrame";


    // --------------------- Nested Frames ---------------------

    @FindBy(css = "frameset > frame[src='/frame_top']")
    protected WebElement frameTop;

    @FindBy(css = "frameset > frame[src='/frame_left']")
    protected WebElement frameLeft;

    @FindBy(css = "frameset > frame[src='/frame_middle']")
    protected WebElement frameMiddle;

    @FindBy(css = "frameset > frame[src='/frame_right']")
    protected WebElement frameRight;

    @FindBy(css = "frameset > frame[src='/frame_bottom']")
    protected WebElement frameBottom;


    // --------------------- IFrames ---------------------

    @FindBy(css = "div.example > h3")
    protected WebElement titleIFrame;
    protected String titleIFrameExpectedText = "An iFrame containing the TinyMCE WYSIWYG Editor";

    @FindBy(id = "mce_0_ifr")
    protected WebElement iFrame;

    @FindBy(css = "#tinymce > p")
    protected WebElement iFrameParagraph;


}
