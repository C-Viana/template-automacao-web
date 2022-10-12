
@Test5
Feature: Challenging DOM
		
		@Test5A
    Scenario: Validar reconhecimento do conteúdo canvas
        Given que abri a página Herokuapp
        When acessar o link Challenging DOM
        Then confirmo o acesso à página Challenging DOM
        And valido o conteúdo do canvas
		
		@Test5B
    Scenario: Clico no botão com a cor azul
        Given que abri a página Herokuapp
        When acessar o link Challenging DOM
        Then clico no botão "azul"
    
    @Test5C
    Scenario: Clico no botão com a cor verde
        Given que abri a página Herokuapp
        When acessar o link Challenging DOM
        Then clico no botão "verde"
		
		@Test5D
    Scenario: Clico no botão com a cor vermelho
        Given que abri a página Herokuapp
        When acessar o link Challenging DOM
        Then clico no botão "vermelho"
		
		@Test5E
    Scenario: Realizo uma leitura da tabela
        Given que abri a página Herokuapp
        When acessar o link Challenging DOM
        Then capturo a tabela da página