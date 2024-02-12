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

public class LoginPage extends BaseTest {
    WebDriverWait wait;
    AndroidDriver driver;

    By greetingMessage = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[1]");
    By emailOrPhoneNumberTextBox = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText");
    By passwordTextBox = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText");
    By signinButton = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.Button");
    By emptyEmailAlertMessage = AppiumBy.xpath(" /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TextView");
    By emptyPasswordAlertMessage = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TextView");
    By alertToastMessage = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout");
    By loginAsGuestLink = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[3]");
    public LoginPage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        PageFactory.initElements(driver, this);
    }

    public void verifyOnLoginPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(greetingMessage));
    }

    public void inputEmail(String email){
        wait.until(ExpectedConditions.presenceOfElementLocated(emailOrPhoneNumberTextBox));
        driver.findElement(emailOrPhoneNumberTextBox).sendKeys(email);
    }


    public void inputPassword(String password){
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordTextBox));
        driver.findElement(passwordTextBox).sendKeys(password);
    }

    public void tapSignin(){
        wait.until(ExpectedConditions.presenceOfElementLocated(signinButton));
        driver.findElement(signinButton).click();
    }

    public void verifyAlertMessageInEmailFieldIsDisplay(String expectedMessage){
        wait.until(ExpectedConditions.presenceOfElementLocated(emptyEmailAlertMessage));
        WebElement el = driver.findElement(emptyEmailAlertMessage);
        String actualMessage = el.getText();

        String[] alertMessages = expectedMessage.split("\\n");
        assertTrue(actualMessage.contains(alertMessages[0]));
        assertTrue(actualMessage.contains(alertMessages[1]));
    }

    public void verifyAlertMessageInPasswordFieldIsDisplay(String expectedMessage){
        wait.until(ExpectedConditions.presenceOfElementLocated(emptyPasswordAlertMessage));
        WebElement el = driver.findElement(emptyPasswordAlertMessage);
        String actualMessage = el.getText();

        String[] alertMessages = expectedMessage.split("\\n");
        assertTrue(actualMessage.contains(alertMessages[0]));
        assertTrue(actualMessage.contains(alertMessages[1]));
    }

    public void doLogin(String email, String password){
        verifyOnLoginPage();
        inputEmail(email);
        inputPassword(password);
        tapSignin();
    }

    public void tapLoginAsGuest(){
        wait.until(ExpectedConditions.presenceOfElementLocated(loginAsGuestLink));
        driver.findElement(loginAsGuestLink).click();
    }
//
//    public void verifyAlertIsDisplay(String expectedMessage) {
//        try {
//            wait.until(ExpectedConditions.presenceOfElementLocated(alertToastMessage));
//            Thread.sleep(10000);
//            WebElement el = driver.findElement(alertToastMessage);
//            String actualMessage = el.getText();
//            Assert.assertEquals(actualMessage, expectedMessage);
//            System.out.println(actualMessage);
//        } catch (Exception e) {
//            System.out.println("Alert message not displayed within the specified time");
//            e.printStackTrace();
//        }
//    }
//



//    public void verifyErrorAlertExist(String expectedMessage){
//        wait.until(ExpectedConditions.presenceOfElementLocated(errorMessage));
//        WebElement el = driver.findElement(errorMessage);
//        String actualMessage = el.getText();
//        Assert.assertEquals(actualMessage, expectedMessage);
//    }


}
