Feature: Title of your feature
  I want to use this template for my feature file

  Scenario: Title of your scenario
  #* configure driver = { type: 'geckodriver', executable: 'F:\\Selenium\\BrowserDrivers\\geckodriver-v0.32.0-win64\\geckodriver.exe', webDriverSession: { capabilities: { browserName: 'firefox' } } }
  #* configure driver = { type: 'msedge' }
  * configure driver = { type: 'chrome' }
 # * configure driver = { type: 'msedgedriver', executable: 'F:\\Selenium\\BrowserDrivers\\edgedriver_win64\\msedgedriver.exe', webDriverSession: { capabilities: { browserName: 'edge' } } }
    Given driver 'https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert'
    #Given driver 'C:\Users\user\Desktop\test.html'
    #Given driver 'https://www.yahoo.com'
    * delay(27000)
    #And switchFrame(2)
    And switchFrame("//*[@id='iframeResult']")
    #* delay(5000) 
    # And click("//button[text()='Try it']")
    #* delay(25000)
    #* def dd = driver.dialog
    #* print dd
    #* def test1 = "sriram" 
    * screenshot()
    * def objGen = Java.type('supportingJavaFiles.javaGenericFunctions')
    * screenshot()
    #* delay(25000)
    * click("//button[text()='Try it']")
    * def popuptext = objGen.fnPopUpGetText(driver)
    * screenshot()
    * print popuptext
    * dialog(true)
    * def pagetitle = objGen.fnGetTitle(driver)
    * screenshot()
    * print pagetitle
    #* delay(5000)    