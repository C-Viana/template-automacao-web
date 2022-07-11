package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExitIntent {
    
    @FindBy(tagName = "h3")
    protected WebElement pageTitle;
    protected String txtExpectedTitle = "Exit Intent";

    @FindBy(tagName = "p")
    protected WebElement txtBody;
    protected String txtExpectedBody = "Mouse out of the viewport pane and see a modal window appear.";


    // ---------------- Modal

    @FindBy(css = "div#ouibounce-modal")
    protected WebElement modal; // style="display: block;

    @FindBy(css = "div.modal-title > h3")
    protected WebElement modalTitle;
    protected String txtExpectedModalTitle = "THIS IS A MODAL WINDOW";

    @FindBy(css = "div.modal-body > p")
    protected WebElement modalBody;
    protected String txtExpectedModalBody = "It's commonly used to encourage a user to take an action (e.g., give their e-mail address to sign up for something).";

    @FindBy(css = "div.modal-footer > p")
    protected WebElement modalClose;
    protected String txtExpectedModalClose = "Close";


}
