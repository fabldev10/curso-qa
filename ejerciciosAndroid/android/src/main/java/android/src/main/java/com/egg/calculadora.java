package android.src.main.java.com.egg;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class calculadora {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "samsung SM-A315G");
        cap.setCapability("platformName", "Android");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("appPackage", "com.android.calculator2");
        cap.setCapability("appActivity", ".Calculator");
         
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723"), cap);

        // Realizar una operación simple, por ejemplo, sumar 5 + 3
        AndroidElement button5 = driver.findElementById("com.android.calculator2:id/digit_5");
        AndroidElement buttonPlus = driver.findElementByAccessibilityId("plus");
        AndroidElement button3 = driver.findElementById("com.android.calculator2:id/digit_3");
        AndroidElement buttonEquals = driver.findElementByAccessibilityId("equals");

        button5.click();
        buttonPlus.click();
        button3.click();
        buttonEquals.click();

        // Obtener el resultado y mostrarlo en la consola
        AndroidElement result = driver.findElementById("com.android.calculator2:id/result");
        String resultado = result.getText();
        System.out.println("Resultado de la suma: " + resultado);

        // Cerrar la aplicación de la calculadora
        driver.quit();
    }
}