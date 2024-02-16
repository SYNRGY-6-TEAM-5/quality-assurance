@forgotPassword
Feature: Forgot Password

  @forgotPassword @positive
  Scenario Outline: As a user, I should be able to easily and securely reset my password via email
    Given user should be open "https://staging-aero-swift.netlify.app/" in web browser
    And user navigate to login page
    When user tap Forgot Password link
    And user input valid registered email "<email>"
    And user tap on the Next button
    And user input valid verification code
    And user tap on Next button
    And user input valid new password "<new password>"
    And user input valid confirm password "<confirm new password>"
    And user tap on Change Password button
    Then display success message
    And user tap on Continue button
    And user successfully login with new password
    Examples:
      |           email          |     new password     | confirm new password |
      | testAeroSwift2@gmail.com | iniPasswordStrong!12 | iniPasswordStrong!12 |

  @forgotPassword @negative
  Scenario Outline: As a user, I should not able to reset my password with wrong verification code
    Given user should be open "https://staging-aero-swift.netlify.app/" in web browser
    And user navigate to login page
    When user tap Forgot Password link
    And user input valid registered email "<email>"
    And user tap on the Next button
    And user input wrong verification code
    And user tap the Next button
    Then user stay on verification code section
    Examples:
      |       email         |
      | meawmee97@gmail.com |
