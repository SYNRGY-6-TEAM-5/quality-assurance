package com.synrgy.pages;

import com.google.common.collect.ImmutableMap;
import com.synrgy.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PassengerPage extends BaseTest {
    WebDriverWait wait;
    AndroidDriver driver;
    By passengerPageToolbar = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView");
    By passenger1Option = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.cardview.widget.CardView[3]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout");
    By passenger2Option = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.cardview.widget.CardView[3]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
    By newPassengerButton = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button");
    By continueButton = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button");
    By passengerDetailsToolbar = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView");
    By nikTextBox = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText");
    By fullNameTextBox = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText");
    By dobTextBox = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.EditText");
    By documentTypeDropdown = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText");
    By yearPicker = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]");
    By okButton = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]");
    By nextMonthButton = AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Next month\"]");
    By nationalityTextBox = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText");
    By documentNumberTextBox = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.EditText");
    By expiredTextBox = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.FrameLayout/android.widget.EditText");
    By browseFileButton = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.Button");
    By passport1File = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
    By passport2File = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout");
    By saveButton = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button");
    By nextButton = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button");

    public PassengerPage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void verifyPassengerPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(passengerPageToolbar));
        WebElement el = driver.findElement(passengerPageToolbar);
        String actualMessage= el.getText();
        Assert.assertEquals(actualMessage, "Complete Your Booking");
    }

    public void tapPassenger1(){
        wait.until(ExpectedConditions.presenceOfElementLocated(passenger1Option));
        driver.findElement(passenger1Option).click();
    }

    public void tapPassenger2(){
        wait.until(ExpectedConditions.presenceOfElementLocated(passenger2Option));
        driver.findElement(passenger2Option).click();
    }

    public void tapNewPassenger(){
        wait.until(ExpectedConditions.presenceOfElementLocated(newPassengerButton));
        driver.findElement(newPassengerButton).click();
    }

    public void tapContinue(){
        wait.until(ExpectedConditions.presenceOfElementLocated(continueButton));
        driver.findElement(continueButton).click();
    }

    public void verifyOnPassengerDetailsPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(passengerDetailsToolbar));
        WebElement el = driver.findElement(passengerDetailsToolbar);
        String actualMessage= el.getText();
        Assert.assertEquals(actualMessage, "Passenger Details");
    }

    public void inputNik(String nik){
        wait.until(ExpectedConditions.presenceOfElementLocated(nikTextBox));
        driver.findElement(nikTextBox).sendKeys(nik);
    }

    public void inputFullName(String fullName){
        wait.until(ExpectedConditions.presenceOfElementLocated(fullNameTextBox));
        driver.findElement(fullNameTextBox).sendKeys(fullName);
    }

    public void tapDob(){
        wait.until(ExpectedConditions.presenceOfElementLocated(dobTextBox));
        driver.findElement(dobTextBox).click();
    }

    public void selectYear(String year){
        wait.until(ExpectedConditions.presenceOfElementLocated(yearPicker));
        driver.findElement(yearPicker).click();
        try {
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"" + 2017 + "\"))"));
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().text(\"" + 2012 + "\"))"));
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().text(\"" + 2006 + "\"))"));
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().text(\"" + 2000 + "\"))"));
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().text(\"" + year + "\"))"));
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiSelector().text(\"" + year + "\")")).click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tapNextMonth(){
        wait.until(ExpectedConditions.presenceOfElementLocated(nextMonthButton));
        driver.findElement(nextMonthButton).click();
    }
    public void selectMonth(String month) {
        int monthNumber;
        switch (month) {
            case "January":
                monthNumber = 1;
                break;
            case "February":
                monthNumber = 2;
                break;
            case "March":
                monthNumber = 3;
                break;
            case "April":
                monthNumber = 4;
                break;
            case "May":
                monthNumber = 5;
                break;
            case "June":
                monthNumber = 6;
                break;
            case "July":
                monthNumber = 7;
                break;
            case "August":
                monthNumber = 8;
                break;
            case "September":
                monthNumber = 9;
                break;
            case "October":
                monthNumber = 10;
                break;
            case "November":
                monthNumber = 11;
                break;
            case "December":
                monthNumber = 12;
                break;
            default:
                throw new IllegalArgumentException("Invalid month: " + month);
        }

        Calendar cal = Calendar.getInstance();
        int currentMonth = cal.get(Calendar.MONTH) + 1;

        for (int i = 0; i < monthNumber - currentMonth; i++) {
                tapNextMonth();
        }
    }

    public void selectDay(String day){
        try {
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiSelector().descriptionContains(\"" + day + "\")")).click();
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

    public void back(){
        driver.navigate().back();
        wait.until(ExpectedConditions.presenceOfElementLocated(nationalityTextBox));
    }

    public void selectCalendarDate(String calendarDate){
        String[] birth = calendarDate.split(" ");
        String year = birth[2];
        String month = birth[1];
        String day = birth[0];

        selectYear(year);
        selectMonth(month);
        selectDay(day);
        tapOk();
        back();
    }

    public void selectDob(String date){
        wait.until(ExpectedConditions.presenceOfElementLocated(dobTextBox));
        driver.findElement(dobTextBox).sendKeys(date);
    }

    public void scrollDownPassengerDetails(){
        try {
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().text(\"" + "Accepted file types: PDF, PNG, or JPEG" + "\"))"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectDocumentType(String documentType){
        wait.until(ExpectedConditions.presenceOfElementLocated(documentTypeDropdown));
        driver.findElement(documentTypeDropdown).sendKeys(documentType);
    }

    public void inputNationality(String nationality){
        wait.until(ExpectedConditions.presenceOfElementLocated(nationalityTextBox));
        driver.findElement(nationalityTextBox).sendKeys(nationality);
    }

    public void tapExpiredDate(){
        wait.until(ExpectedConditions.presenceOfElementLocated(expiredTextBox));
        driver.findElement(expiredTextBox).click();
    }

    public void inputDocumentNumber(String documentNumber){
        wait.until(ExpectedConditions.presenceOfElementLocated(documentNumberTextBox));
        driver.findElement(documentNumberTextBox).sendKeys(documentNumber);
    }

    public void tapBrowserFile(){
        wait.until(ExpectedConditions.presenceOfElementLocated(browseFileButton));
        driver.findElement(browseFileButton).click();
    }

    public void selectPassport1(){
        wait.until(ExpectedConditions.presenceOfElementLocated(passport1File));
        driver.findElement(passport1File).click();
    }

    public void selectPassport2(){
        wait.until(ExpectedConditions.presenceOfElementLocated(passport2File));
        driver.findElement(passport2File).click();
    }

    public void browseFile1(){
        tapBrowserFile();
        selectPassport1();
    }

    public void browseFile2(){
        tapBrowserFile();
        selectPassport2();
    }

    public void tapSave(){
        wait.until(ExpectedConditions.presenceOfElementLocated(saveButton));
        driver.findElement(saveButton).click();
    }

    public void tapNext(){
        wait.until(ExpectedConditions.presenceOfElementLocated(nextButton));
        driver.findElement(nextButton).click();
    }

    public void selectExpiredDate(String expiredDate){
        wait.until(ExpectedConditions.presenceOfElementLocated(expiredTextBox));
        driver.findElement(expiredTextBox).sendKeys(expiredDate);
    }

    public void doAddNewPassenger(String nik, String fullName, String dob, String documentType, String nationality, String documentNumber, String expiredDate){
        tapNewPassenger();
        tapContinue();
        verifyOnPassengerDetailsPage();
        inputNik(nik);
        inputFullName(fullName);
        selectDob(dob);
        scrollDownPassengerDetails();
        selectDocumentType(documentType);
        inputNationality(nationality);
        inputDocumentNumber(documentNumber);
        selectExpiredDate(expiredDate);
    }


    public void doCompletePassengerDetails(String nik, String fullName, String dob, String documentType, String nationality, String documentNumber, String expiredDate){
        doAddNewPassenger(nik, fullName, dob, documentType, nationality, documentNumber, expiredDate);
    }


}
