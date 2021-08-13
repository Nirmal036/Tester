package commonUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	ExtentReports extentReport;
	ExtentSparkReporter extentSparkReporter;
	public ExtentTest repoExtentTest;

	public ExtentReport() {

		extentReport = new ExtentReports();
		extentSparkReporter = new ExtentSparkReporter("target/" + getTimeStamp() + ".html");
		extentReport.attachReporter(extentSparkReporter);
	}

	/**
	 * Method to create a new Extent test
	 * @param sTestName enter the name of the test
	 */

	public void createNewTest(String sTestName)
	{
		repoExtentTest = extentReport.createTest(sTestName);
	}

	/**
	 * Method to close the instance of the extent report
	 */

	public void closeReport() {

		extentReport.flush();
	}

	/**
	 * Method to write the log message in the extent report
	 * @param sStatus enter the status of the log
	 * @param sMessage enter the log message to print with the status
	 */

	public void writeLog(String sStatus, String sMessage) {

		switch (sStatus.toUpperCase()) {

		case "PASS" : repoExtentTest.log(Status.PASS, sMessage); break;
		case "FAIL" : repoExtentTest.log(Status.FAIL, sMessage); break;
		case "INFO" : repoExtentTest.log(Status.INFO, sMessage); break;
		default   : repoExtentTest.log(Status.FAIL, "Entered invalid log status : " + sStatus);
		}

	}

	/**
	 * Method to get the current date and time
	 * @return
	 */

	public static String getTimeStamp(){

		return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	}

}
