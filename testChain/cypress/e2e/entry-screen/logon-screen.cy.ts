let linkLogonUser = "http://localhost:8080/cadastro";
let linkLoginUser = "http://localhost:8080/login";

const user = '#username';
const pass = '#password';
const passC = '#passwordConfirmacao';
const email = '#email';
const button = '#buttonRegistrar';

describe('Logon', function() {
    beforeEach(() => {
        cy.visit(linkLogonUser);
    });

    it('Check-logon-components', function() {
        cy.get(user).should('exist');
        cy.get(pass).should('exist');
        cy.get(passC).should('exist');
        cy.get(email).should('exist');
        cy.get(button).should('exist');
    });

    it('Default', function() {
        cy.get(button).click();

        cy.url().should('eq', linkLogonUser);
    });

    it('Default-username', function() {
        cy.get(pass).type('pass');
        cy.get(passC).type('pass');
        cy.get(email).type('teste@teste.com');

        cy.get(button).click();

        cy.url().should('eq', linkLogonUser);
    });

    it('Default-password', function() {
        cy.get(user).type('user');
        cy.get(email).type('teste@teste.com');

        cy.get(button).click();

        cy.url().should('eq', linkLogonUser);
    });

    it('Default-email', function() {
        cy.get(user).type('user');
        cy.get(pass).type('pass');
        cy.get(passC).type('pass');

        cy.get(button).click();

        cy.url().should('eq', linkLogonUser);
    });

    it('Black-space', function() {
        cy.get(user).type(' ');
        cy.get(pass).type(' ');
        cy.get(passC).type(' ');
        cy.get(email).type(' ');

        cy.get(button).click();

        cy.url().should('eq', linkLogonUser);
    });

    it('Black-space-username', function() {
        cy.get(user).type(' ');
        cy.get(pass).type('pass');
        cy.get(passC).type('pass');
        cy.get(email).type('teste@teste.com');

        cy.get(button).click();

        cy.url().should('eq', linkLogonUser);
    });

    it('Black-space-password-correct-pass', function() {
        cy.get(user).type('user');
        cy.get(pass).type(' ');
        cy.get(passC).type(' ');
        cy.get(email).type('teste@teste.com');

        cy.get(button).click();

        cy.url().should('eq', linkLogonUser);
    });

    it('Black-space-password-incorrect-pass-double-space', function() {
        cy.get(user).type('user');
        cy.get(pass).type(' ');
        cy.get(passC).type('  ');
        cy.get(email).type('teste@teste.com');

        cy.get(button).click();

        cy.url().should('eq', linkLogonUser);
    });

    it('Black-space-password-incorrect-pass', function() {
        cy.get(user).type('user');
        cy.get(pass).type(' ');
        cy.get(passC).type('pass');
        cy.get(email).type('teste@teste.com');

        cy.get(button).click();

        cy.url().should('eq', linkLogonUser);
    });

    it('Black-space-email', function() {
        cy.get(user).type('user');
        cy.get(pass).type('pass');
        cy.get(passC).type('pass');
        cy.get(email).type(' ');

        cy.get(button).click();

        cy.url().should('eq', linkLogonUser);
    });

    it('Not-username', function() {
        cy.get(pass).type('pass');
        cy.get(passC).type('pass');
        cy.get(email).type('teste@teste.com');

        cy.get(button).click();

        cy.url().should('eq', linkLogonUser);
    });

    it('Not-both-pass', function() {
        cy.get(user).type('user');
        cy.get(email).type('teste@teste.com');

        cy.get(button).click();

        cy.url().should('eq', linkLogonUser);
    });

    it('Not-pass', function() {
        cy.get(user).type('user');
        cy.get(passC).type('pass');
        cy.get(email).type('teste@teste.com');

        cy.get(button).click();

        cy.url().should('eq', linkLogonUser);
    });

    it('Not-pass-confirmation', function() {
        cy.get(user).type('user');
        cy.get(pass).type('pass');
        cy.get(email).type('teste@teste.com');

        cy.get(button).click();

        cy.url().should('eq', linkLogonUser);
    });

    it('Not-email', function() {
        cy.get(user).type('user');
        cy.get(pass).type('pass');
        cy.get(passC).type('pass');

        cy.get(button).click();

        cy.url().should('eq', linkLogonUser);
    });

    it('Nothing', function() {
        cy.get(button).click();

        cy.url().should('eq', linkLogonUser);
    });

    it('Complete-correct-logon', function() {
        cy.get(user).type('user');
        cy.get(pass).type('pass');
        cy.get(passC).type('pass');
        cy.get(email).type('teste@teste.com');

        cy.get(button).click();

        cy.url().should('eq', linkLoginUser);
    });
});