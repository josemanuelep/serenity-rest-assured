@Regression
Feature: Test cases for login into the app

  @CreateUser
  Scenario Outline: Login with username and password
    Given Sam login with credentials
      | email   | password   |
      | <email> | <password> |
    Then The status code of the response should be 200
    Examples:
      | email              | password   |
      | eve.holt@reqres.in | cityslicka |



