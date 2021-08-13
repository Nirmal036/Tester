package stepdefintionfiles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.Status;

import commonUtilities.ExtentReport;

public class BaseStepdefintionClass {

	public WebDriver driver;
	public ExtentReport extentReport;


	private static String projectPath = System.getProperty("user.dir");

	public BaseStepdefintionClass() 
	{
		extentReport = new ExtentReport();
	}

	/**
	 * Method to launch the given browser
	 * @param sBrowserName enter the name of the browser
	 * @throws Exception
	 */

	public void launchBrowser(String sBrowserName) throws Exception {

		extentReport.createNewTest("Gmail Compose Validation");
		switch (sBrowserName.toUpperCase()) {

		case "CHROME" : launchChrome(); break;
		case "IE"     : launchIE(); break;
		//case "EDGE"   : launchEdge(); break;
		//case "FIREFOX": launchFirefox(); break;
		default : System.out.println("Please enter a valid browser name to continue....");
		}

	}

	/**
	 * Method to close all the driver and extent report instances
	 * @throws Throwable
	 */

	public void userCompletedTheGivenTest() throws Throwable {

		extentReport.closeReport();
		driver.quit();

	}

	/**
	 * Method to launch the chrome browser
	 * @throws Exception
	 */

	private void launchChrome() throws Exception{

		try
		{
			System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			extentReport.repoExtentTest.log(Status.PASS, "The Chrome Browser is launched");
		}
		catch(Exception e)
		{
			extentReport.writeLog("fail", "Error Occured while setting up the System Property and launching the Chrome Browser");
		}
	}

	/**
	 * Method to launch the IE browser
	 * @throws Exception
	 */

	private void launchIE() throws Exception{

		try 
		{
			System.setProperty("webdriver.ie.driver", projectPath + "/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}
		catch(Exception e)
		{
			extentReport.writeLog("fail", "Error Occured while setting up the System Property and launching the IE Browser");
		}
	}

}