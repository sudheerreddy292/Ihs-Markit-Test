package com.IhsMarkit.stepdefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.IhsMarkit.pageobjects.IhsMarkitTestPage;
import com.IhsMarkit.util.DriverFunctions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IhsMarkitTeststepdefs {
	IhsMarkitTestPage testPage=new IhsMarkitTestPage();
	DriverFunctions driverFunc=new DriverFunctions();
	@Given("user is on the web page")
	public void user_is_on_the_web_page() {
		testPage.waitForLogoElm();
	}

	@When("user clicks run button")
	public void user_clicks_run_button() {
	    testPage.clickRunButton();
	    driverFunc.waitForPageToLoad();
	}

	@Then("output window with Hello World text is displayed")
	public void output_window_with_Hello_World_text_is_displayed() {
		String outputValue=testPage.getOutputWindowText();
	    Assert.assertEquals(outputValue, "Hello World", outputValue+" the actual value doesnt match with expected value ");
	}
	
	@When("user first name {string} starts with any of the characters {string}")
	public void user_first_name_starts_with_any_of_the_characters(String firstName, String characterString) throws InterruptedException {    
		testPage.firstNameStartsWith(firstName, characterString);
		
		if (characterString.equals("A-B-C-D-E")) {
			testPage.selectPackage("NUnit", "3.12.0");
		}
		if (characterString.equals("F-G-H-I-J-K")) {
			testPage.clickShareButtonElm();
		}
		if (characterString.equals("L-M-N-O-P")) {
			testPage.clickOptionHideElm();
		}
		if (characterString.equals("Q-R-S-T-U")) {
			testPage.clickSaveButtonELm();
		}
		if (characterString.equals("V-W-X-Y-Z")) {
			testPage.clickGettingStartedBtnElm();
		}
	}

	@Then("the appropriate web UI actions will be appeared")
	public void the_appropriate_web_UI_actions_will_be_appeared() {
		String charString=System.getProperty("characterString");
		if (charString.equals("A-B-C-D-E")) {
			String packageAdded=testPage.getAddedPackageNameElm().getText().trim();
			Assert.assertEquals(packageAdded, "NUnit", packageAdded+" the added package is not showing up");
		}
		if (charString.equals("F-G-H-I-J-K")) {
			driverFunc.waitForElementValueToPresent(testPage.getShareLinkElm(), "https://dotnetfiddle.net/");
			String shareLinkText=testPage.getShareLinkElm().getAttribute("value");
			Assert.assertTrue(shareLinkText.startsWith("https://dotnetfiddle.net/"),shareLinkText +" share link is not starting with https://dotnetfiddle.net/");
		}
		if (charString.equals("L-M-N-O-P")) {
			String style=testPage.getOptionsPanelElm().getAttribute("style");
			Assert.assertNotEquals(style,"left: 0px;",style+ " options panel did not get closed");
		}
		if (charString.equals("Q-R-S-T-U")) {
			String loginModalClassAttr=testPage.getLoginModal().getAttribute("class");
			Assert.assertEquals(loginModalClassAttr,"modal fade in","Login Modal is not displayed");
		}
		if (charString.equals("V-W-X-Y-Z")) {
			try{
				Assert.assertTrue(testPage.getBackToEditorBtnElm().isDisplayed(),"Back to Editor button is not present on the page");
				Assert.assertTrue(testPage.getBackToEditorBtnElm().isEnabled(),"Back to Editor button is not enabled on the page");
				testPage.getBackToEditorBtnElm().click();
		}
			catch(Exception e){
				Assert.fail("Back to Editor button is not present on the page");
			}
		}
	}
	
}
