package com.synrgy.pages;

import com.beust.ah.A;
import com.github.javafaker.App;
import com.synrgy.BaseTest;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class HomePage extends BaseTest {
    WebDriverWait wait;
    AndroidDriver driver;

    By greetingMessage = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView[1]");
    By originSpinner = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[3]");
    By destinationSpinner= AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[4]");
    By originSearchTextBox = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.SearchView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText");
    By originResult = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup");
    By destinationSearchTextBox = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.SearchView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText");
    By destinationResult = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup");
    By departDateSpinner = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]");
    By departDateOption = AppiumBy.xpath("//android.view.View[@content-desc=\"15 February 2024\"]");
    By okButton = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]");
    By selectedDepartDate = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView[2]");
    By returnDateSpinner = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]");
    By returnDateOption = AppiumBy.xpath("//android.view.View[@content-desc=\"17 February 2024\"]");
    By selectedReturnDate = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.TextView[2]");
    By passengerAndCabin1Spinner = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]");
    By passengerAndCabin2Spinner = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]");
    By economyOption = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.RadioButton[1]");
    By addAdult = AppiumBy.xpath("(//android.widget.ImageButton[@content-desc=\"plus\"])[1]");
    By addChild = AppiumBy.xpath("(//android.widget.ImageButton[@content-desc=\"plus\"])[2]");
    By selectedPassengerAndCabin = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.TextView[2]");
    By saveButton = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.ScrollView/android.view.ViewGroup/android.widget.Button");
    By searchFlightButton = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button");
    By accessAlertMessage = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[2]");
    By fillAlertMessage = AppiumBy.xpath("/hierarchy/android.widget.Toast");
    By roundtripOption = AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\"Roundtrip\"]/android.widget.TextView");
    By departureDateOption = AppiumBy.xpath("//android.view.View[@content-desc=\"17 February 2024\"]");
    By swapButton = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageButton");
    public HomePage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void verifyOnHomePage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(greetingMessage));
    }
    public void verifyDisplayGreeting(String expectedMessage){
        wait.until(ExpectedConditions.presenceOfElementLocated(greetingMessage));
        WebElement el = driver.findElement(greetingMessage);
        String actualMessage= el.getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    public void verifyAccessAlert(String expectedMessage){
        wait.until(ExpectedConditions.presenceOfElementLocated(accessAlertMessage));
        WebElement el = driver.findElement(accessAlertMessage);
        String actualMessage= el.getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    public void tapSwap(){
        wait.until(ExpectedConditions.presenceOfElementLocated(swapButton));
        driver.findElement(swapButton).click();
    }

    public void tapOrigin(){
        wait.until(ExpectedConditions.presenceOfElementLocated(originSpinner));
        driver.findElement(originSpinner).click();
    }

    public void inputOriginName(String origin){
        wait.until(ExpectedConditions.presenceOfElementLocated(originSearchTextBox));
        driver.findElement(originSearchTextBox).click();
        driver.findElement(originSearchTextBox).sendKeys(origin);
    }

    public void selectOriginResult(){
        wait.until(ExpectedConditions.presenceOfElementLocated(originResult));
        driver.findElement(originResult).click();
    }

    public void verifyOriginName(){
        WebElement el = driver.findElement(originSpinner);
        String actualOrigin = el.getText();
        Assert.assertEquals(actualOrigin, "MLG");
    }
    public void doSelectOrigin(String origin){
        tapOrigin();
        inputOriginName(origin);
        selectOriginResult();
        verifyOriginName();
    }

    public void tapDestination(){
        wait.until(ExpectedConditions.presenceOfElementLocated(destinationSpinner));
        driver.findElement(destinationSpinner).click();
    }

    public void inputDestinationName(String destination){
        wait.until(ExpectedConditions.presenceOfElementLocated(destinationSearchTextBox));
        driver.findElement(destinationSearchTextBox).click();
        driver.findElement(destinationSearchTextBox).sendKeys(destination);
    }

    public void selectDestinationResult(){
        wait.until(ExpectedConditions.presenceOfElementLocated(destinationResult));
        driver.findElement(destinationResult).click();
    }

    public void verifyDestinationName(){
        wait.until(ExpectedConditions.presenceOfElementLocated(destinationSpinner));
        WebElement el = driver.findElement(destinationSpinner);
        String actualDestination = el.getText();
        Assert.assertEquals(actualDestination, "CGK");
    }

    public void doSelectDestination(String destination){
        tapDestination();
        inputDestinationName(destination);
        selectDestinationResult();
        verifyDestinationName();
    }

    public void tapDepartDate(){
        wait.until(ExpectedConditions.presenceOfElementLocated(departDateSpinner));
        driver.findElement(departDateSpinner).click();
    }

    public void selectDepartDate(){
        wait.until(ExpectedConditions.presenceOfElementLocated(departDateOption));
        driver.findElement(departDateOption).click();
    }

    public void selectDepartureDate(){
        wait.until(ExpectedConditions.presenceOfElementLocated(departureDateOption));
        driver.findElement(departureDateOption).click();
    }

    public void tapOk(){
        wait.until(ExpectedConditions.presenceOfElementLocated(okButton));
        driver.findElement(okButton).click();
    }

    public void verifyDepartDate(String expectedDate){
        wait.until(ExpectedConditions.presenceOfElementLocated(selectedDepartDate));
        WebElement el = driver.findElement(selectedDepartDate);
        String actualDate = el.getText();
        Assert.assertEquals(actualDate, expectedDate);
    }

    public void doSelectDepartDate(String departDate){
        tapDepartDate();
        selectDepartDate();
        tapOk();
        verifyDepartDate(departDate);
    }

    public void doSelectDepartureDate(){
        tapDepartDate();
        selectDepartureDate();
        tapOk();
    }

    public void tapPassengerAndCabin1(){
        wait.until(ExpectedConditions.presenceOfElementLocated(passengerAndCabin1Spinner));
        driver.findElement(passengerAndCabin1Spinner).click();
    }

    public void selectCabin(){
        wait.until(ExpectedConditions.presenceOfElementLocated(economyOption));
        driver.findElement(economyOption).click();
    }

    public void selectNumberOfPassenger(){
        wait.until(ExpectedConditions.presenceOfElementLocated(addAdult));
        driver.findElement(addAdult).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(addChild));
        driver.findElement(addChild).click();
    }

    public void tapSaveButton(){
        wait.until(ExpectedConditions.presenceOfElementLocated(saveButton));
        driver.findElement(saveButton).click();
    }

    public void verifyPassengerAndCabin(){
        WebElement el = driver.findElement(selectedPassengerAndCabin);
        String actualDate = el.getText();
        Assert.assertEquals(actualDate, "2 Passengers - Economy Class");
    }

    public void doSelectPassengerAndCabin1(){
        tapPassengerAndCabin1();
        selectCabin();
        selectNumberOfPassenger();
        tapSaveButton();
        verifyPassengerAndCabin();
    }

    public void tapSearchFlight(){
        wait.until(ExpectedConditions.presenceOfElementLocated(searchFlightButton));
        driver.findElement(searchFlightButton).click();
    }

    public void verifyAlertMessageIsDisplay(String expectedMessage){
        wait.until(ExpectedConditions.presenceOfElementLocated(fillAlertMessage));
        WebElement el = driver.findElement(fillAlertMessage);
        String actualMessage = el.getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    public void tapRoundtrip(){
        wait.until(ExpectedConditions.presenceOfElementLocated(roundtripOption));
        driver.findElement(roundtripOption).click();
    }

    public void tapReturnDate(){
        wait.until(ExpectedConditions.presenceOfElementLocated(returnDateSpinner));
        driver.findElement(returnDateSpinner).click();
    }

    public void selectReturnDate(){
        wait.until(ExpectedConditions.presenceOfElementLocated(returnDateOption));
        driver.findElement(returnDateOption).click();
    }

    public void verifyReturnDate(String expectedDate){
        wait.until(ExpectedConditions.presenceOfElementLocated(selectedReturnDate));
        WebElement el = driver.findElement(selectedReturnDate);
        String actualDate = el.getText();
        Assert.assertEquals(actualDate, expectedDate);
    }

    public void doSelectReturnDate(String returnDate){
        tapReturnDate();
        selectReturnDate();
        tapOk();
        verifyReturnDate(returnDate);
    }

    public void tapPassengerAndCabin2(){
        wait.until(ExpectedConditions.presenceOfElementLocated(passengerAndCabin2Spinner));
        driver.findElement(passengerAndCabin2Spinner).click();
    }

    public void doSelectPassengerAndCabin2(){
        tapPassengerAndCabin2();
        selectCabin();
        selectNumberOfPassenger();
        tapSaveButton();
    }





}

