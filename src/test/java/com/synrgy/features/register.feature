@register
Feature: Register

  @register @positive
  Scenario Outline: As a user, I should be able to sign up with both valid email and password
    Given user has completed the onboarding steps and left notification enabled by default
    And user navigate to register page
    When user input valid email "<email>" and valid password "<password>" to register
    And user tap on the Sign Up button
    And user accepting Terms and Conditions
    And user input verification code
    And user tap on Confirm button
    And user tap Skip option
    Then user see a success message
    And user redirected to the homepage
    Examples:
      |           email         |       password       |
      | testAeroSwift@gmail.com | iniStrongPassword!12 |

  @register @negative
  Scenario Outline: As a user, I should not be able to sign up with invalid email and valid password
    Given user has completed the onboarding steps and left notification enabled by default
    And user navigate to register page
    When user input invalid email "<email>" and valid password "<password>" to register
    And user tap on the Sign Up button
    Then user stay on register page
    And display alert message with text "<alert>"
    Examples:
      |           email         |   password   |         alert         |
      | testAeroSwiftgmail.com  | iniStrongPassword!12 | Email is not valid.\n |

  @register @negative
  Scenario Outline: As a user, I should not be able to sign up with valid email and invalid password
    Given user has completed the onboarding steps and left notification enabled by default
    And user navigate to register page
    When user input valid email "<email>" and invalid password "<password>" to register
    And user tap on the Sign Up button
    Then user stay on register page
    And display alert message with the text "<alert>"
    Examples:
      |           email          |     password     |                         alert                       |
      | testAeroSwift@gmail.com  | iniPasswordWeak! | Password should contain both letters and numbers.\n |

  @register @negative
  Scenario Outline: As a user, I should not be able to sign up with registered email
    Given user has completed the onboarding steps and left notification enabled by default
    And user navigate to register page
    When user input registered email "<email>" and password "<password>" to register
    And user tap on the Sign Up button
    Then user stay on register page
    Examples:
      |           email         |   password   |
      | nachtfaust866@gmail.com | Password123! |

  @register @negative
  Scenario Outline: As a user, I should not be able to sign up with both empty email and password fields
    Given user has completed the onboarding steps and left notification enabled by default
    And user navigate to register page
    When user tap on the Sign Up button
    Then user stay on register page
    And display alert message "<email alert>" in the email field and "<password alert>" in the password field
    Examples:
      |                    email alert               |                                                                                               password alert                                                                                                       |
      |  Email is required.\nEmail is not valid.\n   | Password is required.\nPassword length min 8 character.\nPassword should contain a special character.\nPassword should contain both letters and numbers.\nPassword should contain at least one uppercase letter.\n |

  @register @negative
  Scenario Outline: As a user, I should not be able to sign up with empty email field
    Given user has completed the onboarding steps and left notification enabled by default
    And user navigate to register page
    When user input valid password "<password>"
    And user tap on the Sign Up button
    Then user stay on register page
    And display alert message with text "<email alert>"
    Examples:
      |        password      |                   email alert                |
      | iniStrongPassword!12 |   Email is required.\nEmail is not valid.\n  |

  @register @negative
  Scenario Outline: As a user, I should not be able to sign up with empty password field
    Given user has completed the onboarding steps and left notification enabled by default
    And user navigate to register page
    When user input valid email "<email>"
    And user tap on the Sign Up button
    Then user stay on register page
    And display alert message with the text "<password alert>"
    Examples:
      |           email         |                                                                                            password alert                                                                                                         |
      | testAeroSwift@gmail.com | Password is required.\nPassword length min 8 character.\nPassword should contain a special character.\nPassword should contain both letters and numbers.\nPassword should contain at least one uppercase letter.\n |