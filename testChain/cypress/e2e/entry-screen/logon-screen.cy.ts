// let linkLogonUser = "http://127.0.0.1:5000/cadastro";
// let linkConfirmationLogon = "";

// describe('Logon', function() {
//     it('Check-logon-components', function() {
//         cy.visit(linkLogonUser);

//         cy.get('#username').should('exist');
//         cy.get('#password').should('exist');
//         cy.get('#passwordConfirmacao').should('exist');
//         cy.get('#email').should('exist');
//         cy.get('#buttonRegistrar').should('exist');
//     });

//     it('Default', function() {
//         cy.visit(linkLogonUser);

//         cy.get('#buttonRegistrar').click();

//         cy.url().should('eq', linkLogonUser);
//     });

//     it('Default-username', function() {
//         cy.visit(linkLogonUser);

//         cy.get('#password').type('pass');
//         cy.get('#passwordConfirmacao').type('pass');
//         cy.get('#email').type('teste@teste.com');

//         cy.get('#buttonRegistrar').click();

//         cy.url().should('eq', linkLogonUser);
//     });

//     it('Default-password', function() {
//         cy.visit(linkLogonUser);

//         cy.get('#username').type('user');
//         cy.get('#email').type('teste@teste.com');

//         cy.get('#buttonRegistrar').click();

//         cy.url().should('eq', linkLogonUser);
//     });

//     it('Default-email', function() {
//         cy.visit(linkLogonUser);

//         cy.get('#username').type('user');
//         cy.get('#password').type('pass');
//         cy.get('#passwordConfirmacao').type('pass');

//         cy.get('#buttonRegistrar').click();

//         cy.url().should('eq', linkLogonUser);
//     });

//     it('Black-space', function() {
//         cy.visit(linkLogonUser);

//         cy.get('#username').type(' ');
//         cy.get('#password').type(' ');
//         cy.get('#passwordConfirmacao').type(' ');
//         cy.get('#email').type(' ');

//         cy.get('#buttonRegistrar').click();

//         cy.url().should('eq', linkLogonUser);
//     });

//     it('Black-space-username', function() {
//         cy.visit(linkLogonUser);

//         cy.get('#username').type(' ');
//         cy.get('#password').type('pass');
//         cy.get('#passwordConfirmacao').type('pass');
//         cy.get('#email').type('teste@teste.com');

//         cy.get('#buttonRegistrar').click();

//         cy.url().should('eq', linkLogonUser);
//     });

//     it('Black-space-password-correct-pass', function() {
//         cy.visit(linkLogonUser);

//         cy.get('#username').type('user');
//         cy.get('#password').type(' ');
//         cy.get('#passwordConfirmacao').type(' ');
//         cy.get('#email').type('teste@teste.com');

//         cy.get('#buttonRegistrar').click();

//         cy.url().should('eq', linkLogonUser);
//     });

//     it('Black-space-password-incorrect-pass-double-space', function() {
//         cy.visit(linkLogonUser);

//         cy.get('#username').type('user');
//         cy.get('#password').type(' ');
//         cy.get('#passwordConfirmacao').type('  ');
//         cy.get('#email').type('teste@teste.com');

//         cy.get('#buttonRegistrar').click();

//         cy.url().should('eq', linkLogonUser);
//     });

//     it('Black-space-password-incorrect-pass', function() {
//         cy.visit(linkLogonUser);

//         cy.get('#username').type('user');
//         cy.get('#password').type(' ');
//         cy.get('#passwordConfirmacao').type('pass');
//         cy.get('#email').type('teste@teste.com');

//         cy.get('#buttonRegistrar').click();

//         cy.url().should('eq', linkLogonUser);
//     });

//     it('Black-space-email', function() {
//         cy.visit(linkLogonUser);

//         cy.get('#username').type('user');
//         cy.get('#password').type('pass');
//         cy.get('#passwordConfirmacao').type('pass');
//         cy.get('#email').type(' ');

//         cy.get('#buttonRegistrar').click();

//         cy.url().should('eq', linkLogonUser);
//     });

//     it('Not-username', function() {
//         cy.visit(linkLogonUser);

//         cy.get('#password').type('pass');
//         cy.get('#passwordConfirmacao').type('pass');
//         cy.get('#email').type('teste@teste.com');

//         cy.get('#buttonRegistrar').click();

//         cy.url().should('eq', linkLogonUser);
//     });

//     it('Not-both-pass', function() {
//         cy.visit(linkLogonUser);

//         cy.get('#username').type('user');
//         cy.get('#email').type('teste@teste.com');

//         cy.get('#buttonRegistrar').click();

//         cy.url().should('eq', linkLogonUser);
//     });

//     it('Not-pass', function() {
//         cy.visit(linkLogonUser);

//         cy.get('#username').type('user');
//         cy.get('#passwordConfirmacao').type('pass');
//         cy.get('#email').type('teste@teste.com');

//         cy.get('#buttonRegistrar').click();

//         cy.url().should('eq', linkLogonUser);
//     });

//     it('Not-pass-confirmation', function() {
//         cy.visit(linkLogonUser);

//         cy.get('#username').type('user');
//         cy.get('#password').type('pass');
//         cy.get('#email').type('teste@teste.com');

//         cy.get('#buttonRegistrar').click();

//         cy.url().should('eq', linkLogonUser);
//     });

//     it('Not-email', function() {
//         cy.visit(linkLogonUser);

//         cy.get('#username').type('user');
//         cy.get('#password').type('pass');
//         cy.get('#passwordConfirmacao').type('pass');

//         cy.get('#buttonRegistrar').click();

//         cy.url().should('eq', linkLogonUser);
//     });

//     it('Nothing', function() {
//         cy.visit(linkLogonUser);

//         cy.get('#buttonRegistrar').click();

//         cy.url().should('eq', linkLogonUser);
//     });

//     it('Complete-correct-logon', function() {
//         cy.visit(linkLogonUser);

//         cy.get('#username').type('user');
//         cy.get('#password').type('pass');
//         cy.get('#passwordConfirmacao').type('pass');
//         cy.get('#email').type('teste@teste.com');

//         cy.get('#buttonRegistrar').click();

//         cy.url().should('eq', linkConfirmationLogon);
//     });
// });