Feature: Login test
  This is login test

  Scenario: Login with valid credentials msedge
  * configure driver = { type: 'msedgedriver', executable: 'F:\\Selenium\\BrowserDrivers\\edgedriver_win64\\msedgedriver.exe', webDriverSession: { capabilities: { browserName: 'edge' } } }
    Given driver 'https://www.saucedemo.com/'
    And input("//*[@id='user-name']", "standard_user")
    And input("//*[@id='password']", "secret_sauce")
    When click("//*[@id='login-button']")
    Then match driver.title() == 'Swag Labs'
