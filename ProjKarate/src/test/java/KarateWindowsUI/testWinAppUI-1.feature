Feature: windows test Notepad++

  Scenario: 
    * def windowName = '~Notepad++'
    * robot { window: '#(windowName)', retryCount: 10, highlight: true, highlightDuration: 500  }
    * window(windowName)
    #* click('General')
    #* click('Hidden')
    #* screenshot()
    * click('Shortcut')
    #* click('Run:')
    #* screenshot()
    #* select('Run:Maximized')
    #* locate('Maximized').select()
    #* locate('//select').select()
    #* locateAll('//select')[1].click()
    #* select('select[name=Run:]', '{}Maximized')
    #* select('Run:', 'Maximized')
    #* select('#run:','Maximized')
    * highlightAll('//button')
    #* click('Target:')
    #* input('Target:').extra
    * input('Target:', 'ttest123')
    #* locate('').select()
    #* select('Open:', '{}Maximized')
    * click('Open')
     #* locate('Maximized').select()
    * locate('Maximized').click()
    #* screenshot()
    #* click('//button')[1]
    #* click('Cancel')    
    #* def text = robot.root.extract()
    #* def text = robot.root.extract()
    #* def allPopUps = locateAll('/root//window')
    #* locateAll('Run')[1].click()
    #* locate('~Run').click()
    #* select('~Run', 'Maximized')