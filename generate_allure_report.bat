@echo off
:: If you already have a valid JAVA_HOME environment variable set, feel free to comment the below two lines
set JAVA_HOME=C:\Users\sara.omara\.jdks\openjdk-21.0.2
set path=%JAVA_HOME%\bin;%path%
set path=C:\Users\sara.omara\.m2\repository\allure\allure-2.25.0\bin;%path%
allure serve allure-results -h localhost
pause
exit