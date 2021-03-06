package pages;

import driver.Driver;
import objects.Hover;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;

public class HoverPage extends Hover {

    public HoverPage() {
        PageFactory.initElements( Driver.get(), this );
    }

    public WebElement getTitle() {
        return pageTitle;
    }

    public String getTitleTextExpected() {
        return txtExpectedTitle;
    }

    public List<WebElement> getProfileCards() {
        return cardsProfile;
    }
    
    public void hoverProfileCard(int index) {
    	BasePage.hoverElement(cardsProfile.get(index));
    }

    public List<WebElement> getProfileNames() {
        return txtProfileNames;
    }

    public String getProfileNameExpected() {
        return txtProfileNamesExpected;
    }

    public List<WebElement> getProfileLinks() {
        return linkViewProfile;
    }

    public String getProfileLinksTextExpected() {
        return linkViewProfileExpected;
    }

    
    
    
}
