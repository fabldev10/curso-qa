context('Ejercicio 01',() =>{
  beforeEach(() =>{
    cy.visit('http://uitestingplayground.com/sampleapp');
  })

  it('Test #1',() =>{
    cy.get('.form-control').first().type("Fabian");
    cy.get('.form-control').eq(1).type("pwd");
    cy.contains('Log In').click();
    cy.get('#loginstatus').should('have.text','Welcome, Fabian!')
  })
})



 