@test_3
Feature: Basic Auth

    @test_3A
    Scenario: Validar autenticação cancelada via alert
        Given que abri a página Herokuapp
        When acessar o link Basic Auth
        Then cancelo a autenticação
        And valido a tela a tela com falha de autenticação

    @test_3B
    Scenario: Validar autenticação bem sucedida via alert
        Given que abri a página Herokuapp
        When acessar o link Basic Auth
        Then realizo a autenticação pelo alert do navegador
        And valido a tela a tela de autenticação bem sucedida

    @test_3C
    Scenario: Validar autenticação via alert
        Given que abri a página Herokuapp
        When acessar o link Basic Auth
        Then realizo a autenticação pela URL
        And valido a tela a tela de autenticação bem sucedida