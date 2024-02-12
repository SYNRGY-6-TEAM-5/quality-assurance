package com.synrgy.pages;

import com.github.javafaker.App;
import com.synrgy.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfilePage extends BaseTest {
    WebDriverWait wait;
    AndroidDriver driver;

    By pencilIcon = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/androidx.cardview.widget.CardView/android.view.ViewGroup/android.widget.ImageView[2]");
    By flightOrderSection = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout");
    By savePassengerDataSection = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
    By notificationSettingSection = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout");
    By faqSection= AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.LinearLayout");
    By logoutButton = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button");
    By profileTitle = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView");
    public ProfilePage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void tapPencilIcon(){
        wait.until(ExpectedConditions.presenceOfElementLocated(pencilIcon));
        driver.findElement(pencilIcon).click();
    }

    public void tapFlightOrder(){
        wait.until(ExpectedConditions.presenceOfElementLocated(flightOrderSection));
        driver.findElement(flightOrderSection).click();
    }

    public void tapSavePassengerData(){
        wait.until(ExpectedConditions.presenceOfElementLocated(savePassengerDataSection));
        driver.findElement(savePassengerDataSection).click();
    }

    public void tapNotificationSetting(){
        wait.until(ExpectedConditions.presenceOfElementLocated(notificationSettingSection));
        driver.findElement(notificationSettingSection).click();
    }

    public void tapFaq(){
        wait.until(ExpectedConditions.presenceOfElementLocated(faqSection));
        driver.findElement(faqSection).click();
    }

    public void tapLogout(){
        wait.until(ExpectedConditions.presenceOfElementLocated(logoutButton));
        driver.findElement(logoutButton).click();
    }

    public void verifyOnProfilePage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(profileTitle));
        WebElement el = driver.findElement(profileTitle);
        String actualText = el.getText();
        Assert.assertEquals(actualText, "Profile");
    }

}
