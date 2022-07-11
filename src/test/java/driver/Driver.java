package driver;

import java.time.Duration;

import common.StaticResources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    
    private static WebDriver driver = null;

    public static WebDriver get() {
        if( driver == null ) {
            System.setProperty(StaticResources.CHROMEDRIVERPROPERTY, StaticResources.CHROME_DRIVER);
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout( Duration.ofSeconds(50) );
        }
        return driver;
    }

    public static void close() {
        if( driver != null ) {
            driver.close();
            driver.quit();
            driver = null;
        }
    }

}
