package com.synrgy.pages;

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

public class OnboardingPage extends BaseTest{
    WebDriverWait wait;
    AndroidDriver driver;

    By firstPageOnboardingText = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[2]");
    By nextButton1 = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[3]");
    By nextButton2 = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[3]");
    By nextButton3 = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[3]");
    By toggleDisable = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.view.View");
    By continueButton = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button");

    public OnboardingPage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void validateOnOnboardingPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(firstPageOnboardingText));

    }
    public void tapNextButton1(){
        wait.until(ExpectedConditions.presenceOfElementLocated(nextButton1));
        driver.findElement(nextButton1).click();
    }

    public void tapNextButton2(){
        wait.until(ExpectedConditions.presenceOfElementLocated(nextButton2));
        driver.findElement(nextButton2).click();
    }

    public void tapNextButton3(){
        wait.until(ExpectedConditions.presenceOfElementLocated(nextButton3));
        driver.findElement(nextButton3).click();
    }

    public void toggleOffNotification(){
        wait.until(ExpectedConditions.presenceOfElementLocated(toggleDisable));
        driver.findElement(toggleDisable).click();
    }
    public void tapContinueButton(){
        wait.until(ExpectedConditions.presenceOfElementLocated(continueButton));
        driver.findElement(continueButton).click();
    }

    public void completeOnboardingAndNotification() {
        validateOnOnboardingPage();
        tapNextButton1();
        tapNextButton2();
        tapNextButton3();
        tapContinueButton();
    }
}
