Feature: User Login

  Scenario: User Want To Login With Valid Email and Password
    Given User set API endpoint
    When User send POST HTTPS Request using valid Email and Password
    Then User receive HTTP response code 200
    And User receive Success Message

  Scenario: User Want To Login With Wrong Format Email and Password
    Given User set API endpoint
    When User send POST HTTPS Request using Wrong Format Email and Password
    Then User receive HTTP response code 422
    And  User receive Error Message

  Scenario: User Want To Login Using SSO Email
    Given User set API endpoint
    When User send POST HTTPS Request using SSO Email
    Then User receive HTTP response code 200
    And User receive Success Message

  Scenario: User Want To Login With Unregistered Email and Password
    Given User set API endpoint
    When User send POST HTTPS Request using Wrong Unregistered Email and Password
    Then User receive HTTP response code 401
    And  User receive Error Message

  Scenario: User Want To Login Without input Email and Password
    Given User set API endpoint
    When User send POST HTTPS Request Without Input Email and Password
    Then User receive HTTP response code 422
    And  User receive Error Message
