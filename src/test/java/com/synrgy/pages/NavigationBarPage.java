package com.synrgy.pages;

import com.synrgy.BaseTest;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class NavigationBarPage extends BaseTest {
    WebDriverWait wait;
    AndroidDriver driver;
    By profileNavigation = AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Profile\"]");
    By myFlightNavigation = AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"My Flight\"]");
    By homeNavigation = AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Home\"]/android.widget.FrameLayout/android.widget.ImageView");
    public NavigationBarPage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void tapProfile(){
        wait.until(ExpectedConditions.presenceOfElementLocated(profileNavigation));
        driver.findElement(profileNavigation).click();
    }

    public void tapMyFlight(){
        wait.until(ExpectedConditions.presenceOfElementLocated(myFlightNavigation));
        driver.findElement(myFlightNavigation).click();
    }

    public void tapHome(){
        wait.until(ExpectedConditions.presenceOfElementLocated(homeNavigation));
        driver.findElement(homeNavigation).click();
    }

}
