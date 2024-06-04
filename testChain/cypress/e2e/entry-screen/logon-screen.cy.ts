let linkLogonUser = "http://127.0.0.1:5000/cadastro";

describe('Logon', function() {
    it('Check-logon-components', function() {
        cy.visit(linkLogonUser);

        cy.get('#username').should('exist');
        cy.get('#password').should('exist');
        cy.get('#passwordConfirmacao').should('exist');
        cy.get('#email').should('exist');
        cy.get('#submitLogon').should('exist');
    });

    it('Default', function() {
        cy.visit(linkLogonUser);

        cy.get('#submitLogon').click();

        cy.url().should('eq', linkLogonUser);
    });

    it('Default-username', function() {
        cy.visit(linkLogonUser);

        cy.get('#password').type('pass');
        cy.get('#passwordConfirmacao').type('pass');
        cy.get('#email').type('teste@teste.com');

        cy.get('#submitLogon').click();

        cy.url().should('eq', linkLogonUser);
    });

    it('Default-password', function() {
        cy.visit(linkLogonUser);

        cy.get('#username').type('user');
        cy.get('#email').type('teste@teste.com');

        cy.get('#submitLogon').click();

        cy.url().should('eq', linkLogonUser);
    });

    it('Default-email', function() {
        cy.visit(linkLogonUser);

        cy.get('#username').type('user');
        cy.get('#password').type('pass');
        cy.get('#passwordConfirmacao').type('pass');

        cy.get('#submitLogon').click();

        cy.url().should('eq', linkLogonUser);
    });

    it('Black-space', function() {
        cy.visit(linkLogonUser);

        cy.get('#username').type(' ');
        cy.get('#password').type(' ');
        cy.get('#passwordConfirmacao').type(' ');
        cy.get('#email').type(' ');

        cy.get('#submitLogon').click();

        cy.url().should('eq', linkLogonUser);
    });

    it('Black-space-username', function() {
        cy.visit(linkLogonUser);

        cy.get('#username').type(' ');
        cy.get('#password').type('pass');
        cy.get('#passwordConfirmacao').type('pass');
        cy.get('#email').type('teste@teste.com');

        cy.get('#submitLogon').click();

        cy.url().should('eq', linkLogonUser);
    });

    it('Black-space-username', function() {
        cy.visit(linkLogonUser);

        cy.get('#username').type(' ');
        cy.get('#password').type('pass');
        cy.get('#passwordConfirmacao').type('pass');
        cy.get('#email').type('teste@teste.com');

        cy.get('#submitLogon').click();

        cy.url().should('eq', linkLogonUser);
    });
});