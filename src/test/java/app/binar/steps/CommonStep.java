package app.binar.steps;

import app.binar.driverManager;
import app.binar.keyword;
import app.binar.pages.LandingPage;
import app.binar.pages.LoginPage;
import app.binar.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CommonStep {

    LandingPage landingPage = new LandingPage(driverManager.getInstance().getDriver());
    LoginPage loginPage = new LoginPage(driverManager.getInstance().getDriver());
    RegisterPage registerPage = new RegisterPage(driverManager.getInstance().getDriver());

    @Given("user should be open {string} in web browser")
    public void navigateToUrl(String url) {
        keyword.navigateToUrl(url);
    }

    @And ("display profile button")
    public void displayProfileButton(){
        landingPage.verifyProfileIsDisplay();
    }

    @Then("user redirected to landing page")
    public void redirectedToLandingPage(){
        landingPage.verifyOnLandingPage();
    }

    @Then("user stay on login page")
    public void stayOnLoginPage(){
        loginPage.verifyOnLoginPage();
    }

    @And("user successfully login with new password")
    public void successfullyLoginWithNewPassword(){
        loginPage.doLogin("testAeroSwift@gmail.com", "iniPasswordStrong!12");
    }

    @And("user input valid verification code")
    public void inputValidVerificationCode(){
        registerPage.inputVerficationCode("1", "2", "3","4");
    }
}
