package testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.EstadiodeportivoPage;

/**
 * This Test Case contains the activities 01, 02 and 03.
 */
public class TestCaseEstadiodeportivo {

	/** WebDriver */
	private WebDriver driver;

	/** JavaScript Executor */
	private JavascriptExecutor jse;

	/** Page */
	private EstadiodeportivoPage page;

	// Website
	private String estadiodeportivoUrl = "https://www.estadiodeportivo.com/";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Path\\chromedriver.exe");
		driver = new ChromeDriver();
	  driver.manage().window().maximize();
		jse = (JavascriptExecutor) driver;
		page = new EstadiodeportivoPage(driver, jse);
	}

	@Test
	public void testCase() throws Exception {

		// Navigate to www.estadiodeportivo.com
		driver.get(estadiodeportivoUrl);

		System.out.println("Test Case 01 - Finished");
		
		// Accept cookies
		page.acceptCookies();

		// Click Betis icon
		page.clickBetis();

		// Print the text from each main new
		page.printMainNews();

		System.out.println("Test Case 02 - Finished");

		// Access a new (the first one)
		page.accessArticle();

		// Print first and last news from carrousel
		page.printCarrousel();

		// Access last article from carrousel
		page.accessLastArticleFromCarrousel();

		System.out.println("Test Case 03 - Finished");
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

}
