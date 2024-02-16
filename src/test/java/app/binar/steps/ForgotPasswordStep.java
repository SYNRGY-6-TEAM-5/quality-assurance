package app.binar.steps;

import app.binar.driverManager;
import app.binar.keyword;
import app.binar.pages.ForgotPasswordPage;
import app.binar.pages.LandingPage;
import app.binar.pages.LoginPage;
import app.binar.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotPasswordStep {
    RegisterPage registerPage = new RegisterPage(driverManager.getInstance().getDriver());
    LoginPage loginPage = new LoginPage(driverManager.getInstance().getDriver());
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driverManager.getInstance().getDriver());

    @When("user tap Forgot Password link")
    public void tapForgotPasswordLink(){
        loginPage.tapForgotPassword();
    }

    @And("user input valid registered email {string}")
    public void inputValidRegisteredEmail(String email){
        forgotPasswordPage.inputEmail(email);
    }

    @And("user tap on the Next button")
    public void tapOnTheNextButton(){
        forgotPasswordPage.tapNext1();
    }

    @And("user tap on Next button")
    public void tapOnNextButton(){
        forgotPasswordPage.tapNext2();
    }

    @And("user input valid new password {string}")
    public void inputValidNewPassword(String newPassword){
        forgotPasswordPage.inputNewPassword(newPassword);
    }

    @And("user input valid confirm password {string}")
    public void inputValidConfirmPassword(String rePassword){
        forgotPasswordPage.inputRePassword(rePassword);
    }

    @And("user tap on Change Password button")
    public void tapOnChangePasswordButton(){
        forgotPasswordPage.tapChangePassword();
    }

    @Then("display success message")
    public void displaySuccessMessage(){
        forgotPasswordPage.verifySuccessMessageIsExist();
    }

    @And("user tap on Continue button")
    public void tapOnContinueButton(){
        forgotPasswordPage.tapContinue();
    }

    @And ("user input invalid email {string}")
    public void inputInvalidEmail(String email){
        forgotPasswordPage.inputEmail(email);
    }

    @Then("user stay on Password Recovery section")
    public void stayOnPasswordRecoverySection(){
        forgotPasswordPage.verifyOnPasswordRecoverySection();
    }

    @And("user tap the Next button")
    public void tapTheNextButton(){
        forgotPasswordPage.tapNext3();
    }
}
