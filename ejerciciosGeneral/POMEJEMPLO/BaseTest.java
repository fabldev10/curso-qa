package com.egg.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    protected WebDriver driver;

    public BaseTest() {
        // Inicializa el controlador WebDriver
         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();    
        
    }

    public void abrirURL(String url) {
        driver.get(url);
    }

    public void cerrarNavegador() {
        driver.quit();
    }
}