package com.synrgy.stepdefs;

import com.synrgy.BaseTest;
import com.synrgy.pages.HomePage;
import com.synrgy.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef extends BaseTest {

    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    @And("user tap on the Sign in button")
    public void tapSigninButton(){
       loginPage.tapSignin();
    }


    @And("display greeting message {string}")
    public void displayGreetingMessage(String greeting){
        homePage.verifyDisplayGreeting(greeting);
    }

    @When("user input valid email {string} and valid password {string} to login")
    public void inputValidEmailValidPassword(String email, String password){
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
    }

    @When("user input invalid email with typo {string} and valid password {string} to login")
    public void inputInvalidEmailAndValidPassword(String email, String password){
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
    }

    @When("user input unregistered email {string} and password {string} to login")
    public void inputUnregisteredEmailAndPassword(String email, String password){
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
    }

    @When("user input valid registered email {string} and invalid password {string} to login")
    public void inputValidEmailAndInvalidPasswordLogin(String email, String password){
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
    }

    @When("user input invalid email {string} and invalid password {string} to login")
    public void inputInvalidEmailAndInvalidPassword(String email, String password){
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
    }

    @When("user input valid password {string} to login")
    public void inputValidPassword(String password){
        loginPage.inputPassword(password);
    }

    @When("user input valid registered email {string} to login")
    public void inputEmail(String email){
        loginPage.inputEmail(email);
    }

    @Then("user stay on login page")
    public void stayOnLoginPage(){
        loginPage.verifyOnLoginPage();
    }

    @And("display alert message {string} in email field")
    public void displayAlertMessageInEmailField(String emailAlert){
        loginPage.verifyAlertMessageInEmailFieldIsDisplay(emailAlert);
    }

    @And("display alert message {string} in password field")
    public void displayAlertMessageInPasswordField(String passwordAlert){
        loginPage.verifyAlertMessageInPasswordFieldIsDisplay(passwordAlert);
    }

    @And("display alert message {string} in email field and {string} in password field")
    public void displayAlertMessageInEmailAndPasswordField(String emailAlert, String passwordAlert){
        loginPage.verifyAlertMessageInEmailFieldIsDisplay(emailAlert);
        loginPage.verifyAlertMessageInPasswordFieldIsDisplay(passwordAlert);
    }



}
