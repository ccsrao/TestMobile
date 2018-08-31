package testclasses;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.ConfigFilesUtility;

import pageclasses.SplashScreen;
import utilities.MobileBase;

public class MobileTest extends MobileBase {
	ExtentReports report;
	ExtentTest test;
	ConfigFilesUtility configFileObj;

	public MobileTest() throws Exception {
		configFileObj = new ConfigFilesUtility();
		configFileObj.loadPropertyFile("MobileTest.properties");
		report = new ExtentReports(projectPath + File.separator + "MobileReports" + File.separator + "ExtentReportResults.html");
	}
	@BeforeClass
	public void launchMobileApp() throws Exception {
		mobileAppLaunch("D:\\18-06-FrameworkGit\\Framework\\mobile\\android\\app-staging-debug.apk", "1215fcadde7a1104");
	}
	@Test
	public void mobileTest() throws Exception {
		test = report.startTest("ExtentDemo");
		@SuppressWarnings("unchecked")
		SplashScreen objSplashScreen = new SplashScreen(appiumDriver);
		String element = objSplashScreen.clkLoginBtn();
		System.out.println(element);
		test.log(LogStatus.INFO, element);
	}

	@AfterClass
	public void tearDown() {
		appiumDriver.quit();
		report.endTest(test);
		report.flush();
	}
}
