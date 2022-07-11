package pages;

import driver.Driver;
import objects.HorizontalSlider;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HorizontalSliderPage extends HorizontalSlider {

    public HorizontalSliderPage() {
        PageFactory.initElements( Driver.get(), this );
    }

    public WebElement getTitle() {
        return pageTitle;
    }

    public String getTitleTextExpected() {
        return txtExpectedTitle;
    }

    public WebElement getInputSlider() {
        return inputSlider;
    }

    public WebElement getSliderCounter() {
        return txtSliderCounter;
    }

    
    
    
}
