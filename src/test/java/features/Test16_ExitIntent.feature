@Test16
Feature: Exit Intent

    @Test16A
    Scenario: Interagir com o modal
        Given que abri a página Herokuapp
        When acessar o link Exit Intent
        And mover o mouse para fora do viewport
        Then confirmo que o modal de saída é exibido

    
