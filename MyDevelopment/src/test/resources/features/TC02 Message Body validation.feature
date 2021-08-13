Feature: Gmail compose - message body validation
  Description :  Validating the message body  is working as expected in the gmail

  Scenario: Validate the user is able to enter the given text in the message body
    Given User opens the Chrome browser
    When User navigates to https://www.gmail.com/ url
    And User enters the username as t30111933@gmail.com and password as Tester123@
    When User clicks on the compose button
    Then User enters the text of Automation QA test for Incubyte in the message body 
    Then User completed the given test

# t30111933@gmail.com
# Tester123@
