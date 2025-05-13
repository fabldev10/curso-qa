package com.example;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CheckInternetConnection {
    public static void main(String[] args) {
        // Definir las capacidades de la prueba
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("appPackage", "com.android.chrome"); 
         capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main"); 

        try {
            // Inicializar el driver de Appium
            AppiumDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://localhost:4723"), capabilities);

            // Consultar si el dispositivo está conectado a Internet
            
            AndroidElement busqueda = driver.findElementById("com.android.chrome:id/search_box_text");
            busqueda.sendKeys("Argentina");
            busqueda.sendKeys("\n");

    //   AndroidElement dinosaurio = driver.findElementById("00000000-0000-00b6-0000-0006000000b2");

    //         if (dinosaurio.isDisplayed()) {
    //             System.out.println("No hay internet");
    //         } else {
    //             System.out.println("Hay internet");
    //         }

            // Cerrar la sesión del driver
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}







