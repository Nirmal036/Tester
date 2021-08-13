package pages;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import commonUtilities.Screenshot;


public class PgNavigation {

	private WebDriver driver;
	private ExtentTest extentTest;

	public PgNavigation(WebDriver driver, ExtentTest extentTest){

		this.driver = driver;
		this.extentTest = extentTest;
	}

	/**
	 * Method to navigate to the given url
	 * @param sURL enter the url in the string format
	 * @throws Exception
	 */

	public void navigateToURL(String sURL, String sTitle) throws Exception{

		try
		{
			driver.get(sURL);
			if(driver.getTitle().equals(sTitle))
			{
				extentTest.log(Status.PASS,  "The given url : " + sURL + " is opened successfully" );
//				extentTest.info("", MediaEntityBuilder
//		                .createScreenCaptureFromPath(Screenshot.getScreenshotAsPath(driver)).build());
//				extentTest.info("", MediaEntityBuilder
//		                .createScreenCaptureFromPath(Screenshot.getScreenshotAsPath(driver)).build());

				
			}
			else 
			{
				extentTest.log(Status.FAIL, "The given url : " + sURL + " is not opened");
			}

		} 
		catch (Exception e)
		{
			extentTest.log(Status.FAIL, "Exception Occured while navigating to this url : " + sURL);
		}

	}
	
}
