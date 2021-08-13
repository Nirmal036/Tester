package commonUtilities;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Screenshot {

	/**
	 * Method to take the screenshot and store it in the specified path
	 * @param driver pass the current driver instance
	 * @return the path of the screenshots
	 * @throws Exception
	 */

	public static final String getScreenshotAsPath(WebDriver driver) throws Exception{

		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/screenshots/" + ExtentReport.getTimeStamp() + ".png";
		FileUtils.copyFile(sourceFile, new File(path));
		return path;
	}
}
