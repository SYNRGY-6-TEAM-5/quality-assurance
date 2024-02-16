package app.binar.steps;

import app.binar.driverManager;
import app.binar.keyword;
import app.binar.pages.LandingPage;
import app.binar.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class RegisterStep {

    LandingPage landingPage = new LandingPage(driverManager.getInstance().getDriver());

    RegisterPage registerPage = new RegisterPage(driverManager.getInstance().getDriver());


    @And ("user navigate to register page")
    public void navigateToRegisterPage() {
        landingPage.tapSignUp();
        registerPage.verifyOnRegisterPage();
    }

    @When ("user input valid email {string} and valid password {string}")
    public void inputValidEmailAndValidPassword(String email, String password) {
        registerPage.inputEmail(email);
        registerPage.inputPassword(password);
    }

    @And ("user tap Sign Up button")
    public void tapSignUpButton() {
        registerPage.tapSignUp();
    }

    @And ("user tap Next button")
    public void tapNextButton(){
        registerPage.tapNext();
    }

    @And("user tap Skip")
    public void tapSkip(){
        registerPage.tapSkip();
    }

    @Then("user stay on register page")
    public void stayOnRegisterPage() {
        registerPage.verifyOnRegisterPage();
    }

    @And("user input wrong verification code")
    public void inputWrongVerificationCode(){
        registerPage.inputVerficationCode("4", "3", "2","1");
    }

    @Then("user stay on verification code section")
    public void stayOnVerificationCodeSection(){
        registerPage.verifyOnVerificationCodeSection();
    }


}
