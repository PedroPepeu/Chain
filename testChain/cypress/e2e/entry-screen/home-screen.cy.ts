let linkHomePage = "http://127.0.0.1:5000/index";

describe('Home', function() {
    it('Home-button', function() {
        cy.visit(linkHomePage);

        cy.get('#Home-button').click();

        cy.url().should('eq', linkHomePage);
    });

    it('Home-button', function() {
        cy.visit(linkHomePage);

        cy.get('#Login-button').click();

        cy.url().should('eq', linkLoginUser);
    });

    it('Home-button', function() {
        cy.visit(linkHomePage);

        cy.get('#Chain-home-button').click();

        cy.url().should('eq', linkHomePage);
    });
});