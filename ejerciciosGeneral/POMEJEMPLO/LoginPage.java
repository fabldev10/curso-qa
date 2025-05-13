package com.egg.pages;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    private WebDriver driver;

    // @FindBy(id="username")
    // private WebElement username;

     @FindBy(id="password")
    private WebElement password;

     @FindBy(id="password")
    private WebElement loginButton;

     @FindBy(id="nombreSesion")
    private WebElement sesionAbierta;

    public LoginPage(WebDriver driver2){
    }

    public WebElement elementoUsuario(){
        return driver.findElement(By.id("username"));
    }

    public void iniciarSesion(String usuario, String contraseña) {
        elementoUsuario().sendKeys(usuario);
        password.sendKeys(contraseña);
        loginButton.click();
    }   

    public WebElement textoInicioSesion(){
      return sesionAbierta;
       
    }




    // public LoginPage(WebDriver driver) {
    //     this.driver = driver;
    // }

    // public WebElement obtenerCampoUsuario() {
    //     return driver.findElement(By.id("username"));
    // }

    // public WebElement obtenerCampoContraseña() {
    //     return driver.findElement(By.id("password"));
    // }

    // public WebElement obtenerBotonIniciarSesion() {
    //     return driver.findElement(By.id("loginButton"));
    // }

   
}
