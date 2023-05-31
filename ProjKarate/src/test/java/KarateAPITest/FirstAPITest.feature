Feature: Sample API test

  Scenario: First API test
    Given url 'https://reqres.in/api/users?page=2'
    When method GET
    Then status 200
