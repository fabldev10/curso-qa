package com.egg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EjerciciosWiki {
    @Test
    public void testFluent1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("wikipedia.org");

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);
        WebElement icono = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.cssSelector(".mw-logo-icon"));
            }

        });
        assertTrue(driver.findElement(null));

    }

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

        } catch (Throwable t) {
            errors.add(t);
        }

        try {

            WebElement logo = driver.findElement(By.cssSelector("img.central-featured-logo"));
            assertTrue(logo.isDisplayed());

        } catch (Throwable t) {
            errors.add(t);
        }

        if (!errors.isEmpty()) {
            errors.forEach(error -> System.err.println(error.getMessage()));
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
    public void testWikipediaTitle() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wikipedia.org"); // buscar elemento title y guardar como variable de texto; //
        String titulo = driver.getTitle();
        assertEquals("Wikipedia", titulo);
        driver.quit();
    }
    



}
