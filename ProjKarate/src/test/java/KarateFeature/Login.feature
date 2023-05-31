Feature: Login test
This is login test

  Scenario: Login with valid credentials chrome
  * configure driver = { type: 'chrome', executable: 'C:\\SS\\Selenium\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe' }
    Given driver 'https://www.saucedemo.com/'
    * driver.maximize()
    And input("//*[@id='user-name']", "standard_user")
    And input("//*[@id='password']", "secret_sauce")
    When click("//*[@id='login-button']")
    Then match driver.title == 'Swag Labs' 
    
  Scenario: Login with valid credentials firefox
  * configure driver = { type: 'geckodriver', executable: 'C:\\SS\\Selenium\\BrowserDrivers\\geckodriver-v0.32.0-win64\\geckodriver.exe', webDriverSession: { capabilities: { browserName: 'firefox' } } }
    Given driver 'https://www.saucedemo.com/'
    * driver.maximize()
    And input("//*[@id='user-name']", "standard_user")
    And input("//*[@id='password']", "secret_sauce")
    When click("//*[@id='login-button']")
    Then match driver.title == 'Swag Labs' 