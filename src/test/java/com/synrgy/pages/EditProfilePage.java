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

public class EditProfilePage extends BaseTest {
    WebDriverWait wait;
    AndroidDriver driver;

    By backButton = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageButton");
    By changeLink = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView");
    By fullNameTextBox = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText");
    By dobTextBox = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText");
    By yearPicker = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]");
    By okButton = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]");
    By phoneNumberTextBox = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.EditText");
    By saveButton = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button");
    By permissionAllowButton = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]");
    By galeryFolder = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[3]");
    By photo = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Photo taken on Feb 8, 2024 9:30:47 PM\"]");
    By alertDescriptionMessage = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]");
    By editProfileTitle = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView");
    public EditProfilePage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void tapBack(){
        wait.until(ExpectedConditions.presenceOfElementLocated(backButton));
        driver.findElement(backButton).click();
    }

    public void tapChange(){
        wait.until(ExpectedConditions.presenceOfElementLocated(changeLink));
        driver.findElement(changeLink).click();
    }

    public void tapAllow(){
        wait.until(ExpectedConditions.presenceOfElementLocated(permissionAllowButton));
        driver.findElement(permissionAllowButton).click();
    }

    public void tapFolder(){
        wait.until(ExpectedConditions.presenceOfElementLocated(galeryFolder));
        driver.findElement(galeryFolder).click();
    }

    public void selectPhoto(){
        wait.until(ExpectedConditions.presenceOfElementLocated(photo));
        driver.findElement(photo).click();
    }

    public void doChangePhotoProfile(){
        tapChange();
        tapAllow();
        tapAllow();
        tapChange();
        tapFolder();
        selectPhoto();
    }

    public void inputFullName(String fullName){
        wait.until(ExpectedConditions.presenceOfElementLocated(fullNameTextBox));
        driver.findElement(fullNameTextBox).sendKeys(fullName);
    }

    public void tapDob(){
        wait.until(ExpectedConditions.presenceOfElementLocated(dobTextBox));
        driver.findElement(dobTextBox).click();
    }

    public void selectYear(String dob){
        wait.until(ExpectedConditions.presenceOfElementLocated(yearPicker));
        driver.findElement(yearPicker).click();

        String dateOfBirth = dob;
        String[] parts = dateOfBirth.split("/");
        String date = parts[0];
        String month = parts[1];
        String year = parts[2];

        try {
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().text(\"" + year + "\"))"));
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiSelector().text(\"" + year + "\")")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectDateAndMonth(){
        try {
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiSelector().descriptionContains(\"" + "28 February 2013" + "\")")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void tapOk(){
        wait.until(ExpectedConditions.presenceOfElementLocated(okButton));
        driver.findElement(okButton).click();
    }

    public void verifyDob(String expectedDob){
        wait.until(ExpectedConditions.presenceOfElementLocated(dobTextBox));
        WebElement el = driver.findElement(dobTextBox);
        String actualDob = el.getText();
        Assert.assertEquals(actualDob, expectedDob);
    }

    public void selectDob(String dob){
        tapDob();
        selectYear(dob);
        selectDateAndMonth();
        tapOk();
        verifyDob(dob);
    }

    public void inputPhoneNumber(String phoneNumber){
        wait.until(ExpectedConditions.presenceOfElementLocated(phoneNumberTextBox));
        driver.findElement(phoneNumberTextBox).sendKeys(phoneNumber);
    }

    public void tapSave(){
        wait.until(ExpectedConditions.presenceOfElementLocated(saveButton));
        driver.findElement(saveButton).click();
    }

    public void verifyEditProfileAlertIsDisplay(String expectedMessage){
        wait.until(ExpectedConditions.presenceOfElementLocated(alertDescriptionMessage));
        WebElement el = driver.findElement(alertDescriptionMessage);
        String actualMessage = el.getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    public void verifyOnEditProfilePage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(editProfileTitle));
        WebElement el = driver.findElement(editProfileTitle);
        String actualMessage = el.getText();
        Assert.assertEquals(actualMessage, "Edit Profile");
    }
}
