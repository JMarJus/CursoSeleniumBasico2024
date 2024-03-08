package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.SeleniumUtils;

public class EstadiodeportivoPage {

	/** WebDriver */
	private WebDriver driver;

	/** JavaScript Executor */
	private JavascriptExecutor jse;

	/** Selenium Utils */
	private SeleniumUtils seleniumUtils = new SeleniumUtils();

	// Elements
	private WebElement btnCookies;
	private WebElement icoBetis;
	private List<WebElement> news;
	private WebElement lblArticle;
	private List<WebElement> carrousel;
	private WebElement btnCarrouselNext;

	// Locators
	private By byCookies = By.xpath("//button[contains(text(),'Aceptar')]");
	private By byBetis = By.xpath("//img[contains(@alt,'Betis')]");
	private By byMainNews = By.xpath("//h2[@class='titular titulo-1']//child::a");
	private By byArticle = By.xpath("//h2[@class='titular titulo-1']");
	private By byCarrousel = By.xpath("//h2[@class='titular titulo-3']//child::a");
	private By byCarrouselNext = By.xpath("//div[@class='swiper-button-next1 boton redondo']");

	public EstadiodeportivoPage(WebDriver driver, JavascriptExecutor jse) {
		setDriver(driver);
		setJse(jse);
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void setJse(JavascriptExecutor jse) {
		this.jse = jse;
	}

	/**
	 * Accepts the cookies.
	 * 
	 * @param driver
	 */
	public void acceptCookies() {
		btnCookies = seleniumUtils.waitForElement(driver, byCookies, 5);
		btnCookies.click();
	}

	/**
	 * Inputs the first name.
	 * 
	 * @param driver
	 */
	public void clickBetis() {
		icoBetis = seleniumUtils.waitForElement(driver, byBetis);
		icoBetis.click();
	}

	/**
	 * Prints all the main news.
	 * 
	 * @param driver
	 */
	public void printMainNews() {
		news = driver.findElements(byMainNews);
		for (WebElement element : news) {
			System.out.println(element.getText());
		}
	}

	/**
	 * Accesses an article (the first one).
	 * 
	 * @param driver
	 */
	public void accessArticle() {
		lblArticle = seleniumUtils.waitForElement(driver, byArticle);
		lblArticle.click();
	}

	/**
	 * Prints first and last news from the carrousel.
	 * 
	 * @param driver
	 */
	public void printCarrousel() {
		carrousel = seleniumUtils.waitForElements(driver, byCarrousel);

		// Scrolls towards the end of the page
		seleniumUtils.scrollToPageEnd(jse);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}

		// Scrolls towards the end of the page
		seleniumUtils.scrollToPageEnd(jse);

		for (WebElement element : carrousel) {

			// Compares if the value equals 0 (the first) or the carrousel's size minus 1
			// (the last).
			if (carrousel.indexOf(element) == 0 || carrousel.indexOf(element) == carrousel.size() - 1) {

				// If it does, get the news title (stored in the attribute "title").
				String textToPrint = element.getAttribute("title");

				// Print the news title.
				System.out.println(textToPrint);
			}
		}
	}

	/**
	 * Accesses the last article from the carrousel.
	 * 
	 * @param driver
	 */
	public void accessLastArticleFromCarrousel() {
		carrousel = seleniumUtils.waitForElements(driver, byCarrousel);
		btnCarrouselNext = seleniumUtils.waitForElement(driver, byCarrouselNext);
		seleniumUtils.scrollToElement(driver, btnCarrouselNext, jse);

		// For every new in the carrousel, press the next button to move towards last
		// new unless it IS the last new, in which case clicks the link.
		for (WebElement element : carrousel) {

			// Compares if the value equals the carrousel's size minus 1 (the last).
			if (carrousel.indexOf(element) == carrousel.size() - 1) {

				// If it does, click the article.
				element.click();

			} else {
				btnCarrouselNext.click();
			}
		}

	}

}
