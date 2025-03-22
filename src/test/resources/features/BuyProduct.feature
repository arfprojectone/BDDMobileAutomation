Feature: Buy Product

  Scenario: [Positive Case] The User Success Added a Product when Logged in
    Given The User is logged in
    When The User choose a product
    And The User click add to cart button
    And The User click cart
    And The User click proceed to checkout
    Then The User will be redirect to checkout page

  Scenario: [Positive Case] The User Success Added More Then One Product when Logged in
    Given The User is logged in
    When The User choose a product
    And The User add item
    And The User click add to cart button
    And The User click cart
    And The User click proceed to checkout
    Then The User will be redirect to checkout page

  Scenario: [Negative Case] The User Success Added a Product without Login
    Given The User has opened the app
    When The User choose a product
    And The User click add to cart button
    And The User click cart
    And The User click proceed to checkout
    Then The User will be redirect to login page

  Scenario: [Negative Case] The User Remove Item on Cart
    Given The User has opened the app
    When The User choose a product
    And The User click add to cart button
    And The User click cart
    And The User click remove item
    Then Item will be deleted