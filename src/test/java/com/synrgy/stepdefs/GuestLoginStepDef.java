package com.synrgy.stepdefs;

import com.synrgy.BaseTest;
import com.synrgy.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class GuestLoginStepDef extends BaseTest {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    NavigationBarPage navigationBarPage = new NavigationBarPage(driver);
    TicketListPage ticketListPage = new TicketListPage(driver);

    @When("user tap Login as a guest link")
    public void tapLoginAsAGuestLink(){
        loginPage.tapLoginAsGuest();
    }

    @And("user tap My Flight on navigation bar")
    public void tapMyFlightOnNavigationBar(){
        navigationBarPage.tapMyFlight();
    }

    @Then("display an alert message {string}")
    public void displayAnAlertMessage(String message){
        homePage.verifyAccessAlert(message);
    }

    @And("user select a ticket")
    public void selectATicket(){
        ticketListPage.selectTicket();
    }



}
