
@Test5
Feature: Challenging DOM

    Scenario: Validar reconhecimento do conteúdo canvas
        Given que abri a página Herokuapp
        When acessar o link Challenging DOM
        Then confirmo o acesso à página Challenging DOM
        And valido o conteúdo do canvas

    Scenario: Clico no botão com a cor azul
        Given que abri a página Herokuapp
        When acessar o link Challenging DOM
        Then clico no botão "azul"
    
    Scenario: Clico no botão com a cor verde
        Given que abri a página Herokuapp
        When acessar o link Challenging DOM
        Then clico no botão "verde"

    Scenario: Clico no botão com a cor vermelho
        Given que abri a página Herokuapp
        When acessar o link Challenging DOM
        Then clico no botão "vermelho"

    Scenario: Realizo uma leitura da tabela
        Given que abri a página Herokuapp
        When acessar o link Challenging DOM
        Then capturo a tabela da página