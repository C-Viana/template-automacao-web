@Test8
Feature: Digest Euthentication
    
    @Test8A
    Scenario: Validar autenticação digest
        Given que abri a página Herokuapp
        When acessar o link Digest Authentication
        Then realizo a autenticação por digest
        And valido sucesso de autenticação via digest
    
    @Test8B
    Scenario: Validar cancelamento da autenticação
        Given que abri a página Herokuapp
        When acessar o link Digest Authentication
        Then cancelo a autenticação
        And valido falha de autenticação via digest