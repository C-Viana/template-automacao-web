package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HorizontalSlider {
    
    @FindBy(tagName = "h3")
    protected WebElement pageTitle;
    protected String txtExpectedTitle = "Horizontal Slider";

    @FindBy(tagName = "input")
    protected WebElement inputSlider;

    @FindBy(id = "range")
    protected WebElement txtSliderCounter;


}
