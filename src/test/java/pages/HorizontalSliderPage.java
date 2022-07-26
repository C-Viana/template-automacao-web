package pages;

import driver.Driver;
import objects.HorizontalSlider;

import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;

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
    	BasePage.waitToBeVisible(txtSliderCounter, 5);
        return txtSliderCounter;
    }

    public void clickInputSlider() {
    	BasePage.clickByCoordinates(inputSlider.getLocation().x, inputSlider.getLocation().y);
    }
    
    public void robotTeclarSetaDireita() {
    	BasePage.typeKeyboard(KeyEvent.VK_RIGHT);
    }
    
}
