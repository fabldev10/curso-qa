package com.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class GetName {
    public static void main(String[] args) {
        // Definir las capacidades de la prueba
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("noReset", true);
         capabilities.setCapability("appPackage", "com.google.android.calculator"); 
         capabilities.setCapability("appActivity", "com.android.calculator2.Calculator"); 
       
        try {
            // Inicializar el driver de Appium
            AppiumDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://localhost:4723"), capabilities);

            // Escribe tus pruebas aquí
            driver.findElementById("com.google.android.calculator:id/digit_2").click();
            driver.findElementById("com.google.android.calculator:id/op_add").click();
            driver.findElementById("com.google.android.calculator:id/digit_3").click();
            driver.findElementById("com.google.android.calculator:id/eq").click();

String resultado = driver.findElementById("com.google.android.calculator:id/result_final").getText();
System.out.println("El resultado es: " + resultado);
            // Cerrar la sesión del drivers
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}