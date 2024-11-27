Feature: Delete Post

  Scenario: User Want To Login With Valid Email and Password
    Given User set API endpoint
    When User send POST HTTPS Request using valid Email and Password
    Then User receive HTTP response code 200
    And User receive Success Message

  Scenario: User Want To Create New Post
    Given User set API endpoint
    When User send POST HTTPS Request For Create New Post
    Then User receive HTTP response code 201
    And User receive Success Message

  Scenario: User Want To Delete Post
    Given User set API endpoint
    When User send DELETE HTTPS Request For Delete Post
    Then User receive HTTP response code 200
    And User receive Success Message
#
#  Scenario: User Want To Delete Post Not Found
#    Given User set API endpoint
#    When User send DELETE HTTPS Request For Delete Post Not Found
#    Then User receive HTTP response code 404
#    And User receive Error Message
#
#  Scenario: User Want To Delete Post No Auth
#    Given User set API endpoint
#    When User send DELETE HTTPS Request For Delete Post No Auth
#    Then User receive HTTP response code 401
#    And User receive Error Message