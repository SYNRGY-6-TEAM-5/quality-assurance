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
public class ForgotPasswordPage {
    protected WebDriver webDriver;

    public ForgotPasswordPage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div/div/input")
    private static WebElement email_tb;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/button")
    private static WebElement next1_btn;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/form/button[2]")
    private static WebElement next2_btn;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/form/button")
    private static WebElement next3_btn;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/form/div/input[1]")
    private static WebElement vc1_tb;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/form/div/input[2]")
    private static WebElement vc2_tb;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/form/div/input[3]")
    private static WebElement vc3_tb;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/form/div/input[4]")
    private static WebElement vc4_tb;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private static WebElement new_password_tb;

    @FindBy(xpath = "//*[@id=\"rePassword\"]")
    private static WebElement re_password_tb;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/form/button")
    private static WebElement change_btn;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/p[1]")
    private static WebElement success_tx;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/button")
    private static WebElement continue_btn;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/ol/li")
    private static WebElement alert_tx;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/p[1]")
    private static WebElement password_recovery_ttl;



    public void inputEmail(String email) {
        keyword.inputText(email_tb, email);
    }

    public void tapNext1() {
        keyword.tapElement(next1_btn);
    }

    public void tapNext2() {
        keyword.tapElement(next2_btn);
    }

    public void tapNext3() {
        keyword.tapElement(next3_btn);
    }

    public void inputVerificationCode(String vc1, String vc2, String vc3, String vc4) {
        keyword.inputText(vc1_tb, vc1);
        keyword.inputText(vc2_tb, vc2);
        keyword.inputText(vc3_tb, vc3);
        keyword.inputText(vc4_tb, vc4);
    }

    public void inputNewPassword(String newPassword) {
        keyword.inputText(new_password_tb, newPassword);
    }

    public void inputRePassword(String rePassword) {
        keyword.inputText(re_password_tb, rePassword);
    }

    public void tapChangePassword() {
        keyword.tapElement(change_btn);
    }

    public static void verifySuccessMessageIsExist(){
        keyword.validate_element_is_visible_and_enabled(success_tx);
    }

    public void tapContinue() {
        keyword.tapElement(continue_btn);
    }

    public static void verifyAlertMessageExist(String expectedMessage){
        String actual = alert_tx.getText();
        Assert.assertEquals(actual,expectedMessage);
    }

    public static void verifyOnPasswordRecoverySection(){
        keyword.validate_element_is_visible_and_enabled(password_recovery_ttl);
    }
}
