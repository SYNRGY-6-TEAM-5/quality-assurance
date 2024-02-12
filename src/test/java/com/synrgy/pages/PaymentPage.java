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

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaymentPage extends BaseTest{
    WebDriverWait wait;
    AndroidDriver driver;

    By mandiriRadioButton = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.widget.LinearLayout/android.widget.RadioButton");
    By ocbcRadioButton = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[2]/android.widget.LinearLayout/android.widget.RadioButton");
    By bcaRadioButton = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[3]/android.widget.LinearLayout/android.widget.RadioButton");
    By payButton = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.cardview.widget.CardView/android.widget.LinearLayout/android.widget.Button");
    By seeOrderListButton = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.cardview.widget.CardView/android.widget.LinearLayout/android.widget.Button");
    By vaNumber = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.cardview.widget.CardView[1]/android.widget.LinearLayout");
    By orderId = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView[2]");
    By copyIcon = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.cardview.widget.CardView[1]/android.widget.LinearLayout/android.widget.ImageView");
    public PaymentPage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void selectMandiri(){
        wait.until(ExpectedConditions.presenceOfElementLocated(mandiriRadioButton));
        driver.findElement(mandiriRadioButton).click();
    }

    public void selectOcbc(){
        wait.until(ExpectedConditions.presenceOfElementLocated(ocbcRadioButton));
        driver.findElement(ocbcRadioButton).click();
    }

    public void selectBca(){
        wait.until(ExpectedConditions.presenceOfElementLocated(bcaRadioButton));
        driver.findElement(bcaRadioButton).click();
    }

    public void tapPay(){
        wait.until(ExpectedConditions.presenceOfElementLocated(payButton));
        driver.findElement(payButton).click();
    }
    public void tapSeeOrderList(){
        wait.until(ExpectedConditions.presenceOfElementLocated(seeOrderListButton));
        driver.findElement(seeOrderListButton).click();
    }

    public void verifyVaNumberIsExist(){
        wait.until(ExpectedConditions.presenceOfElementLocated(vaNumber));
    }

    public void copyVaNumber(){
        wait.until(ExpectedConditions.presenceOfElementLocated(copyIcon));
        driver.findElement(copyIcon).click();
    }


}
