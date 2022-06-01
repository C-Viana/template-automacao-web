package pages;

import driver.Driver;
import objects.Dropdown;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends Dropdown {

    public DropdownPage() {
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

    public Select getSelect() {
        return new Select(select);
    }

    public String getExpectedTextOptionDefault() {
        return selectOptionDefault;
    }

    public String getExpectedTextOption1() {
        return selectOption1;
    }

    public String getExpectedTextOption2() {
        return selectOption2;
    }
    
}
