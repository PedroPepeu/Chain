// describe('Checkup-home-user', function() {
//     it('Check-components', function() {
//         cy.visit(linkHomeUser);

//         cy.get('#addProjectInput').should('exist');
//         cy.get('#addCreationButton').should('exist');
//     });

//     it('Check-create-work', function() {
//         cy.visit(linkHomeUser);

//         cy.get('#addProjectInput').type('Project test 1');
//         cy.get('#addCreationButton').click();

//         // should check something in the database of the user
//     });

//     it('Check-create-work-null', function() {
//         cy.visit(linkHomeUser);

//         cy.get('#addCreationButton').click();

//         // should check something in the database of the user
//     });

//     it('Check-create-work-space', function() {
//         cy.visit(linkHomeUser);

//         cy.get('#addProjectInput').type(' ');
//         cy.get('#addCreationButton').click();

//         // should check something in the database of the user
//     });

//     // continue
// });