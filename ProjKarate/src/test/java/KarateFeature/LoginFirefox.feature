Feature: Login test
  This is login test

  Scenario: Login with valid credentials firefox
    * configure driver = { type: 'geckodriver', executable: 'C:\\SS\\Selenium\\BrowserDrivers\\geckodriver-v0.32.0-win64\\geckodriver.exe', webDriverSession: { capabilities: { browserName: 'firefox' } } }
    Given driver 'https://www.saucedemo.com/'
    And input("//*[@id='user-name']", "standard_user")
    And input("//*[@id='password']", "secret_sauce")
    When click("//*[@id='login-button']")
    * delay(27000)
    * def objGen = Java.type('supportingJavaFiles.javaGenericFunctions')
    * screenshot()
    #* delay(25000)
    #* click("//button[text()='Try it']")
    * def popuptext = objGen.fnGetTitle(driver)
    * print popuptext
    Then match driver.title == 'Swag Labs'
