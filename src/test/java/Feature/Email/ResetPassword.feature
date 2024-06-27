Feature: Reset Password

#  Send Reset Password To Email

  Scenario: User Want To Send Reset Password using Valid Email
    Given User set API endpoint
    When User send POST HTTPS Request using valid Email To Reset Password
    Then User receive HTTP response code 200
    And User receive Success Message

  Scenario: User Want To Send Reset Password to Invalid Email
    Given User set API endpoint
    When User send POST HTTPS Request using invalid Email To Reset Password
    Then User receive HTTP response code 404
    And User receive Error Message

  Scenario: User Want To Send Reset Password without input Email
    Given User set API endpoint
    When User send POST HTTPS Request without input Email for Reset Password
    Then User receive HTTP response code 422
    And User receive Error Message

#  Reset Password

  Scenario: User Want To Reset Password With Invalid Password
    Given User set API endpoint
    When User send POST HTTPS Request using invalid password To Reset Password
    Then User receive HTTP response code 422
    And User receive Error Message

  Scenario: User Want To Reset Password With Valid Password
    Given User set API endpoint
    When User send POST HTTPS Request using valid password To Reset Password
    Then User receive HTTP response code 200
    And User receive Success Message

  Scenario: User Want To Reset Password Without Input Email and Password
    Given User set API endpoint
    When User send POST HTTPS Request To Reset Password Without Input Email and Password
    Then User receive HTTP response code 422
    And User receive Error Message

  Scenario: User Want To Reset Password Without input Email
    Given User set API endpoint
    When User send POST HTTPS Request To Reset Password Without input Email
    Then User receive HTTP response code 422
    And User receive Error Message

  Scenario: User Want To Reset Password Without input Password
    Given User set API endpoint
    When User send POST HTTPS Request To Reset Password Without input Password
    Then User receive HTTP response code 422
    And User receive Error Message




