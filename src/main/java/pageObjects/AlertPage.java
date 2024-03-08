package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.SeleniumUtils;

public class AlertPage {

	/** WebDriver */
	private WebDriver driver;

	/** Selenium Utils */
	private SeleniumUtils seleniumUtils = new SeleniumUtils();

	// Elements
	private WebElement btnCookies;
	private WebElement btnSimpleAlert;
	private WebElement btnTimerAlert;
	private WebElement btnConfirmAlert;
	private WebElement btnPromptAlert;
	
	// Alerts
	private Alert simpleAlert;
	private Alert timedAlert;
	private Alert confirmBox;
	private Alert promptBox;

	// Prompt data
	private String promptData = "Nombre";

	// Locators
	private By byCookies = By.xpath("//div/child::button[@class='fc-button fc-cta-consent fc-primary-button']");
	private By bySimpleAlert = By.id("alertButton");
	private By byTimerAlert = By.id("timerAlertButton");
	private By byConfirmAlert = By.id("confirmButton");
	private By byPromptAlert = By.id("promtButton");

	public AlertPage(WebDriver driver) {
		setDriver(driver);
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Accepts the cookies.
	 * 
	 */
	public void acceptCookies() {
		btnCookies = seleniumUtils.waitForElement(driver, byCookies, 3);
		btnCookies.click();
	}

	/**
	 * Clicks the simple alert button.
	 * 
	 */
	public void simpleAlertButton() {
		btnSimpleAlert = seleniumUtils.waitForElement(driver, bySimpleAlert);
		btnSimpleAlert.click();
	}

	/**
	 * Dismisses the simple alert after finding it.
	 * 
	 */
	public void simpleAlert() {
		simpleAlert = seleniumUtils.switchToAlert(driver);
		simpleAlert.dismiss();
	}

	/**
	 * Clicks the timed alert button.
	 * 
	 */
	public void timerAlertButton() {
		btnTimerAlert = seleniumUtils.waitForElement(driver, byTimerAlert);
		btnTimerAlert.click();
	}

	/**
	 * Dismisses the timed alert after waiting for 5 seconds (+1 for assurance).
	 * 
	 */
	public void timerAlert() {
		timedAlert = seleniumUtils.switchToAlert(driver, 6);
		timedAlert.dismiss();
	}

	/**
	 * Clicks the confirm box button.
	 * 
	 */
	public void confirmAlertButton() {
		btnConfirmAlert = seleniumUtils.waitForElement(driver, byConfirmAlert);
		btnConfirmAlert.click();
	}

	/**
	 * Accepts the confirm box.
	 * 
	 */
	public void confirmAlert() {
		confirmBox = seleniumUtils.switchToAlert(driver);
		confirmBox.accept();
	}

	/**
	 * Clicks the prompt box button.
	 * 
	 */
	public void promptAlertButton() {
		btnPromptAlert = seleniumUtils.waitForElement(driver, byPromptAlert);
		btnPromptAlert.click();
	}

	/**
	 * Inputs into the prompt box and accepts it.
	 * 
	 */
	public void promptAlert() {
		promptBox = seleniumUtils.switchToAlert(driver);
		promptBox.sendKeys(promptData);
		promptBox.accept();
	}

}
