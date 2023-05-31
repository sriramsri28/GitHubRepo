Feature: windows calculator
	did you know that Karate can do Windows desktop / app automation ?
	you are almost set - just download one more JAR file
	instructions here: https://github.com/intuit/karate/wiki/ZIP-Release#karate-robot

Scenario:

* def windowName = '~Notepad++'
* robot { window: '#(windowName)', fork: 'C:/Program Files (x86)/Notepad++/notepad++.exe', retryCount: 10, highlight: true, highlightDuration: 500  }
#* windowOptional('Tips on Startup').locate('Close').click()
* window(windowName)