let linkLoginUser = "http://localhost:8080/login";
let linkHomeUser = "http://localhost:8080/profile";

const email = '#Email';
const pass = '#password';
const button = '#bt_login';

// test suite name
describe('Login', function() {
    this.beforeEach(() => {
        cy.visit(linkLoginUser);
    });

    // test case
    it('Check-login-components', function() {
        cy.get(email).should('exist');
        cy.get(pass).should('exist');
        cy.get(button).should('exist');
    });

    it('Blank', function() {
        cy.get(button).click();

        cy.url().should('eq', linkLoginUser);
    });

    it('Without-email', function() {
       cy.get(pass).type('pass');

       cy.get(button).click();

       cy.url().should('eq', linkLoginUser);
    });

    it('Default-password', function() {
        cy.get(email).type('user');

        cy.get(button).click();
        cy.url().should('eq', linkLoginUser);
    });

    it('Black-space', function() {
        cy.get(email).type(' ');
        cy.get(pass).type(' ');

        cy.get(button).click();
        cy.url().should('eq', linkLoginUser);
    });

    it('Complete-login', function() {
        cy.get(email).type('user@user.com');
        cy.get(pass).type('pass');

        cy.get(button).click();

        cy.url().should('eq', linkLoginUser);
    });
});