package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicLoading {
    
    @FindBy(tagName = "h3")
    protected WebElement pageTitle;
    protected String txtExpectedTitle = "Dynamically Loaded Page Elements";

    @FindBy(css = "a:nth-child(5)")
    protected WebElement linkExample1;
    protected String txtExpectedLinkExample1 = "Example 1: Element on page that is hidden";

    @FindBy(css = "a:nth-child(8)")
    protected WebElement linkExample2;
    protected String txtExpectedLinkExample2 = "Example 2: Element rendered after the fact";

    @FindBy(id = "loading")
    protected WebElement txtLoading;
    protected String txtExpectedLoading = "Loading...";


    // ---------------- Example 1

    @FindBy(tagName = "h4")
    protected WebElement exampleTitle;
    protected String txtExpectedExample1Title = "Example 1: Element on page that is hidden";

    @FindBy(css = "div#start > button")
    protected WebElement btnStart;
    protected String txtExpectedBtnStart = "Start";

    @FindBy(css = "div#finish") // style="display:none"
    protected WebElement hiddenElement;

    @FindBy(css = "div#finish > h4")
    protected WebElement hiddenElementContent;
    protected String txtExpectedhiddenElementContent = "Hello World!";


    // ---------------- Example 2

    protected String txtExpectedExample2Title = "Example 2: Element rendered after the fact";


}
