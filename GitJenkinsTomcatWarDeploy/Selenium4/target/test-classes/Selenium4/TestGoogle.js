//using java script
// need to install node js
//1. need to install selenium webdriver through npm(npm install selenium-webdriver)
// 2. need to install chrome/geckodriver using npm(npm install chromedriver)
// ex: https://www.npmjs.com/package/selenium-webdriver
require('geckodriver');
var webdriver = require('selenium-webdriver');
var driver = new webdriver.Builder()
  .forBrowser('firefox')
  .build();
driver.get('https://google.com');
