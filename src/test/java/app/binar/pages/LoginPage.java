package app.binar.pages;

import app.binar.keyword;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
public class LoginPage {
    protected WebDriver webDriver;

    public LoginPage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[1]/div[1]/h1")
    private static WebElement welcome_ttl;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private static WebElement email_tb;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private static WebElement password_tb;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[1]/div[2]/form/div/button")
    private static WebElement sign_in_btn;

    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[1]/div[2]/form/div/div[2]/a")
    private static WebElement forgot_password_link;

    public void verifyOnLoginPage(){
        keyword.validate_element_is_visible_and_enabled(welcome_ttl);
    }

    public void inputEmail(String email) {
        keyword.inputText(email_tb, email);
    }

    public void inputPassword(String password) {
        keyword.inputText(password_tb, password);
    }

    public void tapSignIn() {
        keyword.tapElement(sign_in_btn);
    }

    public void tapForgotPassword() {
        keyword.tapElement(forgot_password_link);
    }

    public void doLogin(String email, String password){
        inputEmail(email);
        inputPassword(password);
        tapSignIn();
    }


}
