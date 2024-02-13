package com.synrgy.stepdefs;

import com.synrgy.BaseTest;
import com.synrgy.pages.HomePage;
import com.synrgy.pages.LoginPage;
import com.synrgy.pages.RegisterPage;
import com.synrgy.pages.TermAndConditionPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchTicketStepDef extends BaseTest{
    HomePage homePage = new HomePage(driver);

    @When("user tap Roundtrip option")
    public void tapRoundtripOption(){
        homePage.tapRoundtrip();
    }

    @Then("display an alert message with message {string}")
    public void displayAnAlertMessageWithMessage(String alert){
        homePage.verifyAlertMessageIsDisplay(alert);
    }

    @And("user select Return Date {string}")
    public void selectReturnDate(String returnDate){
        homePage.doSelectReturnDate(returnDate);
    }

    @And ("user select passenger and cabin class")
    public void selectPassengerAndCabinClass(){
        homePage.doSelectPassengerAndCabin2();
    }
}
