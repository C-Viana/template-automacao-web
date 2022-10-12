@Test2
Feature: Add/Remove Elements
    
    @Test2A
    Scenario: Validar direcionamento à sessão A/B Testing
        Given que abri a página Herokuapp
        When acessar o link Add-Remove Elements
        Then adiciono 5 elementos
        And removo todos os elementos adicionados