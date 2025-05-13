package com.egg;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;


class AssertTestNG {


    SoftAssert soft = new SoftAssert();
    WebDriver driver;

     @BeforeTest
    void antesPrueba() {
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();         
    }

    @AfterTest
    void afterTest(){
        driver.quit();
    }

    @Test
    void shouldAnswerWithTrue() {

        this.driver.get("https://www.google.com");
       
       soft.assertEquals(1, 1);   
       soft.assertEquals(2, 1);      
       soft.assertEquals(3, 1);
       
       soft.assertAll();



       
    }
    

    
}