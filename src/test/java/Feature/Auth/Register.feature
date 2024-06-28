Feature: Post Authentication using API

  Scenario: Verify the Post Authentication SSO
    Given i hit the url of post auth api endpoint
    When i pass the url of the sso auth in the request
    Then i receive the response code as 201

  Scenario: Verify the Post Authentication Manual
    Given i hit the url of post auth api endpoint
    When i pass the url of the manual auth in the request
    Then i receive the response code as 201

  Scenario: Verify the Post authentication form-data is not empty
    Given i hit the url of post auth api endpoint
    When i pass blank form-data in the request
    Then i received the response code as 422
