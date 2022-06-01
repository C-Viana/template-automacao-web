@Test12
Feature: Dynamic Content

    @Test12A
    Scenario: Validar elementos aleatórios
        Given que abri a página Herokuapp
        When acessar o link Dynamic Content
        Then confirmo o acesso à página Dynamic Content
        And valido conteúdo aleatório

    @Test12B
    Scenario: Validar elementos estáticos
        Given que abri a página Herokuapp
        When acessar o link Dynamic Content
        Then confirmo o acesso à página Dynamic Content
        And valido conteúdo estático
