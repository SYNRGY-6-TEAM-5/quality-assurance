@searchTicket
Feature: Search Ticket

  @searchTicket @positive
  Scenario Outline: As a user, I should be able to search ticket for One-Way flight
    Given user has completed the onboarding steps and left notification enabled by default
    And user successfully login
    And user is on the homepage
    When user select a Origin "<origin>"
    And user select a Destination "<destination>"
    And user select Depart Date "<date>"
    And user select passengers and cabin class
    And user tap Search Flight button
    Then user view ticket list
    Examples:
      | origin | destination |    date     |
      | Malang |   Jakarta   | 15 Feb 2024 |

  @searchTicket @negative
  Scenario Outline: As a user, I should not be able to search ticket for One-Way flight without select depart date
    Given user has completed the onboarding steps and left notification enabled by default
    And user successfully login
    And user is on the homepage
    When user select a Origin "<origin>"
    And user select a Destination "<destination>"
    And user select passengers and cabin class
    And user tap Search Flight button
    Then display an alert message with message "<alert>"
    Examples:
      | origin | destination  |        alert          |
      | Malang |   Jakarta    | Please fill all field |

  @searchTicket @negative
  Scenario Outline: As a user, I should not be able to search ticket for One-Way flight without select passengers and cabin class
    Given user has completed the onboarding steps and left notification enabled by default
    And user successfully login
    And user is on the homepage
    When user select a Origin "<origin>"
    And user select a Destination "<destination>"
    And user select Depart Date "<date>"
    And user tap Search Flight button
    Then display an alert message with message "<alert>"
    Examples:
      | origin | destination |    date     |        alert          |
      | Malang |   Jakarta   | 15 Feb 2024 | Please fill all field |


  @searchTicket @positive
  Scenario Outline: As a user, I should be able to search ticket for Roundtrip flight
    Given user has completed the onboarding steps and left notification enabled by default
    And user successfully login
    And user is on the homepage
    When user tap Roundtrip option
    And user select a Origin "<origin>"
    And user select a Destination "<destination>"
    And user select Depart Date "<depart date>"
    And user select Return Date "<return date>"
    And user select passenger and cabin class
    And user tap Search Flight button
    Then user view ticket list
    Examples:
      | origin | destination | depart date | return date |
      | Malang |   Jakarta   | 15 Feb 2024 | 17 Feb 2024 |