package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.SeleniumUtils;

public class ShadowRootPage {

	/** WebDriver */
	private WebDriver driver;

	/** Selenium Utils */
	private SeleniumUtils seleniumUtils = new SeleniumUtils();

	// Elements
	private WebElement btnCookies;
	private WebElement shadowRoot;
	private WebElement btnGenerate;
	private WebElement txtOutput;

	// Shadow Root's context
	private SearchContext shadowRootContext;

	// Locators
	private By byCookies = By.xpath("//div/child::button[@class='fc-button fc-cta-consent fc-primary-button']");
	private By byShadowRoot = By.tagName("guid-generator");
	private By byGUIDButton = By.id("buttonGenerate");
	private By byGUIDOutput = By.id("editField");

	public ShadowRootPage(WebDriver driver) {
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
	 * Obtains the Shadow Root's context.
	 * 
	 */
	public void shadowRootContext() {
		shadowRoot = seleniumUtils.waitForElement(driver, byShadowRoot);
		shadowRootContext = shadowRoot.getShadowRoot();
	}

	/**
	 * Clicks the button to generate the UID.
	 * 
	 */
	public void generateGUID() {
		btnGenerate = seleniumUtils.getShadowElement(shadowRootContext, byGUIDButton);
		btnGenerate.click();
	}

	/**
	 * Prints the generated UID.
	 * 
	 */
	public void printGUID() {
		txtOutput = seleniumUtils.getShadowElement(shadowRootContext, byGUIDOutput);
		System.out.println(txtOutput.getAttribute("value"));
	}

}
