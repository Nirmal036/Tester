package stepdefintionfiles;

import pages.PgGmail;
import pages.PgNavigation;
import io.cucumber.java.en.*;

public class MapStepdefintionwithPages extends BaseStepdefintionClass{

	private PgNavigation pgNavigation;
	private PgGmail pgGmail;

	@Given("^User opens the (.*) browser$")
	public void userOpensTheChromeBrowser(String sBrowserName) throws Throwable {

		launchBrowser(sBrowserName);
	}

	@When("^User navigates to (.*) url$")
	public void launchURL(String sURL) throws Exception{

		pgNavigation = new PgNavigation(driver, extentReport.repoExtentTest);
		pgNavigation.navigateToURL(sURL, "Gmail");

	}

	@Then("^User completed the given test$")
	public void userCompletesTheGivenTest() throws Throwable {
		
		userCompletedTheGivenTest();
	}

	@And("^User enters the username as (.*) and password as (.*)$")
	public void userEntersTheUsernameAsTGmailComAsPasswordAsTester(String sUsername, String sPassword) throws Throwable {
		
		pgGmail = new PgGmail(driver, extentReport.repoExtentTest);
		pgGmail.enterCredentials(sUsername, sPassword);
	}

	@Then("^Gmail page should be opened$")
	public void gmailPageShouldBeOpened() throws Throwable {
		
		pgGmail.validateGmailOpened();
	}

	@Then("^Compose option should be present in the gmail$")
	public void composeOptionShouldBePresentInTheGmail() throws Throwable {
		
		pgGmail.validateComposeOption();
	}

	@When("^User clicks on the compose button$")
	public void userClicksOnTheComposeButton() throws Throwable {
		
		pgGmail.accessComposeOption();
	}

	@Then("^User enters the text of (.*) in the message body$")
	public void userEntersTheTextOfAutomationQATestForIncubyteInTheMessageBody(String sEnterText) throws Throwable {
		
		pgGmail.messageBodyValidation(sEnterText);
	}

	@Then("^User enters the text of (.*) in the subject$")
	public void userEntersTheTextOfIncubyteInTheSubject(String sEnterSubject) throws Throwable {
		
		pgGmail.subjectValidation(sEnterSubject);
	}

	@Then("^User sends the email to (.*)$")
	public void userSendsTheEmailToTGmailCom(String sUsername) throws Throwable {
	
		pgGmail.sentEmail(sUsername);
	}

}
