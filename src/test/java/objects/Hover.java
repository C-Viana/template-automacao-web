package objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Hover {
    
    @FindBy(tagName = "h3")
    protected WebElement pageTitle;
    protected String txtExpectedTitle = "Hovers";

    @FindBy(css = ".figure > img")
    protected List<WebElement> cardsProfile;

    @FindBy(tagName = "h5")
    protected List<WebElement> txtProfileNames;
    protected String txtProfileNamesExpected = "name: user";

    @FindBy(css = ".figcaption > a")
    protected List<WebElement> linkViewProfile;
    protected String linkViewProfileExpected = "View profile";


}
