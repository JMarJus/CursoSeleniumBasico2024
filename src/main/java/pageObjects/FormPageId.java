package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.SeleniumUtils;

public class FormPageId {

	/** WebDriver */
	private WebDriver driver;

	/** JavaScript Executor */
	private JavascriptExecutor jse;

	/** Selenium Utils */
	private SeleniumUtils seleniumUtils = new SeleniumUtils();

	// Elements
	private WebElement btnCookies;
	private WebElement obstacleAd;
	private WebElement txtFirstName;
	private WebElement txtLastName;
	private WebElement txtUserEmail;
	private WebElement genderRadio;
	private WebElement hobbyCheckBox;
	private WebElement txtPhoneNumber;
	private WebElement txtDateOfBirth;
	private WebElement txtSubjectsInput;
	private WebElement urlUploadPicture;
	private WebElement txtCurrentAddress;
	private WebElement cmbState;
	private WebElement cmbCity;
	private WebElement btnSubmit;

	// Form data
	private String firstName = "Firstname";
	private String lastName = "Lastname";
	private Integer selectedRadio = 3;
	private String email = "user@email.com";
	private String phoneNumber = "9876543210";
	private String date = "01 Jan 2000";
	private Integer[] selectedCheckBoxes = { 1, 2 };
	private String photoUrl = "C:\\Users\\jmartjus\\OneDrive - NTT DATA EMEAL\\Desktop\\Multimedia\\Images\\foto.jpg";
	private String currentAddress = "Current Address";

	// Locators
	private By byObstacleAd = By.id("fixedban");
	private By byCookies = By.xpath("//div/child::button[@class='fc-button fc-cta-consent fc-primary-button']");
	private By byFirstName = By.id("firstName");
	private By byLastName = By.id("lastName");
	private By byUserEmail = By.id("userEmail");
	private By byPhoneNumber = By.id("userNumber");
	private By byDateOfBirth = By.id("dateOfBirthInput");
	private By bySubjectsInput = By.id("subjectsInput");
	private By byUploadPicture = By.id("uploadPicture");
	private By byAddress = By.id("currentAddress");
	private By byState = By.id("react-select-3-input");
	private By byCity = By.id("react-select-4-input");
	private By bySubmit = By.id("submit");

	/**
	 * Constructor by WebDriver and JavascriptExecutor
	 * 
	 * @param driver WebDriver
	 * @param jse    JavascriptExecutor
	 */
	public FormPageId(WebDriver driver, JavascriptExecutor jse) {
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
	 * Removes the obstaculizing add at the bottom of the screen.
	 */
	public void removeObstacleAd() {
		obstacleAd = seleniumUtils.waitForElement(driver, byObstacleAd, 3);
		jse.executeScript("arguments[0].style.visibility='hidden'", obstacleAd);
	}

	/**
	 * Accepts the cookies.
	 */
	public void acceptCookies() {
		btnCookies = seleniumUtils.waitForElement(driver, byCookies, 3);
		btnCookies.click();
	}

	/**
	 * Inputs the first name.
	 */
	public void inputFirstName() {
		txtFirstName = seleniumUtils.waitForElement(driver, byFirstName);
		txtFirstName.sendKeys(firstName);
	}

	/**
	 * Inputs the last name.
	 */
	public void inputLastName() {
		txtLastName = seleniumUtils.waitForElement(driver, byLastName);
		txtLastName.sendKeys(lastName);
	}

	/**
	 * Inputs the eMail.
	 */
	public void inputUserEmail() {
		txtUserEmail = seleniumUtils.waitForElement(driver, byUserEmail);
		txtUserEmail.sendKeys(email);
	}

	/**
	 * Selects a specific radio button.
	 */
	public void selectRadioButton() {
		genderRadio = seleniumUtils.waitForElement(driver, By.id("gender-radio-" + selectedRadio));
		jse.executeScript("arguments[0].click();", genderRadio);
	}

	/**
	 * Inputs the phone number.
	 */
	public void inputPhoneNumber() {
		txtPhoneNumber = seleniumUtils.waitForElement(driver, byPhoneNumber);
		txtPhoneNumber.sendKeys(phoneNumber);
	}

	/**
	 * Replaces the default date of birth with the one we want.
	 */
	public void inputDateOfBirth() {
		txtDateOfBirth = seleniumUtils.waitForElement(driver, byDateOfBirth);
		txtDateOfBirth.sendKeys(Keys.CONTROL + "a"); // Select all
		txtDateOfBirth.sendKeys(date); // Replace
		txtDateOfBirth.sendKeys(Keys.ENTER); // Enter to close date selector
	}

	/**
	 * Inputs the subject and selects it.
	 */
	public void inputSubjects() {
		txtSubjectsInput = seleniumUtils.waitForElement(driver, bySubjectsInput);
		txtSubjectsInput.sendKeys("Maths");
		txtSubjectsInput.sendKeys(Keys.ENTER); // Enter to select Maths from dropdown
	}

	/**
	 * Selects the hobby checkboxes.
	 */
	public void inputHobbies() {
		for (Integer i : selectedCheckBoxes) {
			hobbyCheckBox = seleniumUtils.waitForElement(driver, By.id("hobbies-checkbox-" + i));
			jse.executeScript("arguments[0].click();", hobbyCheckBox);
		}
	}

	/**
	 * Inputs the picture url.
	 */
	public void inputPicture() {
		urlUploadPicture = seleniumUtils.waitForElement(driver, byUploadPicture);
		urlUploadPicture.sendKeys(photoUrl);
	}

	/**
	 * Inputs the address.
	 */
	public void inputAddress() {
		txtCurrentAddress = seleniumUtils.waitForElement(driver, byAddress);
		txtCurrentAddress.sendKeys(currentAddress);
	}

	/**
	 * Inputs the state and selects it.
	 */
	public void inputState() {
		cmbState = seleniumUtils.waitForElement(driver, byState);
		cmbState.sendKeys("NCR");
		cmbState.sendKeys(Keys.ENTER);
	}

	/**
	 * Inputs the city and selects it.
	 */
	public void inputCity() {
		cmbCity = seleniumUtils.waitForElement(driver, byCity);
		cmbCity.sendKeys("Delhi");
		cmbCity.sendKeys(Keys.ENTER);
	}

	/**
	 * Submits the form.
	 */
	public void submit() {
		btnSubmit = seleniumUtils.waitForElement(driver, bySubmit);
		seleniumUtils.scrollToElement(driver, btnSubmit, jse);
		btnSubmit.sendKeys(Keys.ENTER);
	}

}