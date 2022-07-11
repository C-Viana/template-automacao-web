@Test7
Feature: Context Menu
@Test7A
    Scenario: Validar clique direito e exibição de alert
        Given que abri a página Herokuapp
        When acessar o link Context Menu
        Then valido a exibição do alert ao clicar com o botão direito na área marcada
        And encerro o alert