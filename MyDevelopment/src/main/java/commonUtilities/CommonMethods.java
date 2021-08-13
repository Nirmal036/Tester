package commonUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods {

	private WebDriver driver;

	public  CommonMethods(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Method to wait for the visibility of a by object for specified time period
	 * @param locator - Object to check the visibility
	 * @param timeOutinSeconds - Time period to wait for the object in seconds
	 * @return - true or false based on the visibility
	 * @throws Exception
	 */

	public boolean elementExists(By locator, int timeOutinSeconds) throws Exception {

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutinSeconds));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return true;
		}
		catch(Exception e)
		{
			System.out.println("The Element is not visible");
			return false;
		}
	}

	/**
	 * Method to check the object is clickable or not in the given time
	 * @param locator - Object to check the clickable
	 * @param timeOutinSeconds - Time period to wait for the object clickable in seconds
	 * @return - true or false based on the clickable
	 * @throws Exception
	 */

	public boolean elementClickable(By locator, int timeOutinSeconds) throws Exception{

		try
		{
			(new WebDriverWait(driver, Duration.ofSeconds(timeOutinSeconds))).until(ExpectedConditions.elementToBeClickable(locator));
			return true;
		}
		catch(TimeoutException e)
		{
			System.out.println("The Object is not clickable");
			return false;
		}
		catch(Exception e)
		{
			System.out.println("The Object is not clickable");
			return false;
		}

	}

	/**
	 * Method to check the object of webelement type is clickable or not in the given time
	 * @param element - webelement to check the clickable
	 * @param timeOutinSeconds - Time period to wait for the object clickable in seconds
	 * @return - true or false based on the clickable
	 *  @throws Exception
	 */

	public boolean elementClickable(WebElement element, int timeOutinSeconds) throws Exception {

		try
		{
			(new WebDriverWait(driver, Duration.ofSeconds(timeOutinSeconds))).until(ExpectedConditions.elementToBeClickable(element));
			return true;
		}
		catch(TimeoutException e)
		{
			System.out.println("The Element is not clickable");
			return false;
		}
		catch(Exception e)
		{
			System.out.println("The Element is not clickable");
			return false;
		}
	}

	/**
	 * Method to click on a object in the given time peroid
	 * @param locator - Object to click
	 * @param timeOutinSeconds
	 * @return - true or false based on the object visibility and click
	 * @throws Exception
	 */

	public boolean clickWhenVisible(By locator, int timeOutinSeconds) throws Exception{

		try
		{
			if(elementClickable(locator, timeOutinSeconds))
			{
				driver.findElement(locator).click();
				return true;
			}
			else
			{
				return false;
			}
		}

		catch(Exception e)
		{
			System.out.println("Unable to click on the Object");
			return false;
		}
	}

	/**
	 * Method to click on a web element in the given time peroid
	 * @param element - web element to click
	 * @param timeOutinSeconds
	 * @return - true or false based on the web element visibility and click
	 * @throws Exception
	 */

	public boolean clickWhenVisible(WebElement element, int timeOutinSeconds) throws Exception{

		try
		{
			if(elementClickable(element, timeOutinSeconds))
			{
				element.click();
				return true;
			}
			else
			{
				return false;
			}
		}

		catch(Exception e)
		{
			System.out.println("Unable to click on the Object");
			return false;
		}
	}

	/**
	 * Method to check the object is enabled or not
	 * @param locator - Object to check
	 * @param timeOutinSeconds - Time wait to wait till the enable in seconds
	 * @return - true or false based on the object enable
	 * @throws Exception
	 */

	public boolean isEnabled(By locator, int timeOutinSeconds) throws Exception{

		try
		{
			if(new WebDriverWait(driver, Duration.ofSeconds(timeOutinSeconds))
					.until(ExpectedConditions.visibilityOfElementLocated(locator)).isEnabled())
			{
				return true;
			}
			else
			{
				System.out.println("The Object is not enabled");
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("The Object is not enabled");
			return false;
		}
	}

	/**
	 * Method to check the web element is enabled or not
	 * @param element - Object to check
	 * @param timeOutinSeconds - Time wait to wait till the enable in seconds
	 * @return - true or false based on the web element enable
	 * @throws Exception
	 */

	public boolean isEnabled(WebElement element, int timeOutinSeconds) throws Exception{

		try
		{
			if(new WebDriverWait(driver, Duration.ofSeconds(timeOutinSeconds))
					.until(ExpectedConditions.visibilityOf(element)).isEnabled())
			{
				return true;
			}
			else
			{
				System.out.println("The Web Element is not enabled");
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("The Web Element is not enabled");
			return false;
		}
	}

	/**
	 * Method to enter the value in the object field
	 * @param locator - The object where we want to enter the text
	 * @param value - The value which we want to enter in the field
	 * @return - true or false based on the status
	 * @throws Exception
	 */

	public boolean enterValueWhenVisible(By locator, String value) throws Exception{

		try
		{
			if(isEnabled(locator, 5))
			{
				clickWhenVisible(locator, 5);
				driver.findElement(locator).sendKeys(value);
				return true;
			}
			else
			{
				System.out.println("The Object is not enabled");
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("Unable to enter the value");
			return false;
		}
	}

	/**
	 * Method to enter the value in the web element field
	 * @param element - The web element field where we want to enter the text
	 * @param value - The value which we want to enter in the field
	 * @return - true or false based on the status
	 * @throws Exception
	 */

	public boolean enterValueWhenVisible(WebElement element, String value) throws Exception{

		try
		{
			if(isEnabled(element, 5))
			{
				clickWhenVisible(element, 5);
				element.sendKeys(value);
				return true;
			}
			else
			{
				System.out.println("The web element is not enabled");
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("Unable to enter the value");
			return false;
		}
	}

	/**
	 * Method to select the given text in the object
	 * @param locator - The object where we want to select the text
	 * @param value - The value which we want to select in the field
	 * @return - true or false based on the status
	 * @throws Exception
	 */

	public boolean selectValueWhenVisibile(By locator, String value) throws Exception{

		try
		{
			if(this.clickWhenVisible(locator, 5))
			{
				new Select(driver.findElement(locator)).selectByVisibleText(value);
				return true;
			}
			else
			{
				System.out.println("Unable to select the given text in the field");
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("Unable to select the value in the object");
			return false;
		}

	}
}

