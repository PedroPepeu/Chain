let linkHomeUser = "http://localhost:8080/profile";

const lgout = '#logout';

describe('Checkup-home-user', function() {
    this.beforeEach(() => {
        cy.visit(linkHomeUser);
    });

    it('Check-components', function() {
        cy.get('#addProjectInput').should('exist');
        cy.get('#addCreationButton').should('exist');
    });

    it('Check-create-work', function() {
        cy.get('#addProjectInput').type('Project test 1');
        cy.get('#addCreationButton').click();

        // should check something in the database of the user
    });

    it('Check-create-work-null', function() {
        cy.get('#addCreationButton').click();

        // should check something in the database of the user
    });

    it('Check-create-work-space', function() {
        cy.get('#addProjectInput').type(' ');
        cy.get('#addCreationButton').click();

        // should check something in the database of the user
    });

    // continue
});