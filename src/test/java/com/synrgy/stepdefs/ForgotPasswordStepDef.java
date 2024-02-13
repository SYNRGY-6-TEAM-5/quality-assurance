package com.synrgy.stepdefs;

import com.synrgy.BaseTest;
import com.synrgy.pages.ForgotPasswordPage;
import com.synrgy.pages.HomePage;
import com.synrgy.pages.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotPasswordStepDef extends BaseTest {
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @When("user tap Forgot Password link")
    public void tapForgotPasswordLink(){
        forgotPasswordPage.tapForgotPassword();
    }

    @And("user input valid registered email {string}")
    public void inputValidRegisteredEmail(String email){
        forgotPasswordPage.inputEmail(email);
    }

    @And("user tap Next button")
    public void tapNextButton(){
        forgotPasswordPage.tapNext();
    }

    @And("user input valid verification code")
    public void inputValidVerificationCode(){
        forgotPasswordPage.inputVerifCode("1","2","3","4");
    }

    @And("user tap Confirm button")
    public void tapConfirmButton(){
        forgotPasswordPage.tapConfirm();
    }

    @And("user input a valid new password {string}")
    public void inputValidNewPassword(String newPassword){
        forgotPasswordPage.inputNewPassword(newPassword);
    }

    @And("user input a valid confirm password {string}")
    public void inputConfirmPassword(String confirmPassword){
        forgotPasswordPage.inputConfirmPassword(confirmPassword);
    }

    @And("user tap Change Password button")
    public void tapChangePasswordButton(){
        forgotPasswordPage.tapChangePassword();
    }

    @Then("display success message {string}")
    public void displaySuccessMessage(String message){
        forgotPasswordPage.verifySuccessMessageIsDisplay(message);
    }

    @And ("user tap Login button")
    public void tapLoginButton(){
        forgotPasswordPage.tapLogin();
    }

    @And("user successfully login with new password")
    public void successfullyLoginWithNewPassword(){
        loginPage.doLogin("testAeroSwift2@gmail.com", "iniPasswordStrong!12");
        homePage.verifyOnHomePage();
    }

    @And("user input invalid email {string}")
    public void inputInvalidEmail(String email){
        forgotPasswordPage.inputEmail(email);
    }

    @Then("display the alert message {string}")
    public void displayTheAlertMessage(String message){
        forgotPasswordPage.verifyAlertMessageIsDisplay(message);
    }

    @And("user input invalid verification code")
    public void inputInvalidVerificationCode() {
        forgotPasswordPage.inputVerifCode("1","2","3","5");
    }

    @Then("user stay on Verification Code page")
    public void stayOnVerificationCodePage(){
        forgotPasswordPage.verifyOnVerificationCodePage();
    }


    @And("user input a invalid confirm password {string}")
    public void inputInvalidConfirmPassword(String confirmPassword){
        forgotPasswordPage.inputConfirmPassword(confirmPassword);
    }

    @Then("user stay on Set New Password page")
    public void stayOnSetNewPasswordPage(){
        forgotPasswordPage.verifyOnSetNewPasswordPage();
    }


}
