package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HerokuappHome 
{
    @FindBy( tagName = "h1" )
    protected WebElement pageTitle;
    protected String txtPageTitleExpected = "Welcome to the-internet";

    @FindBy(tagName = "h1")
    protected WebElement pageSubtitle;
    protected String txtPageSubtitleExpected = "Available Examples";

    @FindBy(xpath = "//li[1]/a")
    protected WebElement linkABTesting;
    protected String linkTextABTestingExpected = "A/B Testing";

    @FindBy(xpath = "//li[2]/a")
    protected WebElement linkAddRemoveElements;
    protected String linkTextAddRemoveElementsExpected = "Add/Remove Elements";

    @FindBy(xpath = "//li[3]/a")
    protected WebElement linkBasicAuth;
    protected String linkTextBasicAuthExpected = "Basic Auth";

    @FindBy(xpath = "//li[4]/a")
    protected WebElement linkBrokenImages;
    protected String linkTextBrokenImagesExpected = "Broken Images";

    @FindBy(xpath = "//li[5]/a")
    protected WebElement linkChallengingDOM;
    protected String linkTextChallengingDOMExpected = "Challenging DOM";

    @FindBy(xpath = "//li[6]/a")
    protected WebElement linkCheckboxes;
    protected String linkTextCheckboxesExpected = "Checkboxes";

    @FindBy(xpath = "//li[7]/a")
    protected WebElement linkContextMenu;
    protected String linkTextContextMenuExpected = "Context Menu";

    @FindBy(xpath = "//li[8]/a")
    protected WebElement linkDigestAuthentication;
    protected String linkTextDigestAuthenticationExpected = "Digest Authentication";

    @FindBy(xpath = "//li[9]/a")
    protected WebElement linkDisappearingElements;
    protected String linkTextDisappearingElementsExpected = "Disappearing Elements";

    @FindBy(xpath = "//li[10]/a")
    protected WebElement linkDragAndDrop;
    protected String linkTextDragAndDropExpected = "Drag and Drop";

    @FindBy(xpath = "//li[11]/a")
    protected WebElement linkDropdown;
    protected String linkTextDropdownExpected = "Dropdown";

    @FindBy(xpath = "//li[12]/a")
    protected WebElement linkDynamicContent;
    protected String linkTextDynamicContentExpected = "Dynamic Content";

    @FindBy(xpath = "//li[13]/a")
    protected WebElement linkDynamicControls;
    protected String linkTextDynamicControlsExpected = "Dynamic Controls";

    
}
