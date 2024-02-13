package com.synrgy.pages;

import com.google.common.collect.ImmutableMap;
import com.synrgy.BaseTest;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import static io.appium.java_client.CommandExecutionHelper.executeScript;

public class ForgotPasswordPage extends BaseTest {
    WebDriverWait wait;
    AndroidDriver driver;

    By forgotPasswordLink = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[2]");
    By emailTextBox = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
    By nextButton = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button");
    By vcBox1 = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/android.widget.EditText[1]");
    By vcBox2 = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/android.widget.EditText[2]");
    By vcBox3 = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/android.widget.EditText[3]");
    By vcBox4 = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/android.widget.EditText[4]");
    By confirmButton = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button");
    By newPasswordTextBox = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText");
    By confirmPasswordTextBox = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText");
    By changePasswordButton = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button");
    By successMessage = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView");
    By loginButton = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button");
    By emailNotFoundAlertMessage = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TextView");
    By verificationCodeTitle = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[1]");
    By setNewPasswordTitle = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[1]");
    public ForgotPasswordPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void tapForgotPassword() {
        wait.until(ExpectedConditions.presenceOfElementLocated(forgotPasswordLink));
        driver.findElement(forgotPasswordLink).click();
    }

    public void inputEmail(String email){
        wait.until(ExpectedConditions.presenceOfElementLocated(emailTextBox));
        driver.findElement(emailTextBox).sendKeys(email);
    }

    public void tapNext() {
        wait.until(ExpectedConditions.presenceOfElementLocated(nextButton));
        driver.findElement(nextButton).click();
    }

    public void inputVerifCode(String vc1, String vc2, String vc3, String vc4){
        driver.navigate().back();
        wait.until(ExpectedConditions.presenceOfElementLocated(vcBox1));
        driver.findElement(vcBox1).click();
        driver.findElement(vcBox1).sendKeys(vc1);
        wait.until(ExpectedConditions.presenceOfElementLocated(vcBox2));
        driver.findElement(vcBox2).click();
        driver.findElement(vcBox2).sendKeys(vc2);
        wait.until(ExpectedConditions.presenceOfElementLocated(vcBox3));
        driver.findElement(vcBox3).click();
        driver.findElement(vcBox3).sendKeys(vc3);
        wait.until(ExpectedConditions.presenceOfElementLocated(vcBox4));
        driver.findElement(vcBox4).click();
        driver.findElement(vcBox4).sendKeys(vc4);
    }

    public void tapConfirm(){
        wait.until(ExpectedConditions.presenceOfElementLocated(confirmButton));
        driver.findElement(confirmButton).click();
    }

    public void inputNewPassword(String newPassword){
        wait.until(ExpectedConditions.presenceOfElementLocated(newPasswordTextBox));
        driver.findElement(newPasswordTextBox).sendKeys(newPassword);
    }

    public void inputConfirmPassword(String confirmPassword){
        wait.until(ExpectedConditions.presenceOfElementLocated(confirmPasswordTextBox));
        driver.findElement(confirmPasswordTextBox).sendKeys(confirmPassword);
    }

    public void tapChangePassword(){
        wait.until(ExpectedConditions.presenceOfElementLocated(changePasswordButton));
        driver.findElement(changePasswordButton).click();
    }

    public void verifySuccessMessageIsDisplay(String expectedMessage){
        wait.until(ExpectedConditions.presenceOfElementLocated(successMessage));
        WebElement el = driver.findElement(successMessage);
        String actualMessage= el.getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    public void tapLogin(){
        wait.until(ExpectedConditions.presenceOfElementLocated(loginButton));
        driver.findElement(loginButton).click();
    }

    public void verifyAlertMessageIsDisplay(String expectedMessage){
        wait.until(ExpectedConditions.presenceOfElementLocated(emailNotFoundAlertMessage));
        WebElement el = driver.findElement(emailNotFoundAlertMessage);
        String actualMessage= el.getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    public void verifyOnVerificationCodePage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(verificationCodeTitle));
        WebElement el = driver.findElement(verificationCodeTitle);
        String actualMessage= el.getText();
        Assert.assertEquals(actualMessage, "Verification Code");
    }

    public void verifyOnSetNewPasswordPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(setNewPasswordTitle));
        WebElement el = driver.findElement(setNewPasswordTitle);
        String actualMessage= el.getText();
        Assert.assertEquals(actualMessage, "Set new password");
    }



}








