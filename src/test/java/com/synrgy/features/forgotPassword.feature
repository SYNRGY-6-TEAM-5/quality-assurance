@forgotPassword
Feature: Forgot Password

  @forgotPassword @positive
  Scenario Outline: As a user, I should be able to easily and securely reset my password via email
    Given user has completed the onboarding steps and left notification enabled by default
    And user is on the login page
    When user tap Forgot Password link
    And user input valid registered email "<email>"
    And user tap Next button
    And user input valid verification code
    And user tap Confirm button
    And user input a valid new password "<new password>"
    And user input a valid confirm password "<confirm new password>"
    And user tap Change Password button
    Then display success message "<message>"
    And user tap Login button
    And user successfully login with new password
    Examples:
      |           email          |     new password     | confirm new password |                      message                 |
      | testAeroSwift2@gmail.com | iniPasswordStrong!12 | iniPasswordStrong!12 | Your password has been changed successfully! |



  @forgotPassword @negative
  Scenario Outline: As a user, I should not be able to reset my password if confirm new password not same with new password
    Given user has completed the onboarding steps and left notification enabled by default
    And user is on the login page
    When user tap Forgot Password link
    And user input valid registered email "<email>"
    And user tap Next button
    And user input valid verification code
    And user tap Confirm button
    And user input a valid new password "<new password>"
    And user input a invalid confirm password "<confirm password>"
    And user tap Change Password button
    Then user stay on Set New Password page
    Examples:
      |           email          |     new password     |   confirm password   |
      | testAeroSwift2@gmail.com | iniPasswordStrong!12 | iniPasswordStrong!21 |

  @forgotPassword @negative
  Scenario Outline: As a user, I should not be able to reset my password with invalid email
    Given user has completed the onboarding steps and left notification enabled by default
    And user is on the login page
    When user tap Forgot Password link
    And user input invalid email "<email>"
    And user tap Next button
    Then display the alert message "<alert>"
    Examples:
      |           email          |      alert      |
      | testAeroSwift4@gmail.com | Email Not Found |