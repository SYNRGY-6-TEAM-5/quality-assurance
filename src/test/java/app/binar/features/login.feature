@login
Feature: Login

  @login @positive
  Scenario Outline: As a user, I should be able to sign in with both valid email and password
    Given user should be open "https://staging-aero-swift.netlify.app/" in web browser
    And user navigate to login page
    When user input email "<email>" and password "<password>"
    And user tap Sign In button
    Then user redirected to landing page
    And display profile button
    Examples:
      |           email         |   password  |
      | nachtfaust866@gmail.com| Password123! |

  @login @negative
  Scenario Outline: As a user, I should not be able to sign in with wrong email and valid password
    Given user should be open "https://staging-aero-swift.netlify.app/" in web browser
    And user navigate to login page
    When user input email "<email>" and password "<password>"
    And user tap Sign In button
    Then user stay on login page
    Examples:
      |           email         |   password   |
      | nachtfaust866@gmail.cmo | Password123! |

  @login @negative
  Scenario Outline: As a user, I should not be able to sign in with valid email and wrong password
    Given user should be open "https://staging-aero-swift.netlify.app/" in web browser
    And user navigate to login page
    When user input email "<email>" and password "<password>"
    And user tap Sign In button
    Then user stay on login page
    Examples:
      |           email         |   password   |
      | nachtfaust866@gmail.com | password!123 |

  @login @negative
  Scenario: As a user, I should not be able to sign in with both blank email and password
    Given user should be open "https://staging-aero-swift.netlify.app/" in web browser
    And user navigate to login page
    When user tap Sign In button
    Then user stay on login page

