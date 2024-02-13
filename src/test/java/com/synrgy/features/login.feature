@login
Feature: Login

  @login @positive
  Scenario Outline: As a user, I should be able to sign in with both valid email and password
    Given user has completed the onboarding steps and left notification enabled by default
    And user is on the login page
    When user input valid email "<email>" and valid password "<password>" to login
    And user tap on the Sign in button
    Then user redirected to the homepage
    And display greeting message "<greeting>"
    Examples:
      |           email         |   password  |    greeting   |
      | nachtfaust866@gmail.com| Password123! | Welcome back, |

  @login @negative
  Scenario Outline: As a user, I should not be able to sign in with unregistered email
    Given user has completed the onboarding steps and left notification enabled by default
    And user is on the login page
    When user input unregistered email "<email>" and password "<password>" to login
    And user tap on the Sign in button
    Then user stay on login page
    Examples:
      |           email        |   password   |
      | tewkesbury79@gmail.com | Password123! |

  @login @negative
  Scenario Outline: As a user, I should not be able to sign in with invalid email and valid password
    Given user has completed the onboarding steps and left notification enabled by default
    And user is on the login page
    When user input invalid email with typo "<email>" and valid password "<password>" to login
    And user tap on the Sign in button
    Then user stay on login page
    Examples:
      |           email         |   password   |
      | nachtfaust866@gmail.cmo | Password123! |

  @login @negative
  Scenario Outline: As a user, I should not be able to sign in with valid email and invalid password
    Given user has completed the onboarding steps and left notification enabled by default
    And user is on the login page
    When user input valid registered email "<email>" and invalid password "<password>" to login
    And user tap on the Sign in button
    Then user stay on login page
    Examples:
      |           email         |   password   |
      | nachtfaust866@gmail.com | password!123 |

  @login @negative
  Scenario Outline: As a user, I should not be able to sign in with both invalid email and password
    Given user has completed the onboarding steps and left notification enabled by default
    And user is on the login page
    When user input invalid email "<email>" and invalid password "<password>" to login
    And user tap on the Sign in button
    Then user stay on login page
    Examples:
      |           email         |   password  |
      | nachtfaust866@gmail.cmo | Password123 |

  @login @negative
  Scenario Outline: As a user, I should not be able to sign in with empty email field
    Given user has completed the onboarding steps and left notification enabled by default
    And user is on the login page
    When user input valid password "<password>" to login
    And user tap on the Sign in button
    Then user stay on login page
    And display alert message "<email alert>" in email field
    Examples:
      |   password   |                   email alert                |
      | Password123! | Email cannot be blank.\nEmail is required.\n |

  @login @negative
  Scenario Outline: As a user, I should not be able to sign in with empty password field
    Given user has completed the onboarding steps and left notification enabled by default
    And user is on the login page
    When user input valid registered email "<email>" to login
    And user tap on the Sign in button
    Then user stay on login page
    And display alert message "<password alert>" in password field
    Examples:
      |           email         |                                   password alert                                     |
      | nachtfaust866@gmail.com | Password is required.\nPassword cannot be blank.\n |

  @login @negative
  Scenario Outline: As a user, I should not be able to sign in with both empty email and password fields
    Given user has completed the onboarding steps and left notification enabled by default
    And user is on the login page
    When user tap on the Sign in button
    Then user stay on login page
    And display alert message "<email alert>" in email field and "<password alert>" in password field
    Examples:
      |                    email alert               |                                    password alert                                    |
      | Email is required.\nEmail cannot be blank.\n | Password is required.\nPassword cannot be blank.\n |

