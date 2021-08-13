Feature: Gmail compose - Subject validation
  Description :  Validating the subject section  is working as expected in the gmail

  Scenario: Validate the user is able to enter the given text in the subject of the new message
    Given User opens the Chrome browser
    When User navigates to https://www.gmail.com/ url
    And User enters the username as t30111933@gmail.com and password as Tester123@
    When User clicks on the compose button
    Then User enters the text of Automation QA test for Incubyte in the message body
    Then User enters the text of Incubyte in the subject 
    Then User sends the email to t30111933@gmail.com
    Then User completed the given test

# t30111933@gmail.com
# Tester123@
