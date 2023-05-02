Feature: Login Functionality of OpenWeatherMap Website

  As a user of the OpenWeatherMap website
  I want to be able to log in with my account
  So that I can access my account-related features

  Background:
    Given I am on the OpenWeather Signin Page

  Scenario: Successful login with valid credentials
    Given User enters Credentials to LogIn
    When I click on the submit button
    Then I should be logged in successfully

  Scenario Outline: Unsuccessful login with invalid or empty credentials
    Given I have entered invalid "<email>" and "<password>"
    When I click on the submit button
    Then I should see an error message indicating "<error_message>"

    Examples:
      | email             | password        | error_message              |
      | invalid@email.com | invalidPassword | Invalid Email or password. |
      | abcccc            | validPassword   | Invalid Email or password. |
      | valid@email.com   | abccc           | Invalid Email or password. |

