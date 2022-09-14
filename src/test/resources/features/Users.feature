@Regression
Feature: Test cases for creating, editing, deleting and filtering users

  @GetUsers
  Scenario Outline: Get all users
    Given Sam the supervisor fetches all users from page <page>
    Then  User details should be correct
    And   The status code of the response should be 200
    Examples:
      | page |
      | 1    |
      | 2    |
      | 3    |

  @CreateUser
  Scenario Outline: Create an user
    Given Sam create the given user
      | name   | job   |
      | <name> | <job> |
    Then The status code of the response should be 201
    Examples:
      | name    | job           |
      | carl    | dev           |
      | josep   | iu designer   |
      | raphael | tech director |

  @UpdateUser
  Scenario Outline: Update an existing user
    Given Sam update an existing user with <id>
      | name   | job   |
      | <name> | <job> |
    Then The status code of the response should be 201
    Examples:
      | id | name     | job                |
      | 1  | morpheus | zion resident      |
      | 2  | james    | nba player         |
      | 2  | james    | Globant salesforce |





