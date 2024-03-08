package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.SeleniumUtils;

public class FormPageAmazon {

	/** WebDriver */
	private WebDriver driver;

	/** Selenium Utils */
	private SeleniumUtils seleniumUtils = new SeleniumUtils();

	// Elements
	private WebElement acceptCookies;
	private WebElement searchTab;
	private List<WebElement> amazonLinks;
	private WebElement rightButton;
	private WebElement amazonCookies;
	private WebElement priceTagWhole;
	private WebElement priceTagDecimal;
	private WebElement priceTagUnit;
	private WebElement deliveryInfo;
	private WebElement amazonSearchTab;
	private WebElement primeCheckBox;
	private WebElement orderDropdown;
	private WebElement orderItem;
	private List<WebElement> results;
	private WebElement resultTitle;
	private WebElement resultPriceTagWhole;
	private WebElement resultPriceTagDecimal;
	private WebElement resultPriceTagUnit;

	// Final strings
	private final String productSearch = "compresor electrico";
	private final String searchOrder = "Precio: De menor a mayor";

	// Locators
	private final By acceptCookiesLocator = By
			.xpath("//div[@role='dialog']//child::button//child::div[contains(text(),'Aceptar')]");
	private final By searchTabLocator = By.xpath("//form[@role='search']//child::textarea[@title='Buscar']");
	private final By amazonLinksLocator = By
			.xpath("//span[contains(text(),'Amazon.es')]/parent::div/parent::div/parent::div/parent::div");
	private final By rightButtonLocator = By.xpath("//g-right-button");
	private final By amazonCookiesLocator = By.xpath("//input[contains(@id,'accept')]");
	private final By priceTagWholeLocator = By
			.xpath("//div[contains(@id,'corePriceDisplay')]//child::span[contains(@class,'whole')]");
	private final By priceTagDecimalLocator = By
			.xpath("//div[contains(@id,'corePriceDisplay')]//child::span[contains(@class,'fraction')]");
	private final By priceTagUnitLocator = By
			.xpath("//div[contains(@id,'corePriceDisplay')]//child::span[contains(@class,'symbol')]");
	private final By deliveryInfoLocator = By.xpath("//span[contains(@data-csa-c-delivery-type,'Entrega')]");
	private final By amazonSearchTabLocator = By.xpath("//input[contains(@id,'search')]");
	private final By primeCheckBoxLocator = By.xpath(
			"//div[@id='primeRefinements']//child::*[contains(@id,'free_shipping')]//child::div[contains(@class,'checkbox')]");
	private final By orderDropdownLocator = By.xpath("//span[text()='Ordenar por:']");
	private final By orderItemLocator = By
			.xpath("//select[@id='s-result-sort-select']//following::a[text()='" + searchOrder + "']");
	private final By resultsLocator = By.xpath("//div[@data-component-type='s-search-result']");
	private final By resultTitleLocator = By.xpath(".//child::span[@class='a-size-medium a-color-base a-text-normal']");
	private final By resultPriceTagWholeLocator = By.xpath(".//child::span[contains(@class,'whole')]");
	private final By resultPriceTagDecimalLocator = By.xpath(".//child::span[contains(@class,'fraction')]");
	private final By resultPriceTagUnitLocator = By.xpath(".//child::span[contains(@class,'symbol')]");

	/**
	 * Constructor by WebDriver
	 * 
	 * @param driver WebDriver
	 */
	public FormPageAmazon(WebDriver driver) {
		setDriver(driver);
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method inputs the searched product into the Google search tab and
	 * presses ENTER.
	 */
	public void acceptCookies() {
		// Get cookies button after 3 secs
		acceptCookies = seleniumUtils.waitForElement(driver, acceptCookiesLocator, 3);

		// Clicks on it
		acceptCookies.click();

	}

	/**
	 * This method inputs the searched product into the Google search tab and
	 * presses ENTER.
	 */
	public void searchProductGoogle() {
		// Get search input form
		searchTab = seleniumUtils.waitForElement(driver, searchTabLocator, 2);

		// Input search concept
		searchTab.sendKeys(productSearch);

		// Press ENTER
		searchTab.sendKeys(Keys.ENTER);

	}

	/**
	 * This method selects the first result from Amazon at the carrousel
	 * 
	 * @return If a link to Amazon is found
	 */
	public boolean selectAmazonResult() {
		// Get all links from Amazon inside the carrousel
		amazonLinks = seleniumUtils.waitForElements(driver, amazonLinksLocator, 5);

		// If the list contains at least one element, click on the first (only after it
		// is displayed, else keep pressing the right button)
		if (amazonLinks.size() >= 1) {
			rightButton = seleniumUtils.waitForElement(driver, rightButtonLocator);

			for (;;) {
				if (amazonLinks.get(0).isDisplayed()) {
					amazonLinks.get(0).click();
					break;

				} else {
					rightButton.click();
				}
			}

			return true;

		} else {
			return false;
		}

	}

	/**
	 * Gets Amazon ready by bypassing the captcha and accepting the cookies
	 */
	public void loadAmazonProperly() {
		// Get tabs
		List<String> tabs = new ArrayList<>(driver.getWindowHandles());

		// Switch to tab just created
		driver.switchTo().window(tabs.get(1));

		// Refresh some times the page to bypass bot detection
		while (amazonCookies == null) {
			try {
				// Accept cookies
				amazonCookies = seleniumUtils.waitForElement(driver, amazonCookiesLocator, 3);
			} catch (Exception e) {
				driver.navigate().refresh();
			}
		}
		amazonCookies.click();
	}

	/**
	 * Prints the price tag and delivery date
	 */
	public void printPriceAndDate() {
		// Get price tag
		priceTagWhole = seleniumUtils.waitForElement(driver, priceTagWholeLocator);
		priceTagDecimal = seleniumUtils.waitForElement(driver, priceTagDecimalLocator);
		priceTagUnit = seleniumUtils.waitForElement(driver, priceTagUnitLocator);

		// Compose price string
		System.out.println(priceTagWhole.getText() + "," + priceTagDecimal.getText() + " " + priceTagUnit.getText());

		// Get delivery date info
		deliveryInfo = seleniumUtils.waitForElement(driver, deliveryInfoLocator);

		// Compose delivery date string
		System.out.println(deliveryInfo.getAttribute("data-csa-c-delivery-time"));

	}

	/**
	 * Searches the same product again through the Amazon search tab
	 */
	public void searchProductAmazon() {
		// Search product through amazon search tab
		amazonSearchTab = seleniumUtils.waitForElement(driver, amazonSearchTabLocator);
		amazonSearchTab.sendKeys(productSearch);
		amazonSearchTab.sendKeys(Keys.ENTER);

	}

	/**
	 * Clicks the Prime delivery checkbox
	 */
	public void filterPrime() {
		// Click prime delivery filter checkbox
		primeCheckBox = seleniumUtils.waitForElement(driver, primeCheckBoxLocator, 3);
		primeCheckBox.click();

	}

	/**
	 * Order by price (ascended)
	 */
	public void orderByPriceAsc() {
		// Click order items dropdown
		orderDropdown = seleniumUtils.waitForElement(driver, orderDropdownLocator);
		orderDropdown.click();

		// Click desired order item
		orderItem = seleniumUtils.waitForElement(driver, orderItemLocator);
		orderItem.click();

	}

	/**
	 * Print all results
	 */
	public void printAllResultsNameAndPriceFirstPage() {
		// Get list of all results from first page (that is, the current visible page)
		results = seleniumUtils.waitForElements(driver, resultsLocator, 2);
		
		// For each one of the results, print their title and the corresponding price
		// tag
		for (WebElement result : results) {
			// Get titles
			resultTitle = seleniumUtils.getChild(result, resultTitleLocator);
			System.out.println(resultTitle.getText());

			try {
				// Get price tags
				resultPriceTagWhole = seleniumUtils.getChild(result, resultPriceTagWholeLocator);
				resultPriceTagDecimal = seleniumUtils.getChild(result, resultPriceTagDecimalLocator);
				resultPriceTagUnit = seleniumUtils.getChild(result, resultPriceTagUnitLocator);
				System.out.println(
						resultPriceTagWhole.getText() + "," + resultPriceTagDecimal.getText() + " " + resultPriceTagUnit.getText());
			} catch (Exception e) {}

		}

	}

}
