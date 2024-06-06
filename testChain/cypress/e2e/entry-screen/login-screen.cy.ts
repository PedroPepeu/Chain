let linkLoginUser = "http://localhost:8080/login";
let linkHomeUser = "http://localhost:8080/profile";

// // add in js of the sites to return the error to the test with the codes

// // test suite name
// describe('Login', function() {
//     // test case
//     it('Check-login-components', function() {
//         cy.visit(linkLoginUser);

//         cy.get('#username').should('exist');
//         cy.get('#password').should('exist');
//         cy.get('#submitLogin').should('exist');
//     });

//     it('Default', function() {
//         cy.visit(linkLoginUser);

//         cy.get('#submitLogin').click();

//         cy.url().should('eq', linkLoginUser);
//     });

//     it('Default-username', function() {
//        cy.visit(linkLoginUser);

//        cy.get('#password').type('pass');

//        cy.get('#submitLogin').click();

//        cy.url().should('eq', linkLoginUser);
//     });

//     it('Default-password', function() {
//         cy.visit(linkLoginUser);

//         cy.get('#username').type('user');

//         cy.get('#submitLogin').click();
//         cy.url().should('eq', linkLoginUser);
//     });

//     it('Black-space', function() {
//         cy.visit(linkLoginUser);

//         cy.get('#username').type(' ');
//         cy.get('#password').type(' ');

//         cy.get('#submitLogin').click();
//         cy.url().should('eq', linkLoginUser);
//     });

//     it('Complete-login', function() {
//         cy.visit(linkLoginUser);

//         cy.get('#username').type('user');
//         cy.get('#password').type('pass');

//         cy.get('#submitLogin').click();

//         cy.url().should('eq', linkHomeUser);
//     });
// });