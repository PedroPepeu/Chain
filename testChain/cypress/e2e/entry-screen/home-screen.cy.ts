let linkHomePage = "http://localhost:8080/";
let linkLoginUser = "http://localhost:8080/login";

describe('Home', function() {
    beforeEach(() => {
        cy.visit(linkHomePage);
    });

    it('Check-link', function() {
        cy.url().should('eq', linkHomePage);
    });

    it('User-button', function() {
        cy.get('#bt_login').click();

        cy.url().should('eq', linkLoginUser);
    });
});