package com.synrgy.stepdefs;

import com.synrgy.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import com.synrgy.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonStepDef extends BaseTest {
    LoginPage loginPage = new LoginPage(driver);
    OnboardingPage onboardingPage = new OnboardingPage(driver);
    HomePage homePage = new HomePage(driver);
    NavigationBarPage navigationBarPage = new NavigationBarPage(driver);

    RegisterPage registerPage = new RegisterPage(driver);
    ProfilePage profilePage = new ProfilePage(driver);
    TicketListPage ticketListPage = new TicketListPage(driver);

    @Given("user has completed the onboarding steps and left notification enabled by default")
    public void userCompletedOnboardingStepsAndLeftNotificationEnable(){
        onboardingPage.completeOnboardingAndNotification();
    }

    @And("user is on the login page")
    public void userIsOnTheLoginPage(){
        loginPage.verifyOnLoginPage();
    }

    @And("user is on the homepage")
    public void userIsOnTheHomePage(){
        homePage.verifyOnHomePage();
    }

    @And("user navigate to register page")
    public void navigateToSignUpPage(){
        registerPage.navigateSignUpPage();
    }

    @Then("user redirected to the homepage")
    public void redirectToTheHomePage(){
        homePage.verifyOnHomePage();
    }

    @And("user tap Profile on navigation bar")
    public void tapProfileOnNavigationBar(){
        navigationBarPage.tapProfile();
    }

    @And ("user successfully login")
    public void successfullyLogin(){
        loginPage.doLogin("nachtfaust866@gmail.com", "Password123!");
    }

    @And ("user redirected to the profile page")
    public void redirectedToTheProfilePage(){
        profilePage.verifyOnProfilePage();
    }

    @And("user select a Origin {string}")
    public void selectAOrigin(String origin){
        homePage.doSelectOrigin(origin);
    }

    @And("user select a Destination {string}")
    public void selectADestination(String destination){
        homePage.doSelectDestination(destination);
    }

    @And("user select Depart Date {string}")
    public void selectDepartDate(String departDate){
        homePage.doSelectDepartDate(departDate);
    }

    @And("user select passengers and cabin class")
    public void selectPassengersAndCabinClass(){
        homePage.doSelectPassengerAndCabin1();
    }

    @And("user tap Search Flight button")
    public void tapSearchFlightButton(){
        homePage.tapSearchFlight();
    }

    @Then("user view ticket list")
    public void viewTicketList(){
        ticketListPage.verifyOnTicketListPage();
    }

    @And("user search a flight")
    public void searchAFlight(){
        homePage.doSelectOrigin("Malang");
        homePage.doSelectDestination("Jakarta");
        homePage.doSelectDepartDate("15 Feb 2024");
        homePage.doSelectPassengerAndCabin1();
        homePage.tapSearchFlight();
        ticketListPage.verifyOnTicketListPage();
    }

}


