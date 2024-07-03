Feature: Follow and Unfollow Account

  Scenario: User Want To Follow Another User
    Given User set API endpoint
    When User send Post HTTPS Request For Follow Another User
    Then User receive HTTP response code 200
    And User receive Success Message

  Scenario: User Want To Follow Another User No Auth
    Given User set API endpoint
    When User send Post HTTPS Request For Follow Another User No Auth
    Then User receive HTTP response code 401
    And User receive Error Message

  Scenario: User Want To Unfollow Another User
    Given User set API endpoint
    When User send Delete HTTPS Request For Unfollow Another User
    Then User receive HTTP response code 200
    And User receive Success Message

  Scenario: User Want To Unfollow Another User No Auth
    Given User set API endpoint
    When User send Delete HTTPS Request For Unfollow Another User No Auth
    Then User receive HTTP response code 401
    And User receive Error Message