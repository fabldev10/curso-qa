package com.egg;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertAll;

import io.github.bonigarcia.wdm.WebDriverManager;

class AssertJunit{

     static WebDriver driver;

    @BeforeAll
    static void antesPrueba() {
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();      
    }

    @AfterAll
    static void afterAll() {
        driver.quit();
    }

    @Test
    void assertTrue() {

        driver.get("https://www.google.com");
       

            assertAll("Aserciones múltiples",
            () -> Assertions.assertEquals("1","1"),
            () -> Assertions.assertEquals("1","2"),
            () -> Assertions.assertEquals("1","3")
        );

    }

}


