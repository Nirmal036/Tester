Feature: Gmail compose option validation
  Description :  Validating the compose option is present in the gmail

  Scenario: Validate the compose option is present in the gmail
    Given User opens the Chrome browser
    When User navigates to https://www.gmail.com/ url
    And User enters the username as t30111933@gmail.com and password as Tester123@
    Then Gmail page should be opened
    Then Compose option should be present in the gmail
    Then User completed the given test

# t30111933@gmail.com
# Tester123@
