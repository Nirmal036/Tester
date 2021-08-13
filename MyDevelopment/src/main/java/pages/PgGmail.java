package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import commonUtilities.CommonMethods;
import commonUtilities.Screenshot;
import commonUtilities.Wait;

public class PgGmail {

	private WebDriver driver;
	private CommonMethods commonMethods;
	private ExtentTest extentTest;

	public PgGmail(WebDriver driver, ExtentTest extentTest) {

		this.driver = driver;
		commonMethods = new CommonMethods(driver);
		this.extentTest = extentTest;
	}

	private By txtUserName = By.cssSelector("input[id$='identifierId']");
	private By btnNext = By.xpath("//span[text()='Next']");
	private By txtPassword = By.cssSelector("input[type='password']");
	private By imgGmail = By.cssSelector("img[src$='r2.png']");
	private By btnCompose = By.xpath("//div[text()='Compose']");
	private By messageBody = By.cssSelector("div[aria-label='Message Body']");
	private By subjectSection = By.cssSelector("input[name='subjectbox']");
	private By recipients = By.xpath("//div[text()='Recipients']");
	private By toAddress = By.cssSelector("textarea[name='to']");
	private By sendButton = By.xpath("//div[text()='Send']");

	/**
	 * Method to enter the credentials in the gmail
	 * @param sUserName enter the user name or email id
	 * @param sPassword enter the passwored
	 * @throws Exception
	 */

	public void enterCredentials(String sUserName, String sPassword) throws Exception{

		if(commonMethods.elementExists(txtUserName, 3))
		{
			commonMethods.enterValueWhenVisible(txtUserName, sUserName);
			extentTest.log(Status.INFO, "The User Name is entered");
			commonMethods.clickWhenVisible(btnNext, 3);
			if(commonMethods.elementExists(txtPassword, 3))
			{
				commonMethods.enterValueWhenVisible(txtPassword, sPassword);
				extentTest.log(Status.INFO, "Password is entered");
				commonMethods.clickWhenVisible(btnNext, 3);
				Wait.implicitWait(driver, 30);
			}
			else
			{
				extentTest.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.getScreenshotAsPath(driver), "The Password field is not visible").build());
			}

		}
		else
		{
			extentTest.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.getScreenshotAsPath(driver), "The User name is not visible").build());
		}
	}

	/**
	 * Method to validate the gmail the opened or not
	 * @throws Exception
	 */

	public void validateGmailOpened() throws Exception{

		if(commonMethods.elementExists(imgGmail, 15))
		{
			extentTest.log(Status.PASS, "Gmail is opened successfully");
		}
		else if(commonMethods.elementExists(txtPassword, 5))
		{
			extentTest.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.getScreenshotAsPath(driver), "Check the Credentials, not able to navigate to gmail").build());
		}
		else
		{
			extentTest.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.getScreenshotAsPath(driver), "Gmail is not opened").build());
		}
	}

	/**
	 * Method to validate the compose option is present or not
	 * @throws Exception
	 */

	public void validateComposeOption() throws Exception{

		if(commonMethods.elementExists(btnCompose, 5)) 
		{
			extentTest.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.getScreenshotAsPath(driver), "Compose Option is present").build());
			//extentTest.pass(MarkupHelper.createLabel("Test is Passed", ExtentColor.GREEN));
		}
		else
		{
			extentTest.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.getScreenshotAsPath(driver), "Compose Option is not present").build());
			//extentTest.fail(MarkupHelper.createLabel("Test is FAILED", ExtentColor.RED));
		}
	}

	/**
	 * Method to click on the compose option in gmail
	 * @throws Exception
	 */

	public void accessComposeOption() throws Exception{

		validateGmailOpened();
		validateComposeOption();
		commonMethods.clickWhenVisible(btnCompose, 5);
		Wait.implicitWait(driver, 10);

	}

	/**
	 * Method to enter the given text in the message body and validating it entered correctly
	 * @param sEnterText enter the text of the message body
	 * @throws Exception
	 */

	public void messageBodyValidation(String sEnterText) throws Exception{

		commonMethods.enterValueWhenVisible(messageBody, sEnterText);
		Wait.implicitWait(driver, 5);
		if(driver.findElement(messageBody).getText().equals(sEnterText))
		{
			extentTest.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.getScreenshotAsPath(driver), 
					"The Entered Text : " + sEnterText + " is present in the Message body").build());
			extentTest.pass(MarkupHelper.createLabel("Test is Passed", ExtentColor.GREEN));

		}
		else 
		{
			extentTest.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.getScreenshotAsPath(driver), 
					"The Entered Text : " + sEnterText + " is not present in the Message body").build());
			extentTest.fail(MarkupHelper.createLabel("Test is FAILED", ExtentColor.RED));
		}

	}

	/**
	 * Method to enter the given text in the Subject and validating it entered correctly
	 * @param sEnterText enter the text of the Subject of the email
	 * @throws Exception
	 */

	public void subjectValidation(String sEnterText) throws Exception{

		commonMethods.enterValueWhenVisible(subjectSection, sEnterText);
		Wait.implicitWait(driver, 10);
		if(driver.findElement(subjectSection).getAttribute("value").equals(sEnterText))
		{
			extentTest.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.getScreenshotAsPath(driver), 
					"The Entered Text : " + sEnterText + " is present in the Subject").build());
			extentTest.pass(MarkupHelper.createLabel("Test is Passed", ExtentColor.GREEN));

		}
		else 
		{
			extentTest.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.getScreenshotAsPath(driver), 
					"The Entered Text : " + sEnterText + " is not present in the Subject").build());
			extentTest.fail(MarkupHelper.createLabel("Test is FAILED", ExtentColor.RED));
		}

	}

	/**
	 * Method to send the email to the given email or user name
	 * @param sUserNameOrEmailId enter the email or user name
	 * @throws Exception
	 */

	public void sentEmail(String sUserNameOrEmailId) throws Exception{

		commonMethods.clickWhenVisible(recipients, 5);
		commonMethods.enterValueWhenVisible(toAddress, sUserNameOrEmailId);
		Wait.implicitWait(driver, 5);
		extentTest.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.getScreenshotAsPath(driver), 
				"Entered all the details - Sending the email").build());
		commonMethods.clickWhenVisible(messageBody, 3);
		Wait.waitForTime(3);
		commonMethods.clickWhenVisible(sendButton, 5);
		Wait.waitForTime(3);
		driver.navigate().refresh();
		Wait.waitForTime(5);
		extentTest.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.getScreenshotAsPath(driver), 
				"User is received the email successfully").build());
		extentTest.pass(MarkupHelper.createLabel("Test is Passed", ExtentColor.GREEN));
	}

}
