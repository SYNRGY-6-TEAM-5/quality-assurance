package com.synrgy.pages;

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

import static org.junit.jupiter.api.Assertions.assertTrue;
public class MyFlightPage extends BaseTest {
    WebDriverWait wait;
    AndroidDriver driver;

    By yourFlightTitle = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]");

    public MyFlightPage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        PageFactory.initElements(driver, this);
    }

    public void verifyOnMyFlightPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(yourFlightTitle));
        WebElement el = driver.findElement(yourFlightTitle);
        String actualMessage = el.getText();
        Assert.assertEquals(actualMessage, "Your Flight");
    }


}
