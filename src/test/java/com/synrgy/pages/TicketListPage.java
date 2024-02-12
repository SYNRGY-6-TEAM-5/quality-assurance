package com.synrgy.pages;

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

public class TicketListPage extends BaseTest {
    WebDriverWait wait;
    AndroidDriver driver;

    By ticketListTitle= AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView");
    By ticketCard1 = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup");

    public TicketListPage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void verifyTicketListTitleIsExist(){
        wait.until(ExpectedConditions.presenceOfElementLocated(ticketListTitle));
        WebElement el = driver.findElement(ticketListTitle);
        String actualMessage = el.getText();
        Assert.assertEquals(actualMessage, "Selected Flight");
    }

    public void verifyTicketIsExist(){
        wait.until(ExpectedConditions.presenceOfElementLocated(ticketCard1));
    }
    public void verifyOnTicketListPage(){
        verifyTicketListTitleIsExist();
    }

    public void selectTicket(){
        verifyTicketIsExist();
        driver.findElement(ticketCard1).click();
    }
}
