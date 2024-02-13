@guestLogin
Feature: Guest Login

  @guestLogin @positive
  Scenario Outline: As a user, I should be able to access search feature and view ticket list as a guest
    Given user has completed the onboarding steps and left notification enabled by default
    And user is on the login page
    When user tap Login as a guest link
    And user select a Origin "<origin>"
    And user select a Destination "<destination>"
    And user select Depart Date "<date>"
    And user select passengers and cabin class
    And user tap Search Flight button
    Then user view ticket list
    Examples:
      | origin | destination |    date     |
      | malang |   jakarta   | 15 Feb 2024 |

  @guestLogin @negative
  Scenario Outline: As a user, I should not be able to book a flight as a guest
    Given user has completed the onboarding steps and left notification enabled by default
    And user is on the login page
    When user tap Login as a guest link
    And user search a flight
    And user select a ticket
    Then display an alert message "<alert>"
    Examples:
      |                               alert                                     |
      | You must sign in first to be able to use all the features |

  @guestLogin @negative
  Scenario Outline: As a user, I should not be able to access Profile feature as a guest
    Given user has completed the onboarding steps and left notification enabled by default
    And user is on the login page
    When user tap Login as a guest link
    And user tap Profile on navigation bar
    Then display an alert message "<alert>"
    Examples:
      |                        alert                              |
      | You must sign in first to be able to use all the features |

  @guestLogin @negative
  Scenario Outline: As a user, I should not be able to access My Flight feature as a guest
    Given user has completed the onboarding steps and left notification enabled by default
    And user is on the login page
    When user tap Login as a guest link
    And user tap My Flight on navigation bar
    Then display an alert message "<alert>"
    Examples:
      |                        alert                              |
      | You must sign in first to be able to use all the features |