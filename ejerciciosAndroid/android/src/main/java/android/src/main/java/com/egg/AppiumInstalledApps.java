package android.src.main.java.com.egg;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.remote.MobileDriver;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.android.AndroidDriver;

public class AppiumInstalledApps {

    public static void main(String[] args) throws Exception {
        // Inicia un servidor Appium
        Runtime.getRuntime().exec("appium");

        // Crea un objeto MobileDriver
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatformName(MobilePlatform.ANDROID);
        capabilities.setPlatformVersion("12");
        MobileDriver driver = new AndroidDriver<>("http://localhost:4723/wd/hub", capabilities);

        // Obtiene una lista de todas las aplicaciones instaladas
        List<AppInfo> appList = driver.getInstalledApps();

        // Imprime la lista de aplicaciones
        for (AppInfo app : appList) {
            System.out.println(app.packageName + " " + app.activityName + " " + app.label + " " + app.versionCode + " " + app.versionName);
        }

        // Cierra el servidor Appium
        Runtime.getRuntime().exec("pkill -f appium");
    }
}
