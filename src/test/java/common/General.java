package common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import driver.Driver;
import io.cucumber.java.Scenario;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class General {
    /**
     * Tempo padrão de espera para as funções wait implementadas nesta fonte.
     */
    private static final int DEFAULT_WAIT_TIME = 10;
    private static String feature;
    private static Scenario scenario;
    private static Point chromePosition;
    private static Dimension chromeDimensions;

    private General() {
        throw new IllegalStateException("Erro para iniciar a classe General.");
    }

    /**
     * Retorna o nome da feature extraída do arquivo com a escrita Gherkin que estiver em execução. 
     * @return
     */
    public static String getFeature() {
        return feature;
    }

    /**
     * Retorna o objeto de cenário de teste em execução extraído do Cucumber.
     * @return
     */
    public static Scenario getScenario() {
        return scenario;
    }

    /**
     * Define o valor da feature em execução para utilização interna deste
     * framework.
     * Este método é utilizada para a criação das evidências de teste, na classe
     * Reporter.
     * 
     * @param featureName
     */
    public static void setFeature(String featureName) {
        feature = featureName;
    }

    /**
     * Armazena o objeto de cenário de teste em execução para utilização interna
     * deste framework.
     * Este método deve ser utilizada preferencialmente antes do teste iniciar, na
     * classe _Hooks e no métodos com a tag @Before.
     * 
     * @param cucumberScenario
     */
    public static void setScenario(Scenario cucumberScenario) {
        scenario = cucumberScenario;
    }

    /**
     * Para interações web em que for necessário realizar o preenchimento de campos
     * via Javascript, <br>
     * informe neste método o elemento web (ex.: input) e o valor a ser inserido.
     * 
     * @param element
     * @param value
     */
    public static void sendKeysByJavascript( WebElement element, String value ) {
        ((JavascriptExecutor)Driver.get()).executeScript("document[0].value = '"+value+"';", element);
    }

    /**
     * Para interações web em que for necessário realizar um clique em um componente via
     * Javascript, <br>
     * informe neste método o elemento web (ex.: button) a ser clicado.
     * 
     * @param element
     * @param value
     */
    public static void clickByJavascript(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("document[0].click()", element);
    }

    /**
     * Para interações web em que for necessário mover a tela para visualizar um
     * elemento, este método <br>
     * realizará um scroll down/up para tentar colocar o elemento dentro da área do
     * viewport. <br>
     * Em algumas situações, pode ser necessário utilizar este recurso duas vezes.
     * 
     * @param element
     */
    public static void scrollIntoByJavascript(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("document.querySelector('a.sb_pagN').scrollIntoView();", element);
    }

    public static String getTagAttributesByJavaScript(WebElement element) {
        String test = ((JavascriptExecutor) Driver.get()).executeScript("return arguments[0].attributes;", element).toString();
        return test;
        // driver.execute_script('var items = {}; for (index = 0; index <
        // arguments[0].attributes.length; ++index) {
        // items[arguments[0].attributes[index].name] =
        // arguments[0].attributes[index].value }; return items;', element)
    }

    /**
     * Este método utiliza a classe Robot do Java para simular interações do teclado
     * ao navegador. <br>
     * Informe uma String com o valor que deseja simular a digitação. 
     * 
     * @param word
     */
    public static void typeKeyboard( String word ) {
        try {
            Robot robot = new Robot();
            for (int i = 0; i < word.length(); i++) {
                robot.keyPress( KeyEvent.getExtendedKeyCodeForChar(word.charAt(i)) );
                robot.keyRelease( KeyEvent.getExtendedKeyCodeForChar(word.charAt(i)) );
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void setChromePosition() {
        chromePosition = Driver.get().manage().window().getPosition();
    }

    public static void setChromeDimensions() {
        chromeDimensions = Driver.get().manage().window().getSize();
    }

    public static Point getChromePosition() {
        return chromePosition;
    }

    public static Dimension getChromeDimensions() {
        return chromeDimensions;
    }

    public static void refreshPage() {
        Driver.get().navigate().refresh();
    }

    public static Point getElementCenter( WebElement element ) {
        int width = element.getSize().width;
        int height = element.getSize().height;
        return new Point( (width/2), (height/2) );
    }

    //TODO: tratar este problema -> nao funciona
    public static void dragElementTo( WebElement element, WebElement destination ) {
        try {
            //Point posB = General.getElementCenter(destination);
            new Actions(Driver.get()).dragAndDrop(element, destination).build().perform();
        } catch (Exception e) {
            System.out.println("Could not drag element!");
            throw e;
        }
    }

    /**
     * Este método utiliza a classe Robot do Java para simular interações do teclado
     * ao navegador. <br>
     * Informe um caractere (char) com o valor que deseja simular a digitação.
     * 
     * @param letter
     */
    public static void typeKeyboard(char letter) {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(letter));
            robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(letter));
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    /**
     * Este método utiliza a classe Robot do Java para simular interações do teclado
     * ao navegador. <br>
     * Realiza a digitação da tecla ENTER.
     * 
     */
    public static void typeKeyboardTAB() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot = null;
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    /**
     * Este método utiliza a classe Robot do Java para simular interações do teclado
     * ao navegador. <br>
     * Realiza a digitação da tecla TAB.
     * 
     */
    public static void typeKeyboardENTER() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Informe uma URL para que o Selenium abra essa página e aguarde que essa
     * esteja pronta.
     * 
     * @param url
     */
    public static void goTo(String url) {
        Driver.get().get(url);
    }
    
    /**
     * Informe um tempo em segundos para que a aplicação espere de maneira
     * incondicional para executar a próxima ação.
     * Caso o parâmetro de tempo seja nulo, será utilizado o valor DEFAULT_WAIT_TIME
     */
    public static void waitFor( Integer timeInSeconds ) {
     try {
        Thread.sleep( (timeInSeconds == null ) ? DEFAULT_WAIT_TIME :
            timeInSeconds*1000 );
        }
        catch (InterruptedException e) {
            Logger.getLogger(General.class.getName()).log(Level.WARNING, "Erro para utilizar Thread.sleep()", e);
            Thread.currentThread().interrupt();
        }
     }

    /**
     * Especifique um WebElement e um tempo em segundos para aguardar até que este
     * elemento esteja disponível em tela para ser encontrado pelo Selenium.
     * Caso o elemento esteja disponível antes do tempo especificado, o teste
     * prosseguirá antes do tempo máximo especificado.
     * Caso o parâmetro de tempo seja nulo, será utilizado o valor DEFAULT_WAIT_TIME
     * 
     * @param element
     * @param timeInSeconds
     */
    public static void waitToBeVisible( WebElement element, Integer timeInSeconds ) {
        new WebDriverWait(Driver.get(), Duration.ofSeconds((timeInSeconds == null) ? DEFAULT_WAIT_TIME
                : timeInSeconds)).until( ExpectedConditions.visibilityOf(element) );
    }

    /**
     * Especifique um locator (By:xpath, By:css, etc) e um tempo em segundos para
     * aguardar até que este elemento esteja disponível em tela para ser encontrado
     * pelo Selenium.
     * Caso o elemento esteja disponível antes do tempo especificado, o teste
     * prosseguirá antes do tempo máximo especificado.
     * Caso o parâmetro de tempo seja nulo, será utilizado o valor DEFAULT_WAIT_TIME
     * 
     * @param locator
     * @param timeInSeconds
     */
    public static void waitToBeVisible(By locator, Integer timeInSeconds) {
        new WebDriverWait(Driver.get(), Duration.ofSeconds((timeInSeconds == null) ? DEFAULT_WAIT_TIME
                : timeInSeconds)).until(ExpectedConditions.visibilityOf(Driver.get().findElement(locator)));
    }

    /**
     * 
     * 
     * @param element
     * @param timeInSeconds
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static Object waitToBeVisibleIgnoringExceptions(WebElement element, Integer timeInSeconds) {
        List<Class> exceptions = new ArrayList<Class>();
        exceptions.add(StaleElementReferenceException.class);
        exceptions.add(NoSuchElementException.class);
        exceptions.add(NotFoundException.class);

        try {
            return new FluentWait(Driver.get())
                    .withTimeout(Duration.ofSeconds((timeInSeconds == null) ? DEFAULT_WAIT_TIME : timeInSeconds))
                    .pollingEvery(Duration.ofSeconds(1))
                    .ignoreAll(exceptions).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean elementExists(WebElement element) {
        try {
            return element.isDisplayed();
        }
        catch (StaleElementReferenceException | NoSuchElementException ex) {
            return false;
        }
    }

    /**
     * Retorna um objeto web Alert após a espera condicionada. 
     * Caso o tempo informado seja null, será considerado o tempo definido como padrão. 
     * @param timeInSeconds
     * @return
     */
    public static Alert getAlert(Integer timeInSeconds) {
        return new WebDriverWait(Driver.get(), Duration.ofSeconds((timeInSeconds == null) ? DEFAULT_WAIT_TIME
                : timeInSeconds)).until(ExpectedConditions.alertIsPresent() );
    }

    public static void setDefaultContext() {
        Driver.get().switchTo().defaultContent();
    }

    public static int getStatusCodeFromURL(String targetUrl) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(targetUrl).openConnection();
            conn.setRequestMethod("GET");
            return conn.getResponseCode();
        }
        catch (MalformedURLException e) {
            return 0;
        }
        catch (IOException e) {
            return 0;
        }
    }

    public static String getTextFromImage(BufferedImage img) {
        Tesseract tesseract = new Tesseract();
        try {
            //tesseract.setLanguage("por");
            tesseract.setDatapath(LoadLibs.extractTessResources("tessdata").getAbsolutePath());
            return tesseract.doOCR(img);
        }
        catch (TesseractException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void rightClickElement(WebElement element) {
        new Actions(Driver.get()).contextClick(element).perform();
    }

}
