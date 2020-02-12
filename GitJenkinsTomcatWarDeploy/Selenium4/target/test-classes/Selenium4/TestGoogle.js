require('geckodriver');
var webdriver = require('selenium-webdriver');
var driver = new webdriver.Builder()
  .forBrowser('firefox')
  .build();
driver.get('https://google.com');
