set projectlocation=C:\SS\Selenium\testSeleniumJenkinsProject
cd %projectlocation%
set classpath=%projectlocation%\target\classes\*;%projectlocation%\lib
java org.testng.TestNG %projectlocation%\testng.xml
pause