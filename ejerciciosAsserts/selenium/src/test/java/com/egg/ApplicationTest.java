package com.egg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

class ApplicationTest {
    @Test
    public void testEjercicio1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        /*driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://google.com");
        WebElement input = driver.findElement(By.id("APjFqb"));
        input.sendKeys("polleria");
        input.submit();

        driver.findElement(By.cssSelector("a[jsname=qOiK6e]")).click();
        */
        driver.get("https://www.bbc.com/news/technology");
        WebDriverWait exwait = new WebDriverWait(driver, 20);
        exwait.until(ExpectedConditions.titleContains("Technology"));

        
        WebElement img = exwait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("a.gs-c-promo-heading"))));
        img.click();
        driver.close();
        

        
        
            


    }




    @Test
    public void ejercicioUnsplash (){
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://unsplash.com/es");
    WebElement busqueda = driver.findElement(By.cssSelector("input[data-test=nav-bar-search-form-input]"));
    busqueda.sendKeys("destacados");
    busqueda.submit();
    
    //driver.get("https://unsplash.com/es/s/fotos/destacados");
    
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofSeconds(2))
            .ignoring(NoSuchElementException.class)
            .withMessage("Elemento no encontrado en el tiempo determinado.");

        WebElement logo = wait.until(new Function<WebDriver,WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.cssSelector("img[alt='campo durante la puesta de sol']"));
            }
        });
        logo.click();
       // driver.close();

        
    
}
    @Test
    public void testFluent1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("wikipedia.org");

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);
        WebElement icono = wait.until(new Function<WebDriver,WebElement>() {
            public WebElement apply(WebDriver driver){
                return driver.findElement(By.cssSelector(".mw-logo-icon"));
            }
            
        });
        assertTrue(driver.findElement(null));


    }

    @Test
    public void ejercicioWait() throws InterruptedException{
        
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofSeconds(2))
            .ignoring(NoSuchElementException.class)
            .withMessage("Elemento no encontrado en el tiempo determinado.");

        WebElement logo = wait.until(new Function<WebDriver,WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.className("mw-logo-icon"));
            }
        });

        logo.click();
    }

    @Test
    void driverChromemanager8() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.wikipedia.com");
        WebDriverWait ewait = new WebDriverWait(driver, 10);
        ewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("js-link-box-es"))));
        driver.findElement(By.cssSelector("a[title=\"Espa\u00F1ol \u2014 Wikipedia \u2014 La enciclopedia libre\"]")).click();
        ewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Portales"))));
        driver.findElement(By.linkText("Portales")).click();
   
        ewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Categoría"))));
        driver.findElement(By.linkText("Categorias")).click();
   
}


    
    @Test 
    public void testWaitExplicit(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        /*driver.get("https://google.com");
        WebDriverWait ewait = new WebDriverWait(driver, 10);
        ewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("APjFqb"))));
        
        driver.get("https://github.com/");
        WebDriverWait ewait = new WebDriverWait(driver, 10);
        ewait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("a[href='/login']"))));
        */

        driver.get("https://www.wikipedia.com");
       //WebDriverWait ewait = new WebDriverWait(driver, 20);
       driver.findElement(By.cssSelector("a")).click();
       driver.findElement(By.cssSelector("a[title='Wikipedia:Portal']")).click();
       driver.findElement(By.linkText("Categoría")).click();
      // ewait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.cssSelector("div#main-port"))));
        
        
        //driver.close();

    }
    
    
    @Test
    public void testExplicitWait(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait ewait new WebDriverWait(driver, 10);
        ewait.until(ExpectedConditions.titleContains("Hola Mundo"));
        
    } 

    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://lxp.egg.live/content/step/4dPCQ12cCTN3ZwDGimzQeQ");
        
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0, 250000000);");
    
    }
    
    @Test
    public void testWebElementsWait(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        /*driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.get("https://medium.com/");
        
        List<WebElement> lista = driver.findElements(By.cssSelector("a.bd"));

        for (WebElement btn : lista) {
            if (btn.getText().contains("See more topics")) {

                btn.click();
            }
        }
        */
        driver.manage().timeouts().implicitlyWait(16,TimeUnit.SECONDS);
        driver.get("https://www.youtube.com/watch?v=mwtevlugg2g");
        String numComentarios = driver.findElement(By.cssSelector("h2#count.style-scope.ytd-comments-header-renderer")).getText();
        System.out.println(numComentarios);


    }


    @Test
    public void testWebElementsWaits(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        driver.get("https://twitter.com");
        driver.findElement(By.cssSelector("a[data-testid=signupButton]")).click();

        driver.get("https://medium.com");
        WebDriverWait wait = new WebDriverWait(driver, 60);
        List<WebElement> listaWE = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("a.bd")));

        for (WebElement btn : listaWE) {
            if (btn.getText().contains("See more topic")) {

                btn.click();
            }
        }



        //driver.close();

    }
    @Test
    public void testSelector() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        /* driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("textarea#APjFqb")).sendKeys("Hola mundo");
        driver.get("https://github.com/");
        driver.findElement(By.cssSelector("button.HeaderMenu-link")).click();
        driver.get("https://twitter.com/");
        
        Thread.sleep(2000);
        
        driver.findElement(By.cssSelector("a[data-testid=loginButton]")).click();

        driver.get("https://www.linkedin.com/");
        driver.findElement(By.cssSelector("a.link[data-tracking-control-name=homepage-basic_forgot_password]")).click();
        driver.get("https://medium.com/");
        driver.findElement(By.cssSelector("a.bd[href=https://youngvulgarian.medium.com/limbs-d6aede53fa83]")).click();
        
        List<WebElement> listaEnlaces = driver.findElements(By.cssSelector("a.bd.be.bf.bg.bh.bi.bj.bk.bl.bm.bn.bo.bp.bq.br"));
      
        for (WebElement enlace : listaEnlaces) {
            if (enlace.getText().contains("Limbs")) {

                enlace.click();
            }
        }

        
        driver.get("https://stackoverflow.com/");
        List<WebElement> listaEnlaces = driver.findElements(By.cssSelector("a.js-gps-track"));
      
        for (WebElement enlace : listaEnlaces) {
            if (enlace.getText().contains("Contact Us")) {

                enlace.click();
            }
        }
        */
        driver.get("https://www.amazon.com/s?k=gaming+headsets&language=es&_encoding=UTF8&content-id=amzn1.sym.8148f1e1-83ed-498f-85be-ff288b197da7&pd_rd_r=c39f26a6-0c2c-4cfb-b995-75e82436078a&pd_rd_w=77KNo&pd_rd_wg=odfn4&pf_rd_p=8148f1e1-83ed-498f-85be-ff288b197da7&pf_rd_r=D35W8DWBYQHT5DDB63EP&ref=pd_gw_unk");
        driver.findElement(By.cssSelector("a.a-link-normal")).click();
        driver.findElement(By.cssSelector("span[]"))
    }






    @Test
    public void testSelectoresCSS(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        /*driver.get("https://www.google.com");
        driver.findElement(By.cssSelector("textarea#APjFqb")).sendKeys("Hola Mundo");
        driver.navigate().to("https://github.com");
        driver.findElement(By.cssSelector("button.HeaderMenu-link")).click();
        driver.navigate().to("https://twitter.com");
        driver.findElement(By.cssSelector("a[data-testid=signupButton]")).click();
        driver.navigate().to("https://www.linkedin.com/");
        driver.findElement(By.cssSelector("a.link[data-id=sign-in-form__forgot-password]")).click();*/
        driver.navigate().to("https://medium.com/");
        driver.findElement(By.cssSelector("a.bd[rel=noopener follow]")).click();
    }

    
    @Test
    public void practicaLocalizadores() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    
            WebDriver driver = new ChromeDriver();
    
            driver.get("https://www.thisisfeliznavidad.com/por-producto/retro-sweaters/?mpage=5");
            Thread.sleep(1500);
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("window.scrollBy(0, 250000000);");
    
            List<WebElement>lista = driver.findElements(By.className("js-item-name"));
            int contador=0;
            for (WebElement  producto  : lista) {
                if(producto.getText().contains("Star Wars")){
                    contador++;
                }
            }
            System.out.println("Contador:"+contador);
    
            //driver.close();
        }
    

    @Test
    public void testWebElementsTag(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wikipedia.org");
        driver.findElement(By.id("searchInput")).sendKeys("Oro");
        driver.findElement(By.tagName("button")).click();
        //driver.findElement(By.tagName("a")).click();

        driver.navigate().to("https://www.wacom.com/es-mx/support/product-support/drivers");
        List<WebElement> listaLink = driver.findElements(By.partialLinkText("Descargar"));
        int i=0;
        for (WebElement webElement : listaLink) {
            i++;
            if(i==2){
                webElement.click();
                break;
            }
        }


    }
    @Test
    void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testWebElementsExercise(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bocajuniors.com.ar/");
        driver.manage().window().maximize();

    }

    @Test
    void driverManagerChrome() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        driver.get("https://www.google.com");

        driver.navigate().to("https://openai.com");

        driver.manage().window().setSize(new Dimension(800, 600));

        driver.manage().window().

        driver.navigate().to("https://www.wikipedia.org");

        
        driver.manage().window().maximize();

        driver.close();

    }

    @Test
    public void testWebElementsClassName(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.thisisfeliznavidad.com/por-producto/retro-sweaters/");
        driver.findElement(By.linkText("Cartoon Network")).click();
        driver.close();
    }
    
    @Test
    public void testWebElements(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://facebook.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("email")).sendKeys("hola@hola.com");

        driver.navigate().to("https://www.wikipedia.org");
        driver.findElement(By.name("search")).sendKeys("Hola Mundo");
        WebElement submitBtn = driver.findElement(By.cssSelector("button[type=\"submit\"]"));
        submitBtn.click();
        driver.findElement(By.linkText("programa")).click();

    }


    @Test
    void driverManagerFirefox() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");
    }

    @Test
    void driverManagerOpera() {
        WebDriverManager.operadriver().setup();
        WebDriver driver = new OperaDriver();
        driver.get("https://www.google.com");
    }
}