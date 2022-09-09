@Regression
Feature: Test cases for creating, editing, deleting and filtering users

  @GetUsers
  Scenario: Get all users
    Given Sam the supervisor fetches all users from page 1
    Then  User details should be correct

  @CreateUser
  Scenario Outline: Create an user
    Given Sam create the given user
      | name   | job   |
      | <name> | <job> |
    Then The status code of the response should be 200
    Examples:
      | name   | job         |
      | carl   | dev         |
      | steven | designer    |
      | josep  | iu designer |
