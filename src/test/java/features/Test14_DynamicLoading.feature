@Test14
Feature: Dynamic Loading

    @Test14A
    Scenario: Remover e adicionar checkbox
        Given que abri a página Herokuapp
        When acessar o link Dynamic Loading
        And selecionar o link do exemplo 1
        Then confirmo que há um elemento oculto
        And habilito esse elemento na página

    @Test14B
    Scenario: Habilitar e desabilitar input
        Given que abri a página Herokuapp
        When acessar o link Dynamic Loading
        And selecionar o link do exemplo 2
        Then confirmo que não há elemento oculto
        And habilito esse elemento na página

    
