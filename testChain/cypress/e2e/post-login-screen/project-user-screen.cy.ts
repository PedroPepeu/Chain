let linkProjectUser = "http://localhost:8080/project";

describe('Check-project-page', function() {
    it('Check-home-component', function() {
        cy.visit(linkProjectUser);

        cy.get('#').should('exist');
    });
});