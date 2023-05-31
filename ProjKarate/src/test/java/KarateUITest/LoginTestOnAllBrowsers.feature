Feature: Login test
  This is login test

@testFirefox
  Scenario: Login with valid credentials firefox
    * configure driver = { type: 'geckodriver', executable: 'C:\\SS\\Selenium\\BrowserDrivers\\geckodriver-v0.32.0-win64\\geckodriver.exe', webDriverSession: { capabilities: { browserName: 'firefox' } } }
    * driver.maximize()
    Given driver 'https://www.saucedemo.com/'
    And input("//*[@id='user-name']", "standard_user")
    And input("//*[@id='password']", "secret_sauce")
    When click("//*[@id='login-button']")
    Then match driver.title == 'Swag Labs'

@testChrome
  Scenario: Login with valid credentials chrome
  * configure driver = { type: 'chrome' }
  * driver.maximize()
    Given driver 'https://www.saucedemo.com/'
    And input("//*[@id='user-name']", "standard_user")
    And input("//*[@id='password']", "secret_sauce")
    When click("//*[@id='login-button']")
    Then match driver.title == 'Swag Labs'
    
@testMSEdge
  Scenario: Login with valid credentials msedge
  * configure driver = { type: 'msedgedriver', executable: 'C:\\SS\\Selenium\\BrowserDrivers\\edgedriver_win64\\msedgedriver.exe', webDriverSession: { capabilities: { browserName: 'edge' } } }
  * driver.maximize()
    Given driver 'https://www.saucedemo.com/'
    And input("//*[@id='user-name']", "standard_user")
    And input("//*[@id='password']", "secret_sauce")
    When click("//*[@id='login-button']")
    Then match driver.title == 'Swag Labs'