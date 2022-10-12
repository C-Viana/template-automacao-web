@Test3
Feature: Basic Auth

    @Test3A
    Scenario: Validar autenticação cancelada via alert
        Given que abri a página Herokuapp
        When acessar o link Basic Auth
        Then cancelo a autenticação
        And valido a tela a tela com falha de autenticação

    @Test3B
    Scenario: Validar autenticação bem sucedida via alert
        Given que abri a página Herokuapp
        When acessar o link Basic Auth
        Then realizo a autenticação pelo alert do navegador
        And valido a tela a tela de autenticação bem sucedida

    @Test3C
    Scenario: Validar autenticação via alert
        Given que abri a página Herokuapp
        When acessar o link Basic Auth
        Then realizo a autenticação pela URL
        And valido a tela a tela de autenticação bem sucedida