package common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import driver.Driver;
import io.cucumber.java.Scenario;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

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
     * Retorna o nome da feature extraída do arquivo com a escrita Gherkin que
     * estiver em execução.
     * <br>
     * 
     * @return
     */
    public static String getFeature() {
        return feature;
    }

    /**
     * Retorna o objeto de cenário de teste em execução extraído do Cucumber.
     * <br>
     * 
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
     * <br>
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
     * <br>
     * 
     * @param cucumberScenario
     */
    public static void setScenario(Scenario cucumberScenario) {
        scenario = cucumberScenario;
    }

    /**
     * Cria os diretórios informados através de um caminho definido em uma string.
     * Se os diretórios já existirem, nenhuma ação será realizada.
     * <br>
     * Exemplo: <br>
     * path = "D:/PDI/template-automacao-web/uploads"
     * <br>
     * 
     * @param path
     */
    public static void createFolders(String path) {
        try {
            File f = new File(path);
            if (!f.exists()) {
                f.mkdirs();
            }
        } catch (Exception e) {
            Logger.getLogger(General.class.getName()).log(Level.WARNING, "Erro para utilizar createFolders(String path)", e);
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Utiliza a biblioteca Apache Commons para realizar um download de arquivo
     * diretamente através de uma URL.
     * <br>
     * O arquivo baixado será armazenado na pasta /downloads, no diretório do
     * próprio projeto.
     * <br>
     * Caso esta pasta não exista, ela será criada ao executar esta função.
     * <br>
     * 
     * @param url
     * @param fileName
     */
    public static void downloadFile(String url, String fileName) {
        try {
            createFolders(StaticResources.DOWNLOADS_DIR);
            FileUtils.copyURLToFile(new URL(url), new File(StaticResources.DOWNLOADS_DIR + "/" + fileName));
        } catch (MalformedURLException e) {
            Logger.getLogger(General.class.getName()).log(Level.WARNING, "Erro para utilizar downloadFile(String url, String fileName)", e);
            Thread.currentThread().interrupt();
        } catch(IOException e){
            Logger.getLogger(General.class.getName()).log(Level.WARNING, "Erro para utilizar downloadFile(String url, String fileName)", e);
            Thread.currentThread().interrupt();
        }
    }

    /**
     * A partir do locator informado, retornará uma lista de todos os elementos
     * encontrados que atendam à referência.
     * <br>
     * 
     * @param locator
     * @return java.util.List<WebElement>
     */
    public static List<WebElement> getElements(By locator) {
        return Driver.get().findElements(locator);
    }

    /**
     * A partir do locator informado, retornará o texto do elemento encontrado que
     * atenda à referência.
     * <br>
     * 
     * @param locator
     * @return String
     */
    public static String getTextFromElement(By locator) {
        return Driver.get().findElement(locator).getText().trim();
    }

    /**
     * Para interações web em que for necessário realizar o preenchimento de campos
     * via Javascript, <br>
     * informe neste método o elemento web (ex.: input) e o valor a ser inserido.
     * <br>
     * 
     * @param element
     * @param value
     */
    public static void sendKeysByJavascript( WebElement element, String value ) {
        try {
            ((JavascriptExecutor) Driver.get()).executeScript("document[0].value = '" + value + "';", element);
        } catch (Exception e) {
            Logger.getLogger(General.class.getName()).log(Level.WARNING, "Erro para utilizar sendKeysByJavascript(WebElement element, String value)", e);
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Para interações web em que for necessário realizar um clique em um componente
     * via
     * Javascript, <br>
     * informe neste método o elemento web (ex.: button) a ser clicado.
     * <br>
     * 
     * @param element
     * @param value
     */
    public static void clickByJavascript(WebElement element) {
        try {
            ((JavascriptExecutor) Driver.get()).executeScript("document[0].click()", element);
        } catch (Exception e) {
            Logger.getLogger(General.class.getName()).log(Level.WARNING, "Erro para utilizar clickByJavascript(WebElement element)", e);
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Através de um WebElement informado, utiliza a classe
     * selenium.interactions.Actions para mover o mouse às coordenadas x e y desta
     * referência e, então, realizar um clique nesta posição.
     * <br>
     * 
     * @param element
     */
    public static void clickByCoordinates(WebElement element) {
        try {
            Point coords = General.getElementCenter(element);
            Actions act = new Actions(Driver.get());
            act.moveToElement(element, 0, 0).build().perform();
            act.moveByOffset(coords.x, coords.y).click().build().perform();
            act = null;
        } catch (Exception e) {
            Logger.getLogger(General.class.getName()).log(Level.WARNING, "Erro para utilizar clickByCoordinates(WebElement element)", e);
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Informar as coordenadas x e y de um ponto do viewport para executar um clique
     * através da classe selenium.interactions.Actions.
     * <br>
     * 
     * @param posX
     * @param posY
     */
    public static void clickByCoordinates(int posX, int posY) {
        try {
            Actions act = new Actions(Driver.get());
            act.moveByOffset(posX, posY).click().build().perform();
            act = null;
        } catch (Exception e) {
            Logger.getLogger(General.class.getName()).log(Level.WARNING, "Erro para utilizar clickByCoordinates(int posX, int posY)", e);
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Para interações web em que for necessário mover a tela para visualizar um
     * elemento, este método <br>
     * realizará um scroll down/up para tentar colocar o elemento dentro da área do
     * viewport. <br>
     * Em algumas situações, pode ser necessário utilizar este recurso duas vezes.
     * <br>
     * 
     * @param element
     */
    public static void scrollIntoByJavascript(WebElement element) {
        try {
            ((JavascriptExecutor) Driver.get()).executeScript("document.querySelector('a.sb_pagN').scrollIntoView();", element);
        } catch (Exception e) {
            Logger.getLogger(General.class.getName()).log(Level.WARNING, "Erro para utilizar scrollIntoByJavascript(WebElement element)", e);
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Retorna os atributos HTML que estejam implementados na tag deste WebElement.
     * <br>
     * 
     * @param element
     * @return
     */
    public static String getTagAttributesByJavaScript(WebElement element) {
        String test = null;
        try {
            test = ((JavascriptExecutor) Driver.get()).executeScript("return arguments[0].attributes;", element).toString();
        } catch (Exception e) {
            Logger.getLogger(General.class.getName()).log(Level.WARNING, "Erro para utilizar getTagAttributesByJavaScript(WebElement element)", e);
            Thread.currentThread().interrupt();
        }
        return test;
    }

    /**
     * Este método utiliza a classe Robot do Java para simular interações do teclado
     * ao navegador. <br>
     * Informe uma String com o valor que deseja simular a digitação.
     * <br>
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
            Logger.getLogger(General.class.getName()).log(Level.WARNING, "Erro para utilizar typeKeyboard(String word)", e);
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Atribui à variável General.chromePosition as coordenadas atuais da posição
     * da janela do browser.
     * <br>
     * 
     * @param posX
     * @param posY
     */
    public static void setChromePositionLocalVariable() {
        chromePosition = Driver.get().manage().window().getPosition();
    }

    /**
     * Atribui à variável General.chromeDimensions as coordenadas atuais das dimensões
     * da janela do browser.
     * <br>
     * 
     * @param width
     * @param height
     */
    public static void setChromeDimensionsLocalVariable() {
        chromeDimensions = Driver.get().manage().window().getSize();
    }

    /**
     * Retorna um objeto Point com a atual posição da janela do browser na tela.
     * <br>
     * 
     * @return
     */
    public static Point getChromePosition() {
        return chromePosition;
    }

    /**
     * Retorna um objeto Dimension com o atual tamanho da janela do browser na tela.
     * <br>
     * 
     * @return
     */
    public static Dimension getChromeDimensions() {
        return chromeDimensions;
    }

    /**
     * Realiza uma atualização na tela, semelhante ao comando F5 para a maioria dos
     * navegadores.
     * <br>
     * 
     */
    public static void refreshPage() {
        Driver.get().navigate().refresh();
    }

    /**
     * Dado um WebElement, retorna um objeto Point com as coordenadas x e y que
     * representam o ponto central deste elemento.
     * <br>
     * 
     * @param element
     * @return
     */
    public static Point getElementCenter( WebElement element ) {
        int width = element.getSize().width;
        int posX = element.getLocation().x;

        int height = element.getSize().height;
        int posY = element.getLocation().y;
        return new Point( posX+(width/2), posY+(height/2) );
    }

    /**
     * Através da classe selenium.interactions.Actions, realiza a ação de arrastar
     * um objeto origem para a posição de um objeto destino.
     * <br>
     * Este método pode não funcionar corretamente devido a limitações da própria
     * classe Actions.
     * <br>
     * Se esse for o caso, considere a viabilidade de utilizar o método
     * dragAndDropSikulix().
     * <br>
     * 
     * @param origin
     * @param destination
     */
    public static void dragElementTo( WebElement origin, WebElement destination ) {
        try {
            new Actions(Driver.get()).dragAndDrop(origin, destination).build().perform();
        } catch (Exception e) {
            Logger.getLogger(General.class.getName()).log(Level.WARNING, "Erro para utilizar dragElementTo(WebElement origin, WebElement destination)", e);
            Thread.currentThread().interrupt();
            //throw e;
        }
    }

    /**
     * Através da biblioteca sikuli.script, realiza a ação de arrastar
     * um objeto origem para a posição de um objeto destino.
     * <br>
     * Para tanto, é necessário coletar uma imagem dos elementos da página que
     * representem o objeto a ser arrastado e o objeto/local onde deve ser movido.
     * <br>
     * Estas imagens devem ser armazenadas no caminho expresso pela variável
     * StaticResources.SIKULIX_SOURCE_IMAGES
     * <br>
     * Por fim, passar como parâmetros o nome da imagem que representa o "objeto A"
     * a ser movido e o nome da imagem que representa o "objeto B"/local para
     * finalizar a ação.
     * <br>
     * 
     * @param origin
     * @param destination
     */
    public static void dragAndDropSikulix( String origin, String destination ) {
        Screen screen = new Screen();
        try {
			screen.dragDrop(screen.find(StaticResources.SIKULIX_SOURCE_IMAGES + origin), screen.find(
                    StaticResources.SIKULIX_SOURCE_IMAGES + destination));
            screen = null;
		} catch (FindFailed e) {
			Logger.getLogger(General.class.getName()).log(Level.WARNING, "Erro para utilizar dragAndDropSikulix(String origin, String destination)", e);
            Thread.currentThread().interrupt();
		}
    }

    /**
     * Através da biblioteca sikuli.script realiza um clique no elemento em tela de
     * acordo com uma imagem de referência.
     * <br>
     * Para tanto, é necessário coletar uma imagem do WebElement da página que
     * represente o objeto a ser clicado.
     * <br>
     * Esta imagem deve ser armazenada no caminho expresso pela variável
     * StaticResources.SIKULIX_SOURCE_IMAGES
     * <br>
     * Por fim, passar como parâmetro o nome da imagem que representa o objeto
     * a ser clicado
     * <br>
     * 
     * @param imgRef
     */
    public static void clickSikulix( String imgRef ) {
        Screen screen = new Screen();
        try {
            screen.find(StaticResources.SIKULIX_SOURCE_IMAGES + imgRef);
            screen.click();
            screen = null;
        } catch (FindFailed e) {
            Logger.getLogger(General.class.getName()).log(Level.WARNING, "Erro para utilizar clickSikulix(String imgRef)", e);
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Através da biblioteca sikuli.script simula a digitação de um texto em
     * elemento em tela de
     * acordo com uma imagem de referência.
     * <br>
     * Informar o texto a ser digitado como parâmetro.
     * <br>
     * Note, entretanto, que é preciso garantir que o campo para entrada de texto
     * esteja pronto/apto para receber este dado.
     * <br>
     * 
     * @param text
     */
    public static void writeSikulix(String text) {
        try {
            Screen screen = new Screen();
            screen.write(text);
            screen = null;
        } catch (Exception e) {
            Logger.getLogger(General.class.getName()).log(Level.WARNING,
                    "Erro para utilizar writeSikulix(String text)", e);
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Através da biblioteca sikuli.script simula a utilização de uma tecla através
     * das ações key down e key up respectivamente.
     * <br>
     * Como parâmetro, considere utilizar a classe org.sikuli.hotkey.Keys, que
     * retornará um valor em String apropriado a este método.
     * <br>
     * 
     * @param key
     */
    public static void pressKeyboardSikulix(String key) {
        try {
            Screen screen = new Screen();
            screen.keyDown(key);
            screen.keyUp(key);
            screen = null;
        } catch (Exception e) {
            Logger.getLogger(General.class.getName()).log(Level.WARNING,
                    "Erro para utilizar pressKeyboardSikulix(String key)", e);
            Thread.currentThread().interrupt();
        }
    }


    /**
     * Este método utiliza a classe Robot do Java para simular interações do teclado
     * ao navegador. <br>
     * Informe um caractere (char) com o valor que deseja simular a digitação.
     * <br>
     * 
     * @param letter
     */
    public static void typeKeyboard(char letter) {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(letter));
            robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(letter));
        } catch (AWTException e) {
            Logger.getLogger(General.class.getName()).log(Level.WARNING,
                    "Erro para utilizar typeKeyboard(char letter)", e);
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Este método utiliza a classe Robot do Java para simular interações do teclado
     * ao navegador. <br>
     * Realiza a digitação da tecla TAB.
     * 
     */
    public static void typeKeyboardTAB() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot = null;
        } catch (AWTException e) {
            Logger.getLogger(General.class.getName()).log(Level.WARNING,
                    "Erro para utilizar typeKeyboardTAB()", e);
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Este método utiliza a classe Robot do Java para simular interações do teclado
     * ao navegador. <br>
     * Realiza a digitação da tecla ENTER.
     * 
     */
    public static void typeKeyboardENTER() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot = null;
        } catch (Exception e) {
            Logger.getLogger(General.class.getName()).log(Level.WARNING,
                    "Erro para utilizar typeKeyboardENTER()", e);
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Através da classe java.awt.Robot simula a utilização de uma tecla através
     * das ações key press e key release respectivamente.
     * <br>
     * Como parâmetro, considere utilizar a java.awt.event.KeyEvent, que
     * retornará um valor em Integer apropriado a este método.
     * <br>
     * 
     * @param key
     */
    public static void typeKeyboard(int key) {
        try {
            Robot robot = new Robot();
            robot.keyPress(key);
            robot.keyRelease(key);
            robot = null;
        } catch (Exception e) {
            Logger.getLogger(General.class.getName()).log(Level.WARNING,
                    "Erro para utilizar typeKeyboard(int key)", e);
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Através da classe java.awt.Robot simula o movimento do mouse para posicionar
     * o cursor nas coordenadas x e y informadas pelos parâmetros.
     * <br>
     * Atente-se que a classe Robot funciona independente da área do viewport do
     * navegador, considerando todo o tamanho da tela do monitor.
     * <br>
     * Assim, pode ser preciso compensar o posicionamento para atingir as
     * coordenadas esperadas.
     * <br>
     * 
     * @param posX
     * @param posY
     */
    public static void moveMouseTo(int posX, int posY) {
        try {
            Robot robot = new Robot();
            robot.mouseMove(posX, posY);
            robot = null;
        } catch (Exception e) {
            Logger.getLogger(General.class.getName()).log(Level.WARNING,
                    "Erro para utilizar moveMouseTo(int posX, int posY)", e);
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Através da classe selenium.interactions.Actions, simula o posicionamento do
     * mouse sobre um WebElement.
     * <br>
     * Este método não move o cursor do mouse ao objeto informado, mas apenas irá
     * ativar o efeito "hover" sobre ele.
     * <br>
     * 
     * @param element
     */
    public static void hoverElement(WebElement element) {
        try {
            new Actions(Driver.get()).moveToElement(element).build().perform();
        } catch (Exception e) {
            Logger.getLogger(General.class.getName()).log(Level.WARNING,
                    "Erro para utilizar hoverElement(WebElement element)", e);
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Informe uma URL para que o Selenium abra essa página e aguarde que essa
     * esteja pronta.
     * <br>
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
            Thread.sleep( (timeInSeconds == null ) ? DEFAULT_WAIT_TIME : timeInSeconds*1000 );
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
     * <br>
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
     * <br>
     * 
     * @param locator
     * @param timeInSeconds
     */
    public static void waitToBeVisible(By locator, Integer timeInSeconds) {
        new WebDriverWait(Driver.get(), Duration.ofSeconds((timeInSeconds == null) ? DEFAULT_WAIT_TIME
                : timeInSeconds)).until(ExpectedConditions.visibilityOf(Driver.get().findElement(locator)));
    }

    /**
     * Informe um WebElemento e um tempo em segundos para aguardar até que este
     * elemento esteja disponível em tela para ser encontrado
     * pelo Selenium.
     * <br>
     * Este método realizará a espera ignorando as exceções
     * StaleElementReferenceException, NoSuchElementException e NotFoundException.
     * <br>
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

    /**
     * Retorna true se o WebElement informado tiver o atributo "display" diferente
     * de nulo/none.
     * Caso contrário, retornará false.
     * <br>
     * 
     * @param element
     * @return
     */
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
     * Caso o tempo informado seja null, será considerado o tempo definido como
     * padrão.
     * <br>
     * 
     * @param timeInSeconds
     * @return
     */
    public static Alert getAlert(Integer timeInSeconds) {
        return new WebDriverWait(Driver.get(), Duration.ofSeconds((timeInSeconds == null) ? DEFAULT_WAIT_TIME
                : timeInSeconds)).until(ExpectedConditions.alertIsPresent() );
    }

    /**
     * Retorna o foco da página para o contexto principal; saindo de frames/iframes que estejam presentes.
     */
    public static void setDefaultContext() {
        Driver.get().switchTo().defaultContent();
    }

    /**
     * Entra no contexto de um frame/iframe a partir do próprio WebElement que o
     * identifique.
     * <br>
     * 
     * @param frame
     */
    public static void setContext(WebElement frame) {
        Driver.get().switchTo().frame(frame);
    }

    /**
     * Entra no contexto de um frame/iframe pelo índice que o identifique.
     * <br>
     * 
     * @param index
     */
    public static void setContext(int index) {
        Driver.get().switchTo().frame(index);
    }

    /**
     * Através de recursos da classe java.net, retorna o status code ao tentar
     * realizar uma conexão com a URL informada.
     * <br>
     * É realizado um método GET sobre a URL e o status code é retornado como
     * inteiro.
     * <br>
     * Considere utilizar este método para validar o acesso a uma página antes de
     * abri-la ou para validar a integridade de recursos da página de teste
     * (imagens, arquivos de som, etc.).
     * <br>
     * 
     * @param targetUrl
     * @return
     */
    public static int getStatusCodeFromURL(String targetUrl) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(targetUrl).openConnection();
            conn.setRequestMethod("GET");
            return conn.getResponseCode();
        }
        catch (MalformedURLException e) {
            Logger.getLogger(General.class.getName()).log(Level.WARNING,
                    "Erro para utilizar getStatusCodeFromURL(String targetUrl)", e);
            Thread.currentThread().interrupt();
            return 0;
        }
        catch (IOException e) {
            Logger.getLogger(General.class.getName()).log(Level.WARNING,
                    "Erro para utilizar getStatusCodeFromURL(String targetUrl)", e);
            Thread.currentThread().interrupt();
            return 0;
        }
    }

    /**
     * Retorna um objeto java.awt.image.BufferedImage a partir de um WebElement em
     * tela.
     * <br>
     * A imagem será capturada a partir das dimensões do objeto isolado.
     * <br>
     * 
     * @param element
     * @return
     */
    public BufferedImage getImageFromObject( WebElement element ) {
        BufferedImage bi = new BufferedImage(element.getRect().width, element.getRect().height,
                BufferedImage.TYPE_INT_ARGB);
        try {
            bi = ImageIO.read(element.getScreenshotAs(OutputType.FILE));
            return bi;
        } catch (WebDriverException | IOException e) {
            Logger.getLogger(General.class.getName()).log(Level.WARNING,
                    "Erro para utilizar getImageFromObject(WebElement element)", e);
            Thread.currentThread().interrupt();
            return null;
        }
    }

    /**
     * Utiliza a classe net.sourceforge.tess4j.Tesseract para identificar valores de
     * texto em arquivos de imagens.
     * <br>
     * Considere que a imagem não precisa ser um arquivo armazenado localmente.
     * <br>
     * Uma vez que este método espera um objeto java.awt.image.BufferedImage, basta
     * capturar em um objeto Java a imagem do WebElement.
     * <br>
     * 
     * @param img
     * @return
     */
    public static String getTextFromImage(BufferedImage img) {
        Tesseract tesseract = new Tesseract();
        try {
            //tesseract.setLanguage("por");
            tesseract.setDatapath(LoadLibs.extractTessResources("tessdata").getAbsolutePath());
            return tesseract.doOCR(img);
        }
        catch (TesseractException e) {
            Logger.getLogger(General.class.getName()).log(Level.WARNING,
                    "Erro para utilizar getTextFromImage(BufferedImage img)", e);
            Thread.currentThread().interrupt();
            return null;
        }
    }

    /**
     * Através da classe selenium.interactions.Actions, simula um clique com o botão
     * direito do mouse.
     * <br>
     * 
     * @param element
     */
    public static void rightClickOnElement(WebElement element) {
        new Actions(Driver.get()).contextClick(element).perform();
    }

}
