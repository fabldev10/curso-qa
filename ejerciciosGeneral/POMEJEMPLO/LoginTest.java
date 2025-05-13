package com.egg.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


import com.egg.pages.LoginPage;

public class LoginTest {
    private BaseTest baseTest;
    private LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        baseTest = new BaseTest();
        loginPage = new LoginPage(baseTest.driver);
        baseTest.abrirURL("https://example.com/login");
    }

    @Test
    public void pruebaInicioSesionExitoso() {
        loginPage.iniciarSesion("usuario@example.com", "contraseñaSegura");
        
    String nombreSesion = loginPage.textoInicioSesion().getText();
    
     Assertions.assertEquals(nombreSesion ,"Carlitos");
       
    }


    @AfterEach
    public void tearDown() {
        baseTest.cerrarNavegador();
    }
}