package com.synrgy.stepdefs;

import com.synrgy.BaseTest;
import com.synrgy.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TicketListStepDef extends BaseTest{
    TicketListPage ticketListPage = new TicketListPage(driver);
    HomePage homePage = new HomePage(driver);

    @And ("user tap next day tab")
    public void tapNextDayTab(){
        ticketListPage.tapNextDay();
    }

    @Then ("user directed to next day's ticket list")
    public void directedToNextDayTicketList(){
        ticketListPage.verifyOnNextDayList();
    }

    @And ("user see ticket list for next day's flight")
    public void seeTicketListForNextDaysFlight(){
        ticketListPage.verifyTicketIsExist();
    }

    @And ("user tap previous day tab")
    public void tapPreviousDayTab(){
        ticketListPage.tapPerviousDay();
    }

    @Then ("user directed to previous day's ticket list")
    public void directedToPreviousDayTicketList(){
        ticketListPage.verifyOnPreviousDayList();
    }

    @And ("user see ticket list for previous day's flight")
    public void seeTicketListForPreviousDaysFlight(){
        ticketListPage.verifyTicketIsExist();
    }

    @And ("user scroll down to view the ticket list")
    public void scrollDownToViewTicketList(){
        ticketListPage.scrollDownTicketList();
    }

    @And ("user tap on the pencil icon")
    public void tapOnThePencilIcon(){
        ticketListPage.tapPencilIcon();
    }

    @Then ("user redirected to the search flight feature on the homepage")
    public void redirectedToTheSearchFlightFeatureOnTheHomepage(){
        homePage.verifyOnHomePage();
    }

    @And ("user successfully edit search flight fields and perform a search again")
    public void userSuccessfullyEditSearchFlightFieldAndPerformASearchAgain(){
        homePage.tapSwap();
        homePage.doSelectDepartureDate();
        homePage.tapSearchFlight();
        ticketListPage.verifyOnTicketListPage();
    }



}
