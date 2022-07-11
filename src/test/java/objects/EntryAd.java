package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EntryAd {
    
    @FindBy(tagName = "h3")
    protected WebElement pageTitle;
    protected String txtExpectedTitle = "Entry Ad";

    @FindBy(css = "a#restart-ad")
    protected WebElement linkClickHere;
    protected String txtExpectedLinkClickHere = "click here";


    // ---------------- Modal

    @FindBy(css = "div#modal")
    protected WebElement modal; // style="display: block;

    @FindBy(css = "div#modal h3")
    protected WebElement modalTitle;
    protected String txtExpectedModalTitle = "THIS IS A MODAL WINDOW";

    @FindBy(css = "div.modal-body > p")
    protected WebElement modalBody;
    protected String txtExpectedModalBody = "It's commonly used to encourage a user to take an action (e.g., give their e-mail address to sign up for something or disable their ad blocker).";

    @FindBy(css = "div.modal-footer > p")
    protected WebElement modalClose;
    protected String txtExpectedModalClose = "Close";


}
