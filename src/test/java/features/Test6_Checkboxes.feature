@Test6
Feature: Checkboxes
@Test6A
    Scenario: Validar as opções de checkboxes disponíveis
        Given que abri a página Herokuapp
        When acessar o link Checkboxes
        Then confirmo o acesso à página Checkboxes
        And valido as opções disponíveis
@Test6B
    Scenario: Ativo a opção 1 do checkbox
        Given que abri a página Herokuapp
        When acessar o link Checkboxes
        Then marco o checkbox "checkbox 1"
@Test6C
    Scenario: Desativo a opção 2 do checkbox
        Given que abri a página Herokuapp
        When acessar o link Checkboxes
        Then desmarco o checkbox "checkbox 2"