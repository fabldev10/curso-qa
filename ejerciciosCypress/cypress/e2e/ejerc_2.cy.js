context('Ejercicio 02',() =>{
  beforeEach(() =>{
    cy.visit('https://qavalidation.com/demo-form/');
    Cypress.on('uncaught:exception', (err, runnable) => {
      // returning false here prevents Cypress from
      // failing the test
      return false
    })
  })

  it('Test #2',() =>{
    cy.get('#g4072-fullname').type("Juan Pepe Garcia");
    cy.get('#g4072-email').type("JuanPepe@gmail.com");
    cy.get('#g4072-phonenumber').type("123")
    cy.assert(cy.get('#g4072-phonenumber').value).is.a('number');
    
    
  })
})
