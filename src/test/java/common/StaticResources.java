package common;

public class StaticResources {
    
    private StaticResources() {
        throw new IllegalStateException("Erro para iniciar a classe General.");
    }

    /**
     * LINK DA PÁGINA DE TESTES UTILIZADO NESSE PROJETO.
     */
    public static final String HEROKUAPP = "https://the-internet.herokuapp.com/";

    /**
     * PROPRIEDADE PARA IDENTIFICAÇÃO DO CHROMEDRIVER PELO SISTEMA LOCAL.
     */
    public static final String CHROMEDRIVERPROPERTY = "webdriver.chrome.driver";

    /**
     * DIRETÓRIO NA MÁQUINA LOCAL ONDE ESTÁ O CHROMEDRIVER.
     */
    public static final String CHROME_DRIVER = "C:\\Desenvolvimento\\WebDrivers\\chromedriver_106.exe";

    /**
     * LOCAL DE DESTINO PARA TESTES DE DOWNLOADS DE ARQUIVOS.
     */
    public static final String DOWNLOADS_DIR = System.getProperty("user.dir") + "/downloads";

    /**
     * LOCAL DE ARMAZENAMENTO DAS IMAGENS PARA SEREM UTILIZADAS PELOS MÉTODOS DO
     * SIKULIX.
     * O RETORNO ATUAL É UMA STRING COM O VALOR "PROJECT_ROOT_PATH/images_for_sikuli/"
     */
    public static final String SIKULIX_SOURCE_IMAGES = System.getProperty("user.dir") + "/images_for_sikuli/";

    /**
     * DETERMINA O TIPO DE EXECUÇÃO DOS TESTES.
     * SE FOR FALSE, OS TESTES SERÃO EXECUTADOS DE MANEIRA INDEPENDENTE E CADA UM GERARÁ UMA ÚNICA EVIDÊNCIA COMO RESULTADO.
     * SE TRUE, OS TESTES SERÃO EXECUTADOS COMO SUITE E SERÁ GERADA UMA ÚNICA EVIDÊNCIA PARA TODOS OS TESTES.
     */
    public static boolean suite_test = false;
    
    /**
     * Tempo padrão de espera para as funções wait implementadas nesta fonte.
     */
    public static final int DEFAULT_WAIT_TIME = 10;
}
