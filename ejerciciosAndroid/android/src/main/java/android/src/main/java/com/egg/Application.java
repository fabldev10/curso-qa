package android.src.main.java.com.egg;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Application {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Nexus 6 API 34");
        cap.setCapability("platformName", "Android");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("noReset", true);

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4724"), cap);
        System.out.println(driver.getDeviceTime());
        driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Phone\"]").click();
        driver.findElementBy("(//android.widget.FrameLayout[@content-desc='1,'])[2]/android.widget.LinearLayout").click();
    }

}
