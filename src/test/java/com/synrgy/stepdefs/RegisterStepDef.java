package com.synrgy.stepdefs;

import com.synrgy.BaseTest;
import com.synrgy.pages.HomePage;
import com.synrgy.pages.LoginPage;
import com.synrgy.pages.RegisterPage;
import com.synrgy.pages.TermAndConditionPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterStepDef extends BaseTest{
    RegisterPage registerPage = new RegisterPage(driver);
    TermAndConditionPage termAndConditionPage = new TermAndConditionPage(driver);

    @When("user input valid email {string} and valid password {string} to register")
    public void inputValidEmailValidPasswordRegister(String email, String password){
        registerPage.inputEmail(email);
        registerPage.inputPassword(password);
    }

    @When("user input registered email {string} and password {string} to register")
    public void inputRegisteredEmailAndPassword(String email, String password){
        registerPage.inputEmail(email);
        registerPage.inputPassword(password);
    }

    @When("user input invalid email {string} and valid password {string} to register")
    public void inputInvalidEmailAndValidPassword(String email, String password){
        registerPage.inputEmail(email);
        registerPage.inputPassword(password);
    }

    @When("user input valid email {string} and invalid password {string} to register")
    public void inputValidEmailAndInvalidPassword(String email, String password){
        registerPage.inputEmail(email);
        registerPage.inputPassword(password);
    }

    @When("user input valid password {string}")
    public void inputValidPassword(String password){
        registerPage.inputPassword(password);
    }

    @When("user input valid email {string}")
    public void inputValidEmail(String email){
        registerPage.inputEmail(email);
    }

    @And("user tap on the Sign Up button")
    public void tapSignUpButton(){
        registerPage.tapSignUp();
    }

    @And("user accepting Terms and Conditions")
    public void acceptTermAndCondition(){
        termAndConditionPage.acceptTnC();
    }

    @And("user input verification code")
    public void inputVerificationCode() {
        registerPage.inputVerifCode();
    }

    @And("user tap on the Confirm button")
    public void tapOnConfirmButton() {
        registerPage.tapConfirm1();
    }

    @And("user input {string}, {string}, and {string}")
    public void inputFullNameDoBAndPhoneNumber(String fullName, String dob, String phoneNumber){
        registerPage.inputFullName(fullName);
        registerPage.inputDoB(dob);
        registerPage.inputPhoneNumber(phoneNumber);
    }

    @And("user tap on Confirm button")
    public void tapConfirmButton(){
        registerPage.tapConfirm2();
    }

    @And("user tap Skip option")
    public void tapSkipOption(){
        registerPage.skip();
    }

    @Then("user see a success message")
    public void seeSuccessMessage(){
        registerPage.successMessage();
    }

    @Then("user stay on register page")
    public void stayOnRegisterPage(){
        registerPage.verifyOnSignUpPage();
    }

    @And("display alert message with text {string}")
    public void displayEmailFormatAlert(String emailAlert){
        registerPage.verifyEmailAlertMessageIsDisplay(emailAlert);
    }

    @And("display alert message with the text {string}")
    public void displayNumericAlert(String passwordAlert){
        registerPage.verifyPasswordAlertMessageIsDisplay(passwordAlert);
    }

    @And("display alert message {string} in the email field and {string} in the password field")
    public void displayEmptyEmailAndPasswordAlert(String emailAlert, String passwordAlert){
        registerPage.verifyEmailAlertMessageIsDisplay(emailAlert);
        registerPage.verifyPasswordAlertMessageIsDisplay(passwordAlert);
    }
    @And ("user navigate to sign up page")
    public void navigateToSignUpPage(){
        registerPage.navigateSignUpPage();
    }

}
