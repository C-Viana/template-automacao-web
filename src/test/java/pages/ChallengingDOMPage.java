package pages;

import driver.Driver;
import objects.ChallengingDOM;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;

import common.General;

public class ChallengingDOMPage extends ChallengingDOM {

    public ChallengingDOMPage() {
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

    public BufferedImage getCanvasAsImage() {
        BufferedImage bi = new BufferedImage(canvas.getRect().width, canvas.getRect().height, BufferedImage.TYPE_INT_ARGB);
        try {
            bi = ImageIO.read(canvas.getScreenshotAs(OutputType.FILE));
            return bi;
        } catch (WebDriverException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public WebElement getButton(int index) {
        return buttons.get(index);
    }

    public String getButtonTextByColor(String selectedColorHexCode) {
        for (WebElement webElement : buttons) {
            if (Color.fromString(webElement.getCssValue("background-color")).asHex().equals(selectedColorHexCode)) {
                return webElement.getText();
            }
        }
        return null;
    }

    public void clickButtonByColor(String color) {
        String selectedColorHexCode;
        switch(color.toLowerCase()) {
            case "blue":
            case "azul":
                selectedColorHexCode = "#2ba6cb";
                break;
            case "green":
            case "verde":
                selectedColorHexCode = "#5da423";
                break;
            case "red":
            case "vermelho":
                selectedColorHexCode = "#c60f13";
                break;
            default:
                Assert.fail("A cor selecionada não condiz com as opções esperadas (vermelho, verde e azul). ");
                return;
        }
        for (WebElement webElement : buttons) {
            if (Color.fromString(webElement.getCssValue("background-color")).asHex().equals(selectedColorHexCode)) {
                System.out.println("Texto do botão antes de ser clicado: " + webElement.getText());
                webElement.click();
                break;
            }
        }
        General.waitFor(2);
        System.out.println("Texto do botão após clicado: " + getButtonTextByColor(selectedColorHexCode));
    }

    public List<WebElement> getTableHeader() {
        return tableHead;
    }

    public int getTableColsCount() {
        return tableHead.size();
    }

    public int getTableRowsCount() {
        return tableRows.size();
    }

    public WebElement[][] getTableValues(int rows, int columns) {
        WebElement[][] table = new WebElement[rows][columns+1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if( j == columns-1){
                    table[i][j] = tableRows.get(i).findElement(By.xpath("//a[text()='edit']"));
                    table[i][j+1] = tableRows.get(i).findElement(By.xpath("//a[text()='delete']"));
                }
                else
                    table[i][j] = tableRows.get(i).findElement(By.cssSelector("td:nth-child("+(j+1)+")"));
            }
        }
        return table;
    }

    public void printTable(WebElement[][] table, int rows, int columns) {
        for (int i = 0; i < rows; i++) {
            System.out.print("| ");
            for (int j = 0; j < columns+1; j++) {
                System.out.print(table[i][j].getText() + " | ");
            }
            System.out.println();
        }
    }

}
