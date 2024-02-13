@ticketList
Feature: Search Ticket

  @ticketList @positive
  Scenario: As a user, I should be able to access and view ticket list
    Given user has completed the onboarding steps and left notification enabled by default
    And user successfully login
    And user is on the homepage
    When user search a flight
    And user scroll down to view the ticket list
    Then user select a ticket

  @ticketList @positive
  Scenario: As a user, I should be able to see next day's flight on day tab
    Given user has completed the onboarding steps and left notification enabled by default
    And user successfully login
    And user is on the homepage
    When user search a flight
    And user tap next day tab
    Then user directed to next day's ticket list
    And user see ticket list for next day's flight

  @ticketList @positive
  Scenario: As a user, I should be able to see previous day's flight on day tab
    Given user has completed the onboarding steps and left notification enabled by default
    And user successfully login
    And user is on the homepage
    When user search a flight
    And user tap previous day tab
    Then user directed to previous day's ticket list
    And user see ticket list for previous day's flight

  @ticketList @positive
  Scenario: As a user, I should be able to edit a searched flight on the ticket list page
    Given user has completed the onboarding steps and left notification enabled by default
    And user successfully login
    And user is on the homepage
    When user search a flight
    And user tap on the pencil icon
    Then user redirected to the search flight feature on the homepage
    And user successfully edit search flight fields and perform a search again