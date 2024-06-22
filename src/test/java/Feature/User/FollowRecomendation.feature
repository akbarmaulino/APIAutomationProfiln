Feature: Follow Recommendations

  Scenario: User Want To Follow Recommendations Without Login
    Given User set API endpoint
    When User send Get HTTPS Request For Follow Recommendations Without Login
    Then User receive HTTP response code 401
    And User receive Error Message
    
  Scenario: User Want To Follow Recommendations With Login
    Given User set API endpoint
    When User send Get HTTPS Request For Follow Recommendations With Login
    Then User receive HTTP response code 200
    And User receive Success Message

  Scenario: Testing API for 400 Bad Request For Follow Recommendations
    Given User set API endpoint
    When User send Get HTTPS Request For Follow Recommendations
    Then User receive HTTP response code 400







