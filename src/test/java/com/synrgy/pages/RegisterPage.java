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

public class RegisterPage extends BaseTest {
    WebDriverWait wait;
    AndroidDriver driver;

    By signUpBar = AppiumBy.accessibilityId("Sign up");
    By greetingMessage = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[1]");
    By emailTextBox = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText");
    By passwordTextBox = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText");
    By signUpButton = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.Button");
    By verifCodeBox1 = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/android.widget.EditText[1]");
    By verifCodeBox2 = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/android.widget.EditText[2]");
    By verifCodeBox3 = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/android.widget.EditText[3]");
    By verifCodeBox4 = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/android.widget.EditText[4]");
    By confirmCodeButton = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button");
    By fullNameTextBox = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText");
    By dobTextBox = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.EditText");
    By phoneNumberTextBox = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.FrameLayout/android.widget.EditText");
    By confirmProfileButton = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button");
    By successVerifiedMessage = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView");
    By skipOption = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[3]");
    By emailAlertMessage = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TextView");
    By passwordAlertMessage = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TextView");
   // By emailFormatAlertMessage = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TextView");
    // By numericAlertMessage = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TextView");
    public RegisterPage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void navigateSignUpPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(signUpBar));
        driver.findElement(signUpBar).click();
        verifyOnSignUpPage();
    }

    public void verifyOnSignUpPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(greetingMessage));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement el = driver.findElement(greetingMessage);
        String actualMessage= el.getText();
        Assert.assertEquals(actualMessage, "Let’s get started");
    }
    public void inputEmail(String email){
        wait.until(ExpectedConditions.presenceOfElementLocated(emailTextBox));
        driver.findElement(emailTextBox).sendKeys(email);
    }

    public void inputPassword(String password){
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordTextBox));
        driver.findElement(passwordTextBox).sendKeys(password);
    }

    public void tapSignUp(){
        wait.until(ExpectedConditions.presenceOfElementLocated(signUpButton));
        driver.findElement(signUpButton).click();
    }

    public void inputVerifCode(){
        wait.until(ExpectedConditions.presenceOfElementLocated(verifCodeBox1));
        driver.findElement(verifCodeBox1).click();
        driver.findElement(verifCodeBox1).sendKeys("1");
        wait.until(ExpectedConditions.presenceOfElementLocated(verifCodeBox2));
        driver.findElement(verifCodeBox2).click();
        driver.findElement(verifCodeBox2).sendKeys("2");
        wait.until(ExpectedConditions.presenceOfElementLocated(verifCodeBox3));
        driver.findElement(verifCodeBox3).click();
        driver.findElement(verifCodeBox3).sendKeys("3");
        wait.until(ExpectedConditions.presenceOfElementLocated(verifCodeBox4));
        driver.findElement(verifCodeBox4).click();
        driver.findElement(verifCodeBox4).sendKeys("4");
    }

    public void tapConfirm1(){
        wait.until(ExpectedConditions.presenceOfElementLocated(confirmCodeButton));
        driver.findElement(confirmCodeButton).click();
    }

    public void inputFullName(String fullName){
        wait.until(ExpectedConditions.presenceOfElementLocated(fullNameTextBox));
        driver.findElement(fullNameTextBox).sendKeys(fullName);
    }

    public void inputDoB(String dob){
        wait.until(ExpectedConditions.presenceOfElementLocated(dobTextBox));
        driver.findElement(dobTextBox).sendKeys(dob);
    }

    public void inputPhoneNumber(String phoneNumber){
        wait.until(ExpectedConditions.presenceOfElementLocated(phoneNumberTextBox));
        driver.findElement(phoneNumberTextBox).sendKeys(phoneNumber);
    }

    public void tapConfirm2(){
        wait.until(ExpectedConditions.presenceOfElementLocated(confirmProfileButton));
        driver.findElement(confirmProfileButton).click();
    }

    public void successMessage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(successVerifiedMessage));
        WebElement el = driver.findElement(successVerifiedMessage);
        String actualMessage= el.getText();
        Assert.assertEquals(actualMessage, "Your account has been verified succesfully");
    }

    public void skip(){
        wait.until(ExpectedConditions.presenceOfElementLocated(skipOption));
        driver.findElement(skipOption).click();
    }
    public void verifyEmailAlertMessageIsDisplay(String expectedMessage) {
        wait.until(ExpectedConditions.presenceOfElementLocated(emailAlertMessage));
        WebElement el = driver.findElement(emailAlertMessage);
        String actualMessage = el.getText();

        String[] alertMessages = expectedMessage.split("\\n");

        for (String message : alertMessages) {
            assertTrue(actualMessage.contains(message));
        }
    }

    public void verifyPasswordAlertMessageIsDisplay(String expectedMessage) {
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordAlertMessage));
        WebElement el = driver.findElement(passwordAlertMessage);
        String actualMessage = el.getText();

        String[] alertMessages = expectedMessage.split("\\n");

        for (String message : alertMessages) {
            assertTrue(actualMessage.contains(message));
        }
    }

//    public void equalALert(String expectedMessage){
//        wait.until(ExpectedConditions.presenceOfElementLocated(emailAlertMessage));
//        WebElement el = driver.findElement(emailAlertMessage);
//        String actualMessage = el.getText();
//        Assert.assertEquals(actualMessage, expectedMessage);
//    }


}
