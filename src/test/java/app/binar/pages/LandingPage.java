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

public class LandingPage {
    protected WebDriver webDriver;

    public LandingPage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(xpath = "//*[@id=\"root\"]/header/div/nav/div[1]/ul[2]/button[1]")
    private static WebElement sign_up_btn;

    @FindBy(xpath = "//*[@id=\"root\"]/header/div/nav/div[1]/ul[2]/button[2]")
    private static WebElement sign_in_btn;

    @FindBy(xpath = "/html/body/div/section[1]/main/div[2]/div/div/div/div/div/div/div[2]/form/button")
    private static WebElement cari_btn;

    @FindBy(xpath = "//*[@id=\"root\"]/header/div/nav/div[1]/a/button/div")
    private static WebElement profile_btn;

    public void tapSignUp() {
        keyword.tapElement(sign_up_btn);
    }

    public static void verifyOnLandingPage(){
        keyword.validate_element_is_visible_and_enabled(cari_btn);
    }

    public void tapSignIn() {
        keyword.tapElement(sign_in_btn);
    }

    public static void verifyProfileIsDisplay(){
        keyword.validate_element_is_visible_and_enabled(profile_btn);
    }
}
