package android.src.main.java.com.egg;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.io.File;
import java.net.URL;

public class CapturaPantalla {
    public static void main(String[] args) {
        // Definir las capacidades de la prueba
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("noReset", true);
     
       
        try {
            AppiumDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://localhost:4723"), capabilities);
            
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String capturaPantalla = ("C:/Users/metro/Documents/Egg/Automation/mobile 3/captura.png");

            screenshot.renameTo(new File(capturaPantalla));
 
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}