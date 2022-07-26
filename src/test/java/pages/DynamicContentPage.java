package pages;

import driver.Driver;
import objects.DynamicContent;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;

public class DynamicContentPage extends DynamicContent {

    public DynamicContentPage() {
        PageFactory.initElements( Driver.get(), this );

        imagesPath = new ArrayList<String>();
        imagesPath.add("https://the-internet.herokuapp.com/img/avatars/Original-Facebook-Geek-Profile-Avatar-1.jpg"); // MARIO
        imagesPath.add("https://the-internet.herokuapp.com/img/avatars/Original-Facebook-Geek-Profile-Avatar-2.jpg"); // BOBA FETT
        imagesPath.add("https://the-internet.herokuapp.com/img/avatars/Original-Facebook-Geek-Profile-Avatar-3.jpg"); // Punisher
        imagesPath.add("https://the-internet.herokuapp.com/img/avatars/Original-Facebook-Geek-Profile-Avatar-5.jpg"); // Harley Quinn
        imagesPath.add("https://the-internet.herokuapp.com/img/avatars/Original-Facebook-Geek-Profile-Avatar-6.jpg"); // STAR TROOPER
        imagesPath.add("https://the-internet.herokuapp.com/img/avatars/Original-Facebook-Geek-Profile-Avatar-7.jpg"); // ???
    }
    
    public void recarregarTela() {
        BasePage.refreshPage();
    }

    public WebElement getTitle() {
        BasePage.waitToBeVisible(pageTitle, 5);
        return pageTitle;
    }

    public WebElement getLinkClickHere() {
        return linkSetStatic;
    }

    public String getCurrentTextTitle() {
        return pageTitle.getText().trim();
    }

    public String getExpectedTextTitle() {
        return txtExpectedTitle;
    }

    public List<WebElement> getImages() {
        return images;
    }

    public List<WebElement> getPhrases() {
        BasePage.waitToBeVisible(phraseContent.get(0), 5);
        return phraseContent;
    }

    public String[] getImagesURL() {
        BasePage.waitToBeVisible(images.get(0), 6);
        String[] urls = new String[3];
        for (int i = 0; i < urls.length; i++) {
            urls[i] = images.get(i).getAttribute("src");
        }
        return urls;
    }

    public boolean imageUrlMatches( String reference ) {
        return imagesPath.stream().anyMatch( e -> e.equals(reference) );
    }

    public String[] getTexts() {
        String[] txts = new String[3];
        for (int i = 0; i < txts.length; i++) {
            txts[i] = phraseContent.get(i).getText().trim();
        }
        return txts;
    }
    
}
