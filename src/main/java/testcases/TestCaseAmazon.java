package testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pageObjects.FormPageAmazon;

public class TestCaseAmazon {

	/** WebDriver */
	private WebDriver driver;

	/** Page */
	private FormPageAmazon pageObject;

	// Website
	private String url = "https://www.google.com/";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Path\\chromedriver.exe");
		// ChomeOptions: headless - It makes it so the test does not open a window
		ChromeOptions options = new ChromeOptions();
    options.addArguments("headless");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		pageObject = new FormPageAmazon(driver);
	}

	@Test
	public void testCase() throws Exception {
		driver.get(url);

		System.out.println("Task 1 - Finished");

		pageObject.acceptCookies();
		pageObject.searchProductGoogle();

		System.out.println("Task 2 - Finished");

		// If task 3 is succesful, continue. Else, abort.
		if (pageObject.selectAmazonResult()) {

			System.out.println("Task 3 - Finished");

			pageObject.loadAmazonProperly();
			pageObject.printPriceAndDate();

			System.out.println("Task 4 - Finished");

			pageObject.searchProductAmazon();

			System.out.println("Task 5 - Finished");

			// Clicking the order dropdown after clicking the delivery checkbox results in
			// the latter not taking effect. For this reason, both tasks have switched
			// places

			pageObject.orderByPriceAsc();

			System.out.println("Task 7 - Finished");

			pageObject.filterPrime();

			System.out.println("Task 6 - Finished");

			pageObject.printAllResultsNameAndPriceFirstPage();

			System.out.println("Task 8 - Finished");

		} else {
			System.out.println("Task 3 - Aborted: No Amazon links found at carrousel");
		}

	}

	@After
	public void tearDown() throws Exception {
	}

}
