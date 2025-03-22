Feature: Review Product Feature

  Scenario: [Positive Case] The User Add a Product Review with Login
    Given The user is logged in
    When The user click added review
    Then Review count will increase

  Scenario: [Negative Case] The User Reduce a Product Review with Login
    Given The user is logged in
    When The user click reducing review
    Then Review count will decrease

  Scenario: [Negative Case] The User Add a Product Review without Login
    Given The user has opened the app
    When The user click added review
    Then Review count will increase