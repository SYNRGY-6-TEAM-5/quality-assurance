package com.synrgy.stepdefs;

import com.synrgy.BaseTest;
import com.synrgy.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class OrderFlightStepDef extends BaseTest{
    TicketDetailsPage ticketDetailsPage = new TicketDetailsPage(driver);
    TicketListPage ticketListPage = new TicketListPage(driver);
    PassengerPage passengerPage = new PassengerPage(driver);
    ExtraProtectionPage extraProtectionPage = new ExtraProtectionPage(driver);
    PaymentPage paymentPage = new PaymentPage(driver);
    MyFlightPage myFlightPage = new MyFlightPage(driver);

    @And("user select a flight")
    public void selectAFlight(){
        ticketListPage.selectTicket();
        ticketDetailsPage.doSelectFlight();
    }

    @And("user complete passenger details")
    public void completePassengerDetails(){
        passengerPage.verifyPassengerPage();
        passengerPage.tapPassenger1();
        passengerPage.doCompletePassengerDetails("1571010907020111", "Toji Fushiguro", "31/12/1975", "Passport", "Japan", "123456789", "28/02/2025");
        passengerPage.browseFile1();
        passengerPage.tapSave();
        passengerPage.tapPassenger2();
        passengerPage.doCompletePassengerDetails("1571010907022334", "Megumi Fushiguro", "22/12/2002", "Passport", "Indonesian", "987654321", "30/03/2026");
        passengerPage.browseFile2();
        passengerPage.tapSave();
        passengerPage.tapNext();
    }

    @And ("user proceed to payment")
    public void proceedToPayment(){
        extraProtectionPage.tapContinueToPayment();
        extraProtectionPage.tapContinue();
    }

    @And ("user make the payment")
    public void makeThePayment(){
        paymentPage.selectMandiri();
        paymentPage.tapPay();
        paymentPage.copyVaNumber();
        paymentPage.tapSeeOrderList();
    }

    @Then ("user directed to My Flight page")
    public void directedToMyFlightPage(){
        myFlightPage.verifyOnMyFlightPage();
    }

}
