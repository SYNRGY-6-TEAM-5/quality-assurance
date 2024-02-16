package app.binar.pages;


import app.binar.keyword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class RegisterPage {
    protected WebDriver webDriver;

    public RegisterPage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[1]/div[2]/form/div/button")
    private static WebElement sign_up_btn;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private static WebElement email_tb;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private static WebElement password_tb;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[1]/div[1]/h1")
    private static WebElement create_account_ttl;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/form/div/input[1]")
    private static WebElement vc1_tb;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/form/div/input[2]")
    private static WebElement vc2_tb;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/form/div/input[3]")
    private static WebElement vc3_tb;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/form/div/input[4]")
    private static WebElement vc4_tb;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/form/button")
    private static WebElement next_btn;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/p[1]")
    private static WebElement vc_ttl;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/a")
    private static WebElement skip_lk;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div[1]/div[2]/form/div/div[2]/a")
    private static WebElement forgot_password_lk;

    public static void verifyOnRegisterPage(){
        keyword.validate_element_is_visible_and_enabled(create_account_ttl);
    }

    public void inputEmail(String email) {
        keyword.inputText(email_tb, email);
    }

    public void inputPassword(String password) {
        keyword.inputText(password_tb, password);
    }

    public void tapSignUp() {
        keyword.tapElement(sign_up_btn);
    }

    public void inputVerficationCode(String vc1,String vc2, String vc3, String vc4){
        keyword.inputText(vc1_tb, vc1);
        keyword.inputText(vc2_tb, vc2);
        keyword.inputText(vc3_tb, vc3);
        keyword.inputText(vc4_tb, vc4);
    }

    public void tapNext(){
        keyword.tapElement(next_btn);
    }

    public void tapSkip(){
        keyword.tapElement(skip_lk);
    }

    public static void verifyOnVerificationCodeSection(){
        keyword.validate_element_is_visible_and_enabled(vc_ttl);
    }

    public void tapForgotPassword(){
        keyword.tapElement(forgot_password_lk);
    }



}
