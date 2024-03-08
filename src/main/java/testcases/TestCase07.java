package testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.AlertPage;

public class TestCase07 {

	/** WebDriver */
	private WebDriver driver;

	/** Page */
	private AlertPage pageObject;
	
	// Website
	private String alertsUrl = "https://demoqa.com/alerts";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Path\\chromedriver.exe");
		driver = new ChromeDriver();
	  driver.manage().window().maximize();
		pageObject = new AlertPage(driver);
	}
	
	@Test
	public void testCase07() throws Exception {
		driver.get(alertsUrl);
		
		pageObject.acceptCookies();
		pageObject.simpleAlertButton();
		pageObject.simpleAlert();
		pageObject.timerAlertButton();
		pageObject.timerAlert();
		pageObject.confirmAlertButton();
		pageObject.confirmAlert();
		pageObject.promptAlertButton();
		pageObject.promptAlert();

		System.out.println("Test Case 07 - Finished");
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
