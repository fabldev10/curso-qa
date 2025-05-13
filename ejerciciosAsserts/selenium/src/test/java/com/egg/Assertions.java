package com.egg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Assertions {
    @Test
    public void botonGoogleDeshabilitado() throws Throwable { 
WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    driver.get("https://www.wikipedia.org/");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


 driver.manage().window().maximize();

      List<Throwable> errors = new ArrayList<>(); 
        try { 
        String titulo = driver.getTitle();
        assertEquals("Wikipedia", titulo);

        } 
        catch (Throwable t) { 
            errors.add(t); } 

        try { 
        

    WebElement logo = driver.findElement(By.cssSelector("img.central-featured-logo"));
    assertTrue(logo.isDisplayed());

    } catch (Throwable t) { 
        errors.add(t); } 

    if (!errors.isEmpty()) 
    { errors.forEach(error -> System.err.println(error.getMessage())); 
        throw errors.get(0); 
    } 
   
}
    @Test
    public void test5(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://es.wikipedia.org/wiki/The_Walt_Disney_Company");
        //driver.findElement(By.cssSelector("[lagn=en]")).click();;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String a = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[lang=en]"))).getAttribute("");
        System.out.println(a);
    }

    @Test
    public void test4() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://bing.com");
        WebElement entrada1 = driver.findElement(By.id("sb_form_q"));
        assertTrue(entrada1.isEnabled());
        // Ejercicio 4: Verificar la presencia de la barra de búsqueda en Bing y que la
        // sugerencia no aparezca inicialmente

        List<WebElement> lista = driver.findElements(By.cssSelector(".sa_sg"));
        assertTrue(lista.isEmpty());
        driver.close();
    }

    @Test
    public void test3() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wikipedia.org/");
        String titulo = driver.findElement(By.xpath("//*[@id='www-wikipedia-org']/div[1]/h1/span")).getText();
        assertEquals("Wikipedia", titulo);
        WebElement imagen = null;
        try {
            imagen = driver.findElement(By.className("clase"));
        } catch (Exception e) {
            System.out.println("La imagen no esta en la pagina");
        } finally {
            if (imagen != null) {
                assertTrue(imagen.isDisplayed());
            }
        }
        driver.close();
    }

    @Test
    public void test2() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://accounts.spotify.com/es/login?continue=https%3A%2F%2Fopen.spotify.com%2Fintl-es%3F");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[data-testid='login-container']")));

        // Actions action = new Actions(driver);
        // action.moveToElement(checkbox1).click()
        WebElement checkbox1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-remember")));
        System.out.println(checkbox1.getTagName());
        checkbox1.click();
        assertFalse(checkbox1.isSelected());
        //driver.close();

    }

    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        WebElement entrada = driver.findElement(By.id("APjFqb"));
        WebElement boton = driver.findElement(By.className("gNO89b"));
        assertTrue(entrada.getAttribute("value").isEmpty());
        // Metodo .isEnable no funciona correctamente
        assertFalse(boton.isDisplayed());
        driver.close();

    }

    @Test
    public void testXpath() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

    }

    @Test
    public void testAsserTrue1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        /*
         * driver.get("https://faculty.washington.edu/chudler/java/boxes.html");
         * WebElement check = driver.findElement(By.cssSelector("[type=checkbox]"));
         * 
         * //check.click();
         * assertFalse(check.isSelected());
         * check = null;
         * assertNull(check, "El elemento existe");
         */
        driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
        WebElement alt = driver.findElement(By.cssSelector(".mw-logo-icon"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", alt);
        assertFalse(alt.isDisplayed());

    }

    @Test
    public void myTest() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().fullscreen();
        driver.get("https://google.com");
        WebDriverWait ewait = new WebDriverWait(driver, 10);
        WebElement enlace = ewait.until(ExpectedConditions.presenceOfElementLocated(By.id("APjFqb")));
        enlace.sendKeys("Twitter");
        enlace.submit();
        driver.findElement(By.linkText("Twitter")).click();

    }

    @Test
    public void testLinkLoginTwitter() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://twitter.com");
        WebDriverWait ewait = new WebDriverWait(driver, 10);
        String url = ewait
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid=loginButton]")))
                .getAttribute("href");
        System.out.println(url);
        assertEquals("https://twitter.com/login", url);
        driver.close();
    }

    @Test
    public void testGoogleBtn() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
        WebDriverWait ewait = new WebDriverWait(driver, 10);
        String txtBtn = ewait.until(ExpectedConditions.presenceOfElementLocated(By.className("gNO89b")))
                .getAttribute("value");
        System.out.println(txtBtn);
        assertEquals("Buscar con Google", txtBtn);

        driver.close();

    }

    @Test
    public void testWikipediaTitle() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wikipedia.org"); // buscar elemento title y guardar como variable de texto; //
        String titulo = driver.getTitle();
        assertEquals("Wikipedia", titulo);
        driver.quit();
    }

    @Test
    public void testWithSoftAssertions() {
        List<Throwable> errors = new ArrayList<>();
        try {
            assertEquals(5, suma(2, 2)); // Si falla aquí, se añade a errores
        } catch (Throwable t) {
            errors.add(t);
        }
        try {
            assertEquals("Texto esperado", "Texto actual"); // Si falla aquí, se añade a errores
        } catch (Throwable t) {
            errors.add(t);
        }
        // Lanza todas las afirmaciones fallidas al final
        if (!errors.isEmpty()) {
            errors.forEach(error -> System.err.println(error.getMessage()));
            throw errors.get(0); // Lanza la primera excepción para marcar la prueba como fallida
        }
    }

    // Método auxiliar para el ejemplo private
    int suma(int a, int b) {
        return a + b;
    }
}
