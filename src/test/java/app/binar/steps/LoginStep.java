package app.binar.steps;

import app.binar.driverManager;
import app.binar.keyword;
import app.binar.pages.LandingPage;
import app.binar.pages.LoginPage;
import app.binar.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginStep {
    LandingPage landingPage = new LandingPage(driverManager.getInstance().getDriver());

    LoginPage loginPage = new LoginPage(driverManager.getInstance().getDriver());

    @And("user navigate to login page")
    public void navigateToLoginPage(){
        landingPage.tapSignIn();
        loginPage.verifyOnLoginPage();
    }

    @When("user input email {string} and password {string}")
    public void inputEmailAndPassword(String email, String password){
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
    }

    @And("user tap Sign In button")
    public void tapSignInButton(){
        loginPage.tapSignIn();
    }

}
