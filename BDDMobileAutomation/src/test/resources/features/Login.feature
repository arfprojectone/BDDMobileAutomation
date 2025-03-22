Feature: Login Feature

  Scenario Outline: <testcases>
    Given The User has opened the app
    And The User click menu
    And The User click login submenu
    When The User input username "<username>"
    And The User input password "<password>"
    And The User click login button
    Then "<expected>"

    Examples:
      | testcases                                               | username          | password | expected                            |
      | [Positive Case] The User Login with Valid Credentials   | bod@example.com   | 10203040 | The User Successfully Login         |
      | [Negative Case] The User Login with Invalid Credentials | alice@example.com | 10203040 | The User Failed to Login            |
      | [Negative Case] The User Login without Input Username   |                   | 10203040 | Message Username is Required Appear |
      | [Negative Case] The User Login without Input Password   | bod@example.com   |          | Message Enter Password Appear       |