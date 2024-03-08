package utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains various methods to simplify the task of completing the
 * TestCases and make the code more efficient and understandable.
 */
public class SeleniumUtils {

	/**
	 * Returns a WebElement found through its locator only after it is present.
	 * 
	 * @param driver  WebDriver
	 * @param locator By
	 * @return
	 */
	public WebElement waitForElement(WebDriver driver, By locator) {

		// Instantiates the WebDriverWait with the given driver and seconds.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

		// Waits for the element to exist.
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		// Returns the found element.
		return element;
	}

	/**
	 * Returns a WebElement found through its locator only after it is present and
	 * after waiting a given amount of seconds.
	 * 
	 * @param driver  WebDriver
	 * @param locator By
	 * @param seconds Integer
	 * @return
	 */
	public WebElement waitForElement(WebDriver driver, By locator, Integer seconds) {

		// Instantiates the WebDriverWait with the given driver and seconds.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

		// Waits for the element to exist.
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		// Returns the found element.
		return element;
	}

	/**
	 * Returns a WebElement found through its locator only after it is present.
	 * 
	 * @param driver  WebDriver
	 * @param parent	WebElement
	 * @param locator By
	 * @return
	 */
	public WebElement getChild(WebElement parent, By locator) {

		// Waits for the element to exist.
		WebElement element = parent.findElement(locator);

		// Returns the found element.
		return element;
	}

	/**
	 * Returns a WebElement found through its locator inside a Shadow Root context.
	 * 
	 * @param context SearchContext
	 * @param locator By
	 * @return
	 */
	public WebElement getShadowElement(SearchContext context, By locator) {

		// Finds an element through the given Shadow Root context
		WebElement element = context.findElement(locator);

		// Returns the found element.
		return element;
	}

	/**
	 * Clicks on a given WebElement only after it is clickable.
	 * 
	 * @param element WebElement
	 * @param driver  WebDriver
	 * @param seconds Integer
	 */
	public void clickOnElement(WebElement element, WebDriver driver, Integer seconds) {

		// Instantiates the WebDriverWait with the given driver and seconds.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

		// Waits for the element to be clickable.
		wait.until(ExpectedConditions.elementToBeClickable(element));

		// Clicks the element.
		element.click();
	}

	/**
	 * Returns a list of multiple WebElements that use the same locator only after
	 * they are present.
	 * 
	 * @param driver  WebDriver
	 * @param locator By
	 * @return
	 */
	public List<WebElement> waitForElements(WebDriver driver, By locator) {

		// Instantiates the WebDriverWait with the given driver and seconds.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

		// Find multiple elements using the given driver through the locator.
		List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

		// Returns the found list.
		return elements;
	}

	/**
	 * Returns a list of multiple WebElements that use the same locator only after
	 * they are present and after waiting a given amount of secods.
	 * 
	 * @param driver  WebDriver
	 * @param locator By
	 * @return
	 */
	public List<WebElement> waitForElements(WebDriver driver, By locator, Integer seconds) {

		// Instantiates the WebDriverWait with the given driver and seconds.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

		// Find multiple elements using the given driver through the locator.
		List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

		// Returns the found list.
		return elements;
	}

	/**
	 * This method scrolls towards an element so it becomes clickable in case it
	 * wasn't being shown before.
	 * 
	 * @param driver  WebDriver
	 * @param element WebElement
	 * @param jse     JavascriptExecutor
	 * @return
	 */
	public WebElement scrollToElement(WebDriver driver, WebElement element, JavascriptExecutor jse) {

		// Scroll towards element directly
		Actions actions = new Actions(driver);
		actions.moveToElement(element);

		// Scroll a bit more to ensure visibility of the element
		jse.executeScript("window.scrollBy(0,20)");

		// Returns the found element.
		return element;
	}

	public void scrollToPageEnd(JavascriptExecutor jse) {
		jse.executeScript(
				"window.scrollTo(0, document.body.scrollHeight);var lenOfPage=document.body.scrollHeight;return lenOfPage;");
	}

	/**
	 * Returns the found alert.
	 * 
	 * @param driver WebDriver
	 * @return
	 */
	public Alert switchToAlert(WebDriver driver) {

		// Rapidly checks if the alert is present.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.alertIsPresent());

		// Returns the found alert.
		Alert alert = driver.switchTo().alert();
		return alert;
	}

	/**
	 * Returns the found alert after waiting the given seconds.
	 * 
	 * @param driver  WebDriver
	 * @param seconds Integer
	 * @return
	 */
	public Alert switchToAlert(WebDriver driver, Integer seconds) {

		// Checks if the alert is present after the given time.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.alertIsPresent());

		// Returns the found alert.
		Alert alert = driver.switchTo().alert();
		return alert;
	}

	/**
	 * Returns a new WebDriver focused on a given iFrame (WebElement).
	 * 
	 * @param driver WebDriver
	 * @param frame  WebElement
	 * @return
	 */
	public WebDriver switchToFrame(WebDriver driver, WebElement frame) {

		// Rapidly checks if the frame is available.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

		// Returns the found frame's WebDriver when it is available.
		WebDriver frameDriver = wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
		return frameDriver;
	}

	/**
	 * Returns a new WebDriver focused on a given iFrame (WebElement).
	 * 
	 * @param driver WebDriver
	 * @param frame  WebElement
	 * @return
	 */
	public void switchToTab(WebDriver driver) {
	}

	/**
	 * Returns a new WebDriver focused on a given iFrame (WebElement).
	 * 
	 * @param driver WebDriver
	 * @param frame  WebElement
	 * @return
	 */
	public void switchToTab(WebDriver driver, Integer tab) {
	}
}
