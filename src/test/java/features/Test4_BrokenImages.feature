@Test4
Feature: Broken Images

    @Test4A
    Scenario: Validar o status de todas as imagens da página
        Given que abri a página Herokuapp
        When acessar o link Broken Images
        Then confirmo o acesso à página Broken Images
        And valido as imagens em tela

    @Test4B
    Scenario: Validar o status da imagem 1
        Given que abri a página Herokuapp
        When acessar o link Broken Images
        Then confirmo o acesso à página Broken Images
        And valido a imagem 1 em tela com status 404

    @Test4C
    Scenario: Validar o status da imagem 2
        Given que abri a página Herokuapp
        When acessar o link Broken Images
        Then confirmo o acesso à página Broken Images
        And valido a imagem 2 em tela com status 404
        
    @Test4D
    Scenario: Validar o status da imagem 3
        Given que abri a página Herokuapp
        When acessar o link Broken Images
        Then confirmo o acesso à página Broken Images
        And valido a imagem 3 em tela com status 200