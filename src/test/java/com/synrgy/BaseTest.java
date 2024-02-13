package com.synrgy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BaseTest {
    public static AndroidDriver driver;
    protected static WebDriverWait wait;

    public static void setupDriver(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "10.0");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.synrgy.aeroswift");
        capabilities.setCapability("appActivity", "com.synrgy.aeroswift.presentation.SplashActivity");
        //capabilities.setCapability("noReset", "true");

        driver = new AndroidDriver(capabilities);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public static void stopDriver() {
        driver.quit();
    }

    public static void resetApp() {
        driver.terminateApp("com.synrgy.aeroswift");
        driver.activateApp("com.synrgy.aeroswift");
    }

}
