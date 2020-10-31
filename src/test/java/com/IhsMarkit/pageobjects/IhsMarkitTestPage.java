package com.IhsMarkit.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.IhsMarkit.keys.Keys;
import com.IhsMarkit.keys.Keys.IhsMarkitTestLocators;
import com.IhsMarkit.stepdefs.Hooks;
import com.IhsMarkit.util.DriverFunctions;

public class IhsMarkitTestPage extends Hooks implements IhsMarkitTestLocators{
	WebDriver driver=Hooks.getDriver();
		
	@FindBy(id=RUN_BUTTON)
	WebElement runButtonElm;
	
	@FindBy(id=OUTPUT_PANEL)
	WebElement outputPanelElm;
	
	@FindBy(xpath=SEARCH_PACKAGE_INPUT)
	WebElement searchPackageInputElm;
	
	@FindBy(className=ADDED_PACKAGE_NAME)
	WebElement addedPackageNameElm;
	
	@FindBy(id=SHARE_BUTTON)
	WebElement shareButtonElm;
	
	@FindBy(xpath=OPTION_HIDE)
	WebElement hideOptionsButtonElm;
	
	@FindBy(xpath=OPTIONS_PANEL)
	WebElement optionsPanelElm;
	
	@FindBy(id=SAVE_BUTTON)
	WebElement saveBtnElm;
	
	@FindBy(id=LOGIN_MODAL)
	WebElement loginModalElm;
	
	@FindBy(linkText=GETTING_STARTED_BUTTON)
	WebElement gettingStartedBtnElm;
	
	@FindBy(linkText=BACK_TO_EDITOR_BUTTON)
	WebElement backToEditorBtnElm;
	
	DriverFunctions driverUtil=new DriverFunctions();

	 public IhsMarkitTestPage() {
		 PageFactory.initElements(Hooks.getDriver(), this);
	}
	
	public void clickRunButton(){
		driverUtil.waitForElementToPresent(runButtonElm).click();
		
	}
	
	public String getOutputWindowText() {
		return driverUtil.waitForElementToPresent(outputPanelElm).getText();
	}
	
	private WebElement getPackageIdElm(String packageId) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		String xpathExpression=String.format(PACKAGE_ID, packageId);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
			return element;
	}
	
	private WebElement getversionNameElm(String versionName) {
		String xpathExpression=String.format(PACKAGE_VERSION_NAME, versionName);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
		return element;
	}
	
	public void selectPackage(String packageId,String versionName) throws InterruptedException {
		driverUtil.waitForPageToLoad();
		driverUtil.waitForElementToPresent(searchPackageInputElm);
		searchPackageInputElm.sendKeys(packageId);
		driverUtil.waitForPageToLoad();
		Actions actions=new Actions(driver);
		versionName=versionName+".0";
		actions.moveToElement(getPackageIdElm(packageId)).build().perform();
		driverUtil.waitForPageToLoad();
		getversionNameElm(versionName).click();
	}
	
	public WebElement getAddedPackageNameElm() {
		return driverUtil.waitForElementToPresent(addedPackageNameElm);
	}
	
	public void clickShareButtonElm(){
		driverUtil.waitForElementToPresent(shareButtonElm).click();
	}
	
	public WebElement getShareLinkElm() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SHARE_LINK)));
		return element;
	}
	
	public void clickOptionHideElm() {
		driverUtil.waitForElementToPresent(hideOptionsButtonElm).click();
	}
	
	public void firstNameStartsWith(String firstName, String characterString) {
		String[] characters= characterString.split("-");
		for (String charAlphabet : characters) {
			if (firstName.startsWith(charAlphabet)) {
				System.setProperty("characterString", characterString);
				break;
			}
		}
	}
	
	public WebElement getOptionsPanelElm() {
		return driverUtil.waitForElementToPresent(optionsPanelElm);
	}
	
	public void clickSaveButtonELm() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(SAVE_BUTTON))).click();
	}
	
	public WebElement getLoginModal() {
		return driverUtil.waitForElementToPresent(loginModalElm);
	}
	
	public void clickGettingStartedBtnElm() {
		driverUtil.waitForElementToPresent(gettingStartedBtnElm).click();
	}
	
	public WebElement getBackToEditorBtnElm() {
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(BACK_TO_EDITOR_BUTTON)));
//		return element;
		return driverUtil.waitForElementToPresent(backToEditorBtnElm);
	}
	
	public void waitForLogoElm() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LOGO)));
	}
	 
}
