package com.synrgy.stepdefs;

import com.synrgy.BaseTest;
import com.synrgy.pages.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class EditProfileStepDef extends BaseTest  {
    EditProfilePage editProfilePage = new EditProfilePage(driver);
    ProfilePage profilePage = new ProfilePage(driver);

    @And("user tap pencil icon")
    public void tapPencilIcon(){
        profilePage.tapPencilIcon();
    }

    @And("user edit full name {string}")
    public void editFullName(String fullName){
        editProfilePage.inputFullName(fullName);
    }

    @And("user edit date of birth {string}")
    public void editDateOfBirth(String dob){
        editProfilePage.selectDob(dob);
    }

    @And("user edit phone number {string}")
    public void editPhoneNumber(String phoneNumber){
        editProfilePage.inputPhoneNumber(phoneNumber);
    }

    @And("user tap Change to edit photo profile")
    public void tapChangeToEditPhotoProfile(){
        editProfilePage.doChangePhotoProfile();
    }

    @Then("user tap Save button")
    public void tapSaveButton(){
        editProfilePage.tapSave();
    }

    @Then ("user tap back button")
    public void tapBackButton(){
        editProfilePage.tapBack();
    }

    @And("display the alert message with text {string}")
    public void displayTheAlertMessageWithText(String alert){
        editProfilePage.verifyEditProfileAlertIsDisplay(alert);
    }

    @Then("user stay on profile page")
    public void stayOnProfilePage(){
        editProfilePage.verifyOnEditProfilePage();
    }


}
