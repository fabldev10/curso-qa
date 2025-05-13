package com.egg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertWiki {
    
    SoftAssert soft = new SoftAssert();
    WebDriver driver;

     @BeforeTest
    void beforeTest() {
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();         
    }

    @AfterTest
    void afeterTest(){
        driver.quit();
    }



@Test
public void testWiki() throws InterruptedException{

    driver.get("https://www.youtube.com/");
    driver.manage().window().maximize();
    
    WebDriverWait wait = new WebDriverWait(driver, 10); 
    WebElement elementoBarra = wait.until(ExpectedConditions.visibilityOfElementLocated(
        (By.cssSelector("input#search"))));

    //WebElement elementoBarra = driver.findElement(By.id("search"));
    elementoBarra.sendKeys("black sabbath paranoid");
    driver.findElement(By.id("search-icon-legacy")).click();

    Thread.sleep(3000);

    WebElement shorts =wait.until(ExpectedConditions.elementToBeClickable(
        (By.cssSelector("#text[title=Shorts]"))));

    String textoShorts = shorts.getText();  

     soft.assertEquals(textoShorts, "Shorts");
     
     soft.assertEquals( "Cortos",textoShorts);
    shorts.click();

    
     soft.assertAll();
   
   
   






}
    
}
