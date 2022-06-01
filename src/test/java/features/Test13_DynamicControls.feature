@Test13
Feature: Dynamic Controls

    @Test13A
    Scenario: Remover e adicionar checkbox
        Given que abri a página Herokuapp
        When acessar o link Dynamic Controls
        Then confirmo o acesso à página Dynamic Controls
        And removo o checkbox
        And adiciono o checkbox

    @Test13B
    Scenario: Habilitar e desabilitar input
        Given que abri a página Herokuapp
        When acessar o link Dynamic Controls
        Then confirmo o acesso à página Dynamic Controls
        And habilito o campo de texto para digitar a palavra "Texte dinâmico"
        And desabilito o campo de texto

    
