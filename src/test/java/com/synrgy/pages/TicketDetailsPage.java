package com.synrgy.pages;

import com.synrgy.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TicketDetailsPage extends BaseTest {
    WebDriverWait wait;
    AndroidDriver driver;

    By ticketDetailsItem = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup");
    By selectFlightButton = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.Button");
    public TicketDetailsPage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void tapSelectFlight(){
        wait.until(ExpectedConditions.presenceOfElementLocated(selectFlightButton));
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiSelector().text(\"" + "Select Flight" + "\")")).click();
    }

    public void verifyOnTicketDetailsPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(ticketDetailsItem));
    }

    public void scrollTicketDetails(){
        try {
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().text(\"" + "Select Flight" + "\"))"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doSelectFlight(){
        verifyOnTicketDetailsPage();
        scrollTicketDetails();
        tapSelectFlight();
    }
}
