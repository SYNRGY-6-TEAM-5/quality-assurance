@editProfile
Feature: Edit Profile

  @editProfile @positive
  Scenario Outline: As a user, I should be able to edit my profile information
    Given user has completed the onboarding steps and left notification enabled by default
    And user successfully login
    And user is on the homepage
    When user tap Profile on navigation bar
    And user tap pencil icon
    And user edit full name "<full name>"
    And user edit date of birth "<dob>"
    And user edit phone number "<phone number>"
    And user tap Change to edit photo profile
    Then user tap Save button
    And user redirected to the profile page
    Examples:
      | full name |     dob     | phone number |
      |   Choso   | 28/02/2013  | 81914437613  |

  @editProfile @negative
  Scenario Outline: As a user, I should receive alert if navigate back without saving edited profile information
    Given user has completed the onboarding steps and left notification enabled by default
    And user successfully login
    And user is on the homepage
    When user tap Profile on navigation bar
    And user tap pencil icon
    And user edit full name "<full name>"
    And user edit date of birth "<dob>"
    And user edit phone number "<phone number>"
    And user tap Change to edit photo profile
    Then user tap back button
    And display the alert message with text "<alert>"
    Examples:
      | full name |     dob     | phone number |                                       alert                                                       |
      |   Choso   | 28/02/2013  | 819142313131  | You have modified your profile data. Are you sure you want to go back without saving the changes? |

  @editProfile @negative
  Scenario: As a user, I should not be able to save profile information if no changes have been made on the profile editing page
    Given user has completed the onboarding steps and left notification enabled by default
    And user successfully login
    And user is on the homepage
    When user tap Profile on navigation bar
    And user tap pencil icon
    And user tap Save button
    Then user stay on profile page
