@Test9
Feature: Disappearing Elements
    
    @Test9A
    Scenario: Validar elementos que aparecem
        Given que abri a página Herokuapp
        When acessar o link Disappearing Elements
        Then confirmo o acesso à Disapearing Elements
        And valido que o botão Gallery é exibido após atualização
    
    @Test9B
    Scenario: Validar elementos que desaparecem
        Given que abri a página Herokuapp
        When acessar o link Disappearing Elements
        Then confirmo o acesso à Disapearing Elements
        And valido que o botão Gallery não é exibido após atualização
