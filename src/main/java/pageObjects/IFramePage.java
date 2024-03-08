package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.SeleniumUtils;

public class IFramePage {

	/** WebDriver */
	private WebDriver driver;

	/** Selenium Utils */
	private SeleniumUtils seleniumUtils = new SeleniumUtils();

	// Elements
	private WebElement btnCookies;
	private WebElement frameOne;
	private WebElement frameOneText;
	private WebElement frameTwo;
	private WebElement frameTwoText;

	// Frame drivers
	private WebDriver frameOneDriver;
	private WebDriver frameTwoDriver;

	// Locators
	private By byCookies = By.xpath("//div/child::button[@class='fc-button fc-cta-consent fc-primary-button']");
	private By byFrame = By.tagName("iframe");
	private By byFrameOneText = By.xpath("//body");
	private By byFrameTwoText = By.tagName("p");

	public IFramePage(WebDriver driver) {
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
	 * Switches the driver to the first frame's.
	 */
	public void switchToFirstFrame() {
		frameOne = seleniumUtils.waitForElement(driver, byFrame);
		frameOneDriver = seleniumUtils.switchToFrame(driver, frameOne);
	}

	/**
	 * Prints the text found in the first frame using its driver.
	 */
	public void printFirstText() {
		frameOneText = seleniumUtils.waitForElement(frameOneDriver, byFrameOneText);
		System.out.println(frameOneText.getText());
	}

	/**
	 * Switches the driver to the second frame's.
	 */
	public void switchToSecondFrame() {
		frameTwo = seleniumUtils.waitForElement(frameOneDriver, byFrame);
		frameTwoDriver = seleniumUtils.switchToFrame(frameOneDriver, frameTwo);
	}

	/**
	 * Prints the text found in the second frame using its driver.
	 */
	public void printSecondText() {
		frameTwoText = seleniumUtils.waitForElement(frameTwoDriver, byFrameTwoText);
		System.out.println(frameTwoText.getAttribute("innerHTML"));
	}

}
