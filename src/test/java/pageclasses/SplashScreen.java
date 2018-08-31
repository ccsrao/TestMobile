package pageclasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utilities.MobileBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

@SuppressWarnings("unused")
public class SplashScreen extends MobileBase {
	AppiumDriver<MobileElement> appiumDriver;
	public SplashScreen(AppiumDriver<MobileElement> appiumDriver) {
		this.appiumDriver = appiumDriver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	@FindBy(how = How.XPATH, using = "//android.widget.TextView[@resource-id='co.legion.client.staging:id/loginBTN']")	
	private MobileElement	loginBtn;
	public String clkLoginBtn() {
		waitForExpectedElement(appiumDriver, loginBtn, 120);		
		String text = loginBtn.getText();
		loginBtn.click();
		return text;
	}
}