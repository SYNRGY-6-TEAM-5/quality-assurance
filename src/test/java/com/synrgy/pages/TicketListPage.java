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
    By ticketCard3 = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[3]/android.view.ViewGroup");
    By nextDayTab = AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\"16 February\n" +
            "IDR 1,067,700\"]/android.widget.TextView");
    By previousDayTab = AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\"14 February\n" +
            "IDR 1,067,700\"]/android.widget.TextView");
    By previousSearchDateText = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.TextView[1]");
    By nextSearchDateText = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.TextView[1]");
    By latestTicket = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[2]/android.view.ViewGroup");
    By pencilIcon = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView[2]");
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

    public void tapNextDay(){
        wait.until(ExpectedConditions.presenceOfElementLocated(nextDayTab));
        driver.findElement(nextDayTab).click();
    }

    public void tapPerviousDay(){
        wait.until(ExpectedConditions.presenceOfElementLocated(previousDayTab));
        driver.findElement(previousDayTab).click();
    }

    public void scrollDownTicketList(){
        try {
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().text(\"" + "IDR 2,290,200" + "\"))"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectLatestTicket(){
        wait.until(ExpectedConditions.presenceOfElementLocated(latestTicket));
        driver.findElement(latestTicket).click();
    }

    public void verifyOnNextDayList(){
        wait.until(ExpectedConditions.presenceOfElementLocated(nextSearchDateText));
        WebElement el1 = driver.findElement(nextSearchDateText);
        String actualMessage = el1.getText();
        Assert.assertEquals(actualMessage, "Fri, 16 Feb 2024");
    }

    public void verifyOnPreviousDayList(){
        wait.until(ExpectedConditions.presenceOfElementLocated(previousSearchDateText));
    }

    public void tapPencilIcon(){
        wait.until(ExpectedConditions.presenceOfElementLocated(pencilIcon));
        driver.findElement(pencilIcon).click();
    }

}
