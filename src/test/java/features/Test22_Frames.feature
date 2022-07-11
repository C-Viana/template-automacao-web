@Test22
Feature: Frames

    @Test22A
    Scenario: Nested Frames
        Given que abri a página Herokuapp
        When acessar o link Frames
        And acessar a página de frameset
        Then identifico cada um dos frames

    @Test22B
    Scenario: Interação com iFrame
        Given que abri a página Herokuapp
        When acessar o link Frames
        And acessar a página de iFrame
        Then interajo com o componente iFrame

