package pages;

import driver.Driver;
import objects.Checkboxes;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CheckboxesPage extends Checkboxes {

    public CheckboxesPage() {
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

    public List<WebElement> getCheckboxOptions() {
        return checkboxes;
    }

    public List<String> getCheckboxOptionText() {
        List<String> elements = Arrays.asList(checkboxForm.getText().split("\n"));
        return elements;
    }

    public void listCheckboxOptions() {
        for (int i = 0; i < checkboxes.size(); i++) {
            boolean b = checkboxes.get(i).isSelected();
            System.out.print((b) ? "CHECKED" : "UNCHECKED");
            System.out.println(" -> " + getCheckboxOptionText().get(i).trim());
        }
    }

    public void clickCheckBox( boolean expectedStatus, String opt ) {
        for (int i = 0; i < checkboxes.size(); i++) {
            if( getCheckboxOptionText().get(i).trim().toLowerCase().equals(opt.toLowerCase()) && checkboxes.get(i).isSelected() == expectedStatus ) {
                checkboxes.get(i).click();
                return;
            }
        }
    }
    
}
