@orderFlight
Feature: Order Flight

  @orderFlight @positive
  Scenario: As a user, I should be able to order One-Way flight
    Given user has completed the onboarding steps and left notification enabled by default
    And user successfully login
    And user is on the homepage
    When user search a flight
    And user select a flight
    And user complete passenger details
    And user proceed to payment
    And user make the payment
    Then user directed to My Flight page
