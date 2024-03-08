package testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.FormPageXPath;

public class TestCase05 {

	/** WebDriver */
	private WebDriver driver;

	/** JavaScript Executor */
	private JavascriptExecutor jse;

	/** Page */
	private FormPageXPath pageObject;

	// Website
	private String demoqaUrl = "https://demoqa.com/automation-practice-form";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Path\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		jse = (JavascriptExecutor) driver;
		pageObject = new FormPageXPath(driver, jse);
	}

	@Test
	public void testCase05() throws Exception {
		driver.get(demoqaUrl);

		pageObject.removeObstacleAd();
		pageObject.acceptCookies();
		pageObject.inputFirstName();
		pageObject.inputLastName();
		pageObject.inputUserEmail();
		pageObject.selectRadioButton();
		pageObject.inputPhoneNumber();
		pageObject.inputDateOfBirth();
		pageObject.inputSubjects();
		pageObject.inputHobbies();
		pageObject.inputPicture();
		pageObject.inputAddress();
		pageObject.inputState();
		pageObject.inputCity();
		pageObject.submit();

		System.out.println("Test Case 05 - Finished");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}