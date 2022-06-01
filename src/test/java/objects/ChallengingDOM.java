package objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChallengingDOM {

    @FindBy(tagName = "h3")
    protected WebElement pageTitle;
    protected String txtExpectedTitle = "Challenging DOM";

    @FindBy( id = "canvas" )
    protected WebElement canvas;

    @FindBy( css = "a.button" )
    protected List<WebElement> buttons;

    @FindBy(css = "thead > tr > th")
    protected List<WebElement> tableHead;

    @FindBy(css = "tbody > tr")
    protected List<WebElement> tableRows;

}
