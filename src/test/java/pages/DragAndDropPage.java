package pages;

import driver.Driver;
import objects.DragAndDrop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;

public class DragAndDropPage extends DragAndDrop {

    public DragAndDropPage() {
        PageFactory.initElements( Driver.get(), this );
    }

    public WebElement getTitle() {
        BasePage.waitToBeVisible(pageTitle, 5);
        return pageTitle;
    }

    public String getCurrentTextTitle() {
        return pageTitle.getText().trim();
    }

    public String getExpectedTextTitle() {
        return txtExpectedTitle;
    }

    public WebElement getBoxA() {
        return boxA;
    }

    public WebElement getBoxB() {
        return boxB;
    }

    public String getTextBoxA() {
        return boxAText.getText().trim();
    }

    public String getTextBoxB() {
        return boxBText.getText().trim();
    }

    public String getExpectedTextBoxA() {
        return txtExpectedBoxA;
    }

    public String getExpectedTextBoxB() {
        return txtExpectedBoxB;
    }
    
    public void arrastarElementoAParaElementoB(String nomeImgElementoA, String nomeImgElementoB) {
    	BasePage.dragAndDropSikulix(nomeImgElementoA, nomeImgElementoB);
    }
    
}
