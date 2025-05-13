package com.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class GetOrientation {
    public static void main(String[] args) {
        // Definir las capacidades de la prueba
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("noReset", true);
         
        try {
            // Inicializar el driver de Appium
            AppiumDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://localhost:4723"), capabilities);

            // Escribe tus pruebas aquí
            ScreenOrientation orientation = driver.getOrientation();

            // Imprimir la orientación actual en la consola
            System.out.println("Orientación actual de la pantalla: " + orientation);
            driver.rotate(ScreenOrientation.LANDSCAPE);
            orientation = driver.getOrientation();
            System.out.println("Orientación actual de la pantalla: " + orientation);
             driver.rotate(ScreenOrientation.PORTRAIT);
            orientation = driver.getOrientation();
            System.out.println("Orientación actual de la pantalla: " + orientation);

            // Cerrar la sesión del drivers
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }



    


    
