package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DisappearingElements 
{
    @FindBy( tagName = "h3" )
    protected WebElement pageTitle;
    protected String txtPageTitleExpected = "Disappearing Elements";

    @FindBy(tagName = "p")
    protected WebElement pageDescription;
    protected String txtPageDescriptionExpected = "This example demonstrates when elements on a page change by disappearing/reappearing on each page load.";

    @FindBy(xpath = "//li[1]/a")
    protected WebElement btnHome;
    protected String btnTextHomeExpected = "Home";

    @FindBy(xpath = "//li[2]/a")
    protected WebElement btnAbout;
    protected String btnTextAboutExpected = "About";

    @FindBy(xpath = "//li[3]/a")
    protected WebElement btnContactUs;
    protected String btnTextContactUsExpected = "Contact Us";

    @FindBy(xpath = "//li[4]/a")
    protected WebElement btnPortfolio;
    protected String btnTextPortfolioExpected = "Portfolio";

    @FindBy(xpath = "//li[5]/a")
    protected WebElement btnGallery;
    protected String btnTextGalleryExpected = "Gallery";

    
}
