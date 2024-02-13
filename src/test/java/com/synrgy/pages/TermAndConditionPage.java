package com.synrgy.pages;

import com.synrgy.BaseTest;
import com.github.javafaker.App;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import com.synrgy.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class TermAndConditionPage extends BaseTest {
    WebDriverWait wait;
    AndroidDriver driver;
    By scrollDownButton = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageButton");
    By acceptCheckbox = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.CheckBox");
    By acceptButton = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button");
    public TermAndConditionPage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void acceptTnC(){
        wait.until(ExpectedConditions.presenceOfElementLocated(scrollDownButton));
        driver.findElement(scrollDownButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(acceptCheckbox));
        driver.findElement(acceptCheckbox).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(acceptButton));
        driver.findElement(acceptButton).click();
    }
}
