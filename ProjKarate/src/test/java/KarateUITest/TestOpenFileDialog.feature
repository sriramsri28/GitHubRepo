Feature: Login test
  This is login test

@testChrome
  Scenario: Login with valid credentials chrome
  * configure driver = { type: 'chrome' }
  * driver.maximize()
    Given driver 'https://www.saucedemo.com/'
    And input("//*[@id='user-name']", "standard_user")
    And input("//*[@id='password']", "secret_sauce")
    When click("//*[@id='login-button']")
    Then match driver.title == 'Swag Labs'