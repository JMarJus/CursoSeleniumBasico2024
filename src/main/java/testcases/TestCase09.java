package testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.ShadowRootPage;

public class TestCase09 {

	/** WebDriver */
	private WebDriver driver;

	/** Page */
	private ShadowRootPage pageObject;

	// Website
	private String guidUrl = "http://uitestingplayground.com/shadowdom";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Path\\chromedriver.exe");
		driver = new ChromeDriver();
	  driver.manage().window().maximize();
		pageObject = new ShadowRootPage(driver);
	}
	
	@Test
	public void testCase09() throws Exception {
		driver.get(guidUrl);

		pageObject.shadowRootContext();
		pageObject.generateGUID();
		pageObject.printGUID();

		System.out.println("Test Case 09 - Finished");
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
