package common;

import java.time.Duration;

import driver.Driver;
import io.cucumber.java.Scenario;

import org.openqa.selenium.By;
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

    public static String getFeature() {
        return feature;
    }

    public static Scenario getScenario() {
        return scenario;
    }

    public static void setFeature(String featureName) {
        feature = featureName;
    }

    public static void setScenario(Scenario cucumberScenario) {
        scenario = cucumberScenario;
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
     * 
     * public static void waitFor( Integer timeInSeconds ) {
     * try {
     * Thread.sleep( (timeInSeconds == null ) ? DEFAULT_WAIT_TIME :
     * timeInSeconds*1000 );
     * } catch (InterruptedException e) {
     * Logger.getLogger(General.class.getName()).log(Level.WARNING, "Erro para
     * utilizar Thread.sleep()", e);
     * Thread.currentThread().interrupt();
     * }
     * }
     */

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
}
