context('Ejercicio 02',() =>{
  beforeEach(() =>{
    cy.visit('https://qavalidation.com/demo-form/');
  })

  it('Test #1',() =>{
    cy.get('#g4072-fullname').type("Juan Pepe Garcia");
  })
})
