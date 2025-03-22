Feature: Logout Feature

  Scenario: [Positive Case] The User Success Logout
    Given The User is logged in
    When The User click the menu
    And The User click the logout submenu
    And The User click logout button
    Then The User is successfully logged out

  Scenario: [Negative Case] The User Cancel Logout
    Given The User is logged in
    When The User click the menu
    And The User click the logout submenu
    And The User click cancel button
    Then The User is successfully cancel logged out