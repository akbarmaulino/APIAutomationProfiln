Feature: New Post

  Scenario: User Want To Create New Post
    Given User set API endpoint
    When User send POST HTTPS Request For Create New Post
    Then User receive HTTP response code 201
    And User receive Success Message

  Scenario: User Want To Create New Post Without Login
    Given User set API endpoint
    When User send POST HTTPS Request For Create New Post Without Login
    Then User receive HTTP response code 401
    And User receive Error Message

  Scenario: User Want To Create New Post Validation Error
    Given User set API endpoint
    When User send POST HTTPS Request For Create New Post Validation Error
    Then User receive HTTP response code 422
    And User receive Error Message

#Masih Error Saat Kirim Image
#  Scenario: User Want To Comment Post
#    Given User set API endpoint
#    When User send POST HTTPS Request For Comment Post
#    Then User receive HTTP response code 415
#    And User receive Success Message

  Scenario: User Want To Comment Post Validation Error
    Given User set API endpoint
    When User send POST HTTPS Request For Comment Post Validation Error
    Then User receive HTTP response code 422
    And User receive Error Message

  Scenario: User Want To Comment Post Wrong Format
    Given User set API endpoint
    When User send POST HTTPS Request For Comment Post Wrong Format File
    Then User receive HTTP response code 415
    And User receive Error Message

  Scenario: User Want To Comment Post Many Files
    Given User set API endpoint
    When User send POST HTTPS Request For Comment Post Many Files
    Then User receive HTTP response code 400
    And User receive Error Message

#  Scenario: User Want To Comment Post Large Size
#    Given User set API endpoint
#    When User send POST HTTPS Request For Comment Post Large Size
#    Then User receive HTTP response code 413
#    And User receive Error Message

  Scenario: User Want To Comment Post Data Not Found
    Given User set API endpoint
    When User send POST HTTPS Request For Comment Post Data Not Found
    Then User receive HTTP response code 404
    And User receive Error Message

  Scenario: User Want To Reply Comment Post
    Given User set API endpoint
    When User send POST HTTPS Request For Replay Comment
    Then User receive HTTP response code 201
    And User receive Success Message

  Scenario: User Want To Reply Comment Post Validation Error
    Given User set API endpoint
    When User send POST HTTPS Request For Replay Comment Validation Error
    Then User receive HTTP response code 422
    And User receive Error Message

  Scenario: User Want To Reply Comment Post Wrong Format
    Given User set API endpoint
    When User send POST HTTPS Request For Replay Comment Wrong Format
    Then User receive HTTP response code 415
    And User receive Error Message

  Scenario: User Want To Reply Comment Post Many Files
    Given User set API endpoint
    When User send POST HTTPS Request For Replay Comment Many Files
    Then User receive HTTP response code 400
    And User receive Error Message

#  Scenario: User Want To Reply Comment Post Large Size
#    Given User set API endpoint
#    When User send POST HTTPS Request For Replay Comment Large Size
#    Then User receive HTTP response code 413
#    And User receive Error Message

  Scenario: User Want To Reply Comment Post Not Found
    Given User set API endpoint
    When User send POST HTTPS Request For Replay Comment Not Found
    Then User receive HTTP response code 404
    And User receive Error Message

  Scenario: User Want To Reply Comment Post No Auth
    Given User set API endpoint
    When User send POST HTTPS Request For Replay Comment No Auth
    Then User receive HTTP response code 401
    And User receive Error Message

  Scenario: User Want To Report Post
    Given User set API endpoint
    When User send POST HTTPS Request For Report Post
    Then User receive HTTP response code 200
    And User receive Success Message

  Scenario: User Want To Report Post Validation Error
    Given User set API endpoint
    When User send POST HTTPS Request For Report Post Validation Error
    Then User receive HTTP response code 422
    And User receive Error Message

  Scenario: User Want To Report Post No Auth
    Given User set API endpoint
    When User send POST HTTPS Request For Report Post No Auth
    Then User receive HTTP response code 401
    And User receive Error Message

  Scenario: User Want To Like Post
    Given User set API endpoint
    When User send POST HTTPS Request For Like Post
    Then User receive HTTP response code 200
    And User receive Success Message

  Scenario: User Want To Like Post Not Found
    Given User set API endpoint
    When User send POST HTTPS Request For Like Post Not Found
    Then User receive HTTP response code 404
    And User receive Error Message

  Scenario: User Want To Like Post No Auth
    Given User set API endpoint
    When User send POST HTTPS Request For Like Post No Auth
    Then User receive HTTP response code 401
    And User receive Error Message

  Scenario: User Want To Unlike Post
    Given User set API endpoint
    When User send DELETE HTTPS Request For Unlike Post
    Then User receive HTTP response code 200
    And User receive Success Message

  Scenario: User Want To Unlike Post Not Found
    Given User set API endpoint
    When User send DELETE HTTPS Request For Unlike Post Not Found
    Then User receive HTTP response code 404
    And User receive Error Message

  Scenario: User Want To Unlike Post No Auth
    Given User set API endpoint
    When User send DELETE HTTPS Request For Unlike Post No Auth
    Then User receive HTTP response code 401
    And User receive Error Message

  Scenario: User Want To Like Post Comment
    Given User set API endpoint
    When User send POST HTTPS Request For Like Post Comment
    Then User receive HTTP response code 200
    And User receive Success Message

  Scenario: User Want To Like Post Not Found Comment
    Given User set API endpoint
    When User send POST HTTPS Request For Like Post Not Found Comment
    Then User receive HTTP response code 404
    And User receive Error Message

  Scenario: User Want To Like Post No Auth Comment
    Given User set API endpoint
    When User send POST HTTPS Request For Like Post No Auth Comment
    Then User receive HTTP response code 401
    And User receive Error Message

  Scenario: User Want To Unlike Post Comment
    Given User set API endpoint
    When User send DELETE HTTPS Request For Unlike Post Comment
    Then User receive HTTP response code 200
    And User receive Success Message

  Scenario: User Want To Unlike Post Not Found Comment
    Given User set API endpoint
    When User send DELETE HTTPS Request For Unlike Post Not Found Comment
    Then User receive HTTP response code 404
    And User receive Error Message

  Scenario: User Want To Unlike Post No Auth Comment
    Given User set API endpoint
    When User send DELETE HTTPS Request For Unlike Post No Auth Comment
    Then User receive HTTP response code 401
    And User receive Error Message

  Scenario: User Want To Update Post
    Given User set API endpoint
    When User send PATCH HTTPS Request For Update Post
    Then User receive HTTP response code 200
    And User receive Success Message

  Scenario: User Want To Update Post No Auth
    Given User set API endpoint
    When User send PATCH HTTPS Request For Update Post No Auth
    Then User receive HTTP response code 401
    And User receive Error Message

  Scenario: User Want To Update Post Not Found
    Given User set API endpoint
    When User send PATCH HTTPS Request For Update Post Not Found
    Then User receive HTTP response code 404
    And User receive Error Message

  Scenario: User Want To Repost Post
    Given User set API endpoint
    When User send POST HTTPS Request For Repost Post
    Then User receive HTTP response code 200
    And User receive Success Message

  Scenario: User Want To Repost Post Not Found
    Given User set API endpoint
    When User send POST HTTPS Request For Repost Post Not Found
    Then User receive HTTP response code 404
    And User receive Error Message

  Scenario: User Want To Repost Post No Author
    Given User set API endpoint
    When User send POST HTTPS Request For Repost Post No Author
    Then User receive HTTP response code 401
    And User receive Error Message

  Scenario: User Want To Repost Self Post
    Given User set API endpoint
    When User send POST HTTPS Request For Repost Self Post
    Then User receive HTTP response code 422
    And User receive Error Message

  Scenario: User Want To Unrepost Post
    Given User set API endpoint
    When User send POST HTTPS Request For Unrepost
    Then User receive HTTP response code 200
    And User receive Success Message

  Scenario: User Want To Unrepost Post Not Found
    Given User set API endpoint
    When User send POST HTTPS Request For Unrepost Not Found
    Then User receive HTTP response code 404
    And User receive Error Message

  Scenario: User Want To Unrepost Post No Author
    Given User set API endpoint
    When User send POST HTTPS Request For Unrepost No Author
    Then User receive HTTP response code 401
    And User receive Error Message

#  Scenario: User Want To Upload Image For Create Post
#    Given User set API endpoint
#    When User send POST HTTPS Request For Upload Image For Create Post
#    Then User receive HTTP response code 201
#    And User receive Success Message

  Scenario: User Want To Upload Image For Create Post Not Found
    Given User set API endpoint
    When User send POST HTTPS Request For Create New Post Not Found
    Then User receive HTTP response code 404
    And User receive Error Message

  Scenario: User Want To Upload Image For Create Post Many Image
    Given User set API endpoint
    When User send POST HTTPS Request For Create New Post Many Image
    Then User receive HTTP response code 400
    And User receive Error Message

#  Scenario: User Want To Upload Image For Create Post Large Size File
#    Given User set API endpoint
#    When User send POST HTTPS Request For Create New Post Large Size File
#    Then User receive HTTP response code 413
#    And User receive Error Message

  Scenario: User Want To Upload Image For Create Post Wrong Format
    Given User set API endpoint
    When User send POST HTTPS Request For Create New Post Wrong Format
    Then User receive HTTP response code 415
    And User receive Error Message

#  Scenario: User Want To Update Image For Create Post
#    Given User set API endpoint
#    When User send PUT HTTPS Request For Upload Image For Create Post
#    Then User receive HTTP response code 200
#    And User receive Success Message

  Scenario: User Want To Update Image For Create Post Not Found
    Given User set API endpoint
    When User send PUT HTTPS Request For Create New Post Not Found
    Then User receive HTTP response code 404
    And User receive Error Message

  Scenario: User Want To Update Image For Create Post Many Image
    Given User set API endpoint
    When User send PUT HTTPS Request For Create New Post Many Image
    Then User receive HTTP response code 400
    And User receive Error Message

#  Scenario: User Want To Update Image For Create Post Large Size File
#    Given User set API endpoint
#    When User send PUT HTTPS Request For Create New Post Large Size File
#    Then User receive HTTP response code 413
#    And User receive Error Message

  Scenario: User Want To Update Image For Create Post Wrong Format
    Given User set API endpoint
    When User send PUT HTTPS Request For Create New Post Wrong Format
    Then User receive HTTP response code 415
    And User receive Error Message

  Scenario: User Want To Get All
    Given User set API endpoint
    When User send Get HTTPS Request For Get All
    Then User receive HTTP response code 200
    And User receive Success Message

  Scenario: User Want To Get All No Auth
    Given User set API endpoint
    When User send Get HTTPS Request For Get All No Auth
    Then User receive HTTP response code 401
    And User receive Error Message

  Scenario: User Want To Get All Post Comment
    Given User set API endpoint
    When User send Get HTTPS Request For Get All Post Comment
    Then User receive HTTP response code 200
    And User receive Success Message

  Scenario: User Want To Get All Post Comment No Auth
    Given User set API endpoint
    When User send Get HTTPS Request For Get All Post Comment No Auth
    Then User receive HTTP response code 401
    And User receive Error Message

  Scenario: User Want To Get All Detail Post
    Given User set API endpoint
    When User send Get HTTPS Request For Get All Detail Post
    Then User receive HTTP response code 200
    And User receive Success Message

  Scenario: User Want To Get All Detail Post Not Found
    Given User set API endpoint
    When User send Get HTTPS Request For Get All Detail Post Not Found
    Then User receive HTTP response code 404
    And User receive Error Message

  Scenario: User Want To Get All Reply
    Given User set API endpoint
    When User send Get HTTPS Request For Get All Reply
    Then User receive HTTP response code 200
    And User receive Success Message

  Scenario: User Want To Get All Reply No Auth
    Given User set API endpoint
    When User send Get HTTPS Request For Get All Reply No Auth
    Then User receive HTTP response code 401
    And User receive Error Message

  Scenario: User Want To Get All Post By User ID
    Given User set API endpoint
    When User send Get HTTPS Request For Get All Post By User ID
    Then User receive HTTP response code 200
    And User receive Success Message

  Scenario: User Want To Get All Post By User ID No Auth
    Given User set API endpoint
    When User send Get HTTPS Request For Get All Post By User ID No Auth
    Then User receive HTTP response code 401
    And User receive Error Message

  Scenario: User Want To Get All By User ID
    Given User set API endpoint
    When User send Get HTTPS Request For Get All By User ID
    Then User receive HTTP response code 200
    And User receive Success Message

  Scenario: User Want To Get All By User ID No Auth
    Given User set API endpoint
    When User send Get HTTPS Request For Get All By User ID No Auth
    Then User receive HTTP response code 401
    And User receive Error Message


