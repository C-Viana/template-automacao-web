package pages;

import driver.Driver;
import objects.BrokenImages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BrokenImagesPage extends BrokenImages {

    public BrokenImagesPage() {
        PageFactory.initElements( Driver.get(), this );
    }

    public WebElement getTitle() {
        return pageTitle;
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
    
}
