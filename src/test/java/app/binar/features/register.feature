@register
Feature: Register

  @register @positive
  Scenario Outline: As a user, I should be able to register with both valid email and password
    Given user should be open "https://staging-aero-swift.netlify.app/" in web browser
    And user navigate to register page
    When user input valid email "<email>" and valid password "<password>"
    And user tap Sign Up button
    And user input valid verification code
    And user tap Next button
    And user tap Skip
    Then user redirected to landing page
    And display profile button
    Examples:
      |           email         |       password       |
      | testAeroSwift@gmail.com | iniStrongPassword!12 |

  @register @negative
  Scenario: As a user, I should not able to register with both blank email and password field
    Given user should be open "https://staging-aero-swift.netlify.app/" in web browser
    And user navigate to register page
    When user tap Sign Up button
    Then user stay on register page

  @register @negative
  Scenario Outline: As a user, I should not able to register without input verification code
    Given user should be open "https://staging-aero-swift.netlify.app/" in web browser
    And user navigate to register page
    When user input valid email "<email>" and valid password "<password>"
    And user tap Sign Up button
    And user tap Next button
    Then user stay on verification code section
    Examples:
      |           email         |       password       |
      | testAeroSwift@gmail.com | iniStrongPassword!12 |

  @register @negative
  Scenario Outline: As a user, I should not able to register with input wrong verification code
    Given user should be open "https://staging-aero-swift.netlify.app/" in web browser
    And user navigate to register page
    When user input valid email "<email>" and valid password "<password>"
    And user tap Sign Up button
    And user input wrong verification code
    And user tap Next button
    Then user stay on verification code section
    Examples:
      |           email         |       password       |
      | testAeroSwift2@gmail.com | iniStrongPassword!12 |