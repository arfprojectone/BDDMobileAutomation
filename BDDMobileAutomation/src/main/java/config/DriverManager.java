package config;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    public static AndroidDriver driver;

    public static void initializeDriver() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); // sdk_gphone64_arm64
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.APP, "/Users/arifkurniawasuratno/IdeaProjects/BDDMobileAutomation/src/app/mda-2.2.0-25.apk");
        caps.setCapability("appWaitActivity", "*"); // Tambahkan jika aplikasi tidak terbuka

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);
    }

    public static AndroidDriver getDriver() {
        if (driver == null) {
            try {
                initializeDriver();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
