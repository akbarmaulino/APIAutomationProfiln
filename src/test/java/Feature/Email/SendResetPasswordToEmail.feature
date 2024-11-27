Feature: Send Reset Password To Email

#  Send Reset Password To Email
  Scenario: User Want To Login With Valid Email and Password
    Given User set API endpoint
    When User send POST HTTPS Request using valid Email and Password
    Then User receive HTTP response code 200
    And User receive Success Message

  Scenario: User Want To Send Reset Password With Valid Email
    Given User set API endpoint
    When User send POST HTTPS For Send Link Reset Password With Valid Email
    Then User receive HTTP response code 200
    And User receive Success Message

  Scenario: User Want To Send Reset Password Using Unregistered Email
    Given User set API endpoint
    When User send POST HTTPS For Send Link Reset Password With Unregistered Email
    Then User receive HTTP response code 404
    And User receive Error Message

  Scenario: User Want To Send Reset Password Without Input Email
    Given User set API endpoint
    When User send POST HTTPS For Send Link Reset Password Without Input Email
    Then User receive HTTP response code 422
    And User receive Error Message

