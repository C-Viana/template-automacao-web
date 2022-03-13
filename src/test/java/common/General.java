package common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

import driver.Driver;
import io.cucumber.java.Scenario;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class General {
    /**
     * Tempo padrão de espera para as funções wait implementadas nesta fonte.
     */
    private static final int DEFAULT_WAIT_TIME = 10;
    private static String feature;
    private static Scenario scenario;

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
     * Retorna um objeto web Alert após a espera condicionada. 
     * Caso o tempo informado seja null, será considerado o tempo definido como padrão. 
     * @param timeInSeconds
     * @return
     */
    public static Alert getAlert(Integer timeInSeconds) {
        return new WebDriverWait(Driver.get(), Duration.ofSeconds((timeInSeconds == null) ? DEFAULT_WAIT_TIME
                : timeInSeconds)).until(ExpectedConditions.alertIsPresent() );
    }

}
