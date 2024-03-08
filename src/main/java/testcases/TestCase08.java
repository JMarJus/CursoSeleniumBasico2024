package testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.IFramePage;
 
public class TestCase08 {

	/** WebDriver */
	private WebDriver driver;

	/** Page */
	private IFramePage pageObject;
	

	// Website
	private String nestedFramesUrl = "https://demoqa.com/nestedframes";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Path\\chromedriver.exe");
		driver = new ChromeDriver();
	  driver.manage().window().maximize();
		pageObject = new IFramePage(driver);
	}

	@Test
	public void testCase08() throws Exception {
		driver.get(nestedFramesUrl);
		
		pageObject.acceptCookies();
		pageObject.switchToFirstFrame();
		pageObject.printFirstText();
		pageObject.switchToSecondFrame();
		pageObject.printSecondText();
		
		System.out.println("Test Case 08 - Finished");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
