package common;

public class StaticResources {
    
    private StaticResources() {
        throw new IllegalStateException("Erro para iniciar a classe General.");
    }

    // LINKS
    public static final String HEROKUAPP = "https://the-internet.herokuapp.com/";

    // DRIVERS' PROPERTIES
    public static final String CHROMEDRIVERPROPERTY = "webdriver.chrome.driver";

    // DRIVERS' PATH
    public static final String CHROME_98 = "C:/Desenvolvimento/WebDrivers/chromedriver_102.exe";

    public static boolean suite_test = false;
}
