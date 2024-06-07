let linkHomeUser = "http://localhost:8080/profile";
let linkLoginUser = "http://localhost:8080/login";

const lgout = '#logout';
const projName = '#addProjectInput';
const projAdd = '#addCreationButton';

describe('Checkup-home-user', function() {
    beforeEach(() => {
        cy.visit(linkHomeUser);
    });

    it('Checking-logout', function() {
        cy.get(lgout).should('exists');
    });

    it('Checking-name-project', function() {
        cy.get(projName).should('exists');
    });

    it('Checking-project-creation', function() {
        cy.get(projAdd).should('exists');
    });

    it('Loggin-out', function() {
        cy.get(lgout).click();

        cy.url().should('eq', linkLoginUser);
    });
});