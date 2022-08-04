@Test29
Feature: JavaScriptAlerts

    @Test29A
    Scenario: Clicar OK no alerta
        Given que abri a página Herokuapp
        When acessar o link JavaScript Alerts
        Then interajo com o alerta

    @Test29B
    Scenario: Clicar OK no alerta tipo confirm
        Given que abri a página Herokuapp
        When acessar o link JavaScript Alerts
        Then clico em OK no alerta de confirmação

    @Test29C
    Scenario: Clicar CANCEL no alerta tipo confirm
        Given que abri a página Herokuapp
        When acessar o link JavaScript Alerts
        Then clico em CANCEL no alerta de confirmação

    @Test29D
    Scenario: Clicar OK no alerta tipo prompt
        Given que abri a página Herokuapp
        When acessar o link JavaScript Alerts
        Then clico em OK no alerta de prompt após digitar "testePrompt"

    @Test29E
    Scenario: Clicar CANCEL no alerta tipo prompt
        Given que abri a página Herokuapp
        When acessar o link JavaScript Alerts
        Then clico em CANCEL no alerta de prompt

