package commonUtilities;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	
	/**
	 * Method to implicitly wait for the given time
	 * @param driver pass the webdriver
	 * @param timeSeconds enter the time seconds to wait
	 */
	
	public static final void implicitWait(WebDriver driver, int timeSeconds)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeSeconds)) ;
	}
	
	public static final void waitForTime(int timeSeconds) {
		
		try 
		{
			Thread.sleep(timeSeconds*1000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
