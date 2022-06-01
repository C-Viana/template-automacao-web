package pages;

import driver.Driver;
import objects.DynamicContent;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DynamicContentPage extends DynamicContent {

    public DynamicContentPage() {
        PageFactory.initElements( Driver.get(), this );

        imagesPath = new ArrayList<String>();
        imagesPath.add("https://the-internet.herokuapp.com/img/avatars/Original-Facebook-Geek-Profile-Avatar-1.jpg");
        imagesPath.add("https://the-internet.herokuapp.com/img/avatars/Original-Facebook-Geek-Profile-Avatar-2.jpg");
        imagesPath.add("https://the-internet.herokuapp.com/img/avatars/Original-Facebook-Geek-Profile-Avatar-5.jpg");
        imagesPath.add("https://the-internet.herokuapp.com/img/avatars/Original-Facebook-Geek-Profile-Avatar-6.jpg");
        imagesPath.add("https://the-internet.herokuapp.com/img/avatars/Original-Facebook-Geek-Profile-Avatar-7.jpg");
    }

    public WebElement getTitle() {
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
        return phraseContent;
    }

    public String[] getImagesURL() {
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
